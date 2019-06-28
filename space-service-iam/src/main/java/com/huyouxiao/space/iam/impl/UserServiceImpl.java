package com.huyouxiao.space.iam.impl;


import com.huyouxiao.space.common.enums.CredentialStatusEnum;
import com.huyouxiao.space.common.enums.CredentialTypeEnum;
import com.huyouxiao.space.common.enums.DataStatusEnum;
import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.enums.UserIdentityTypeEnum;
import com.huyouxiao.space.common.enums.UserStatusEnum;
import com.huyouxiao.space.common.exception.BusinessException;
import com.huyouxiao.space.common.mail.MailContentGenerator;
import com.huyouxiao.space.common.mail.MailService;
import com.huyouxiao.space.common.security.Encryption;
import com.huyouxiao.space.common.security.PasswordGenerator;
import com.huyouxiao.space.common.security.bean.EncryptionResult;
import com.huyouxiao.space.iam.UserService;
import com.huyouxiao.space.iam.request.SignUpRequest;
import com.huyouxiao.space.dao.entity.UserEntity;
import com.huyouxiao.space.dao.entity.UserCredentialEntity;
import com.huyouxiao.space.dao.entity.UserIdentityEntity;
import com.huyouxiao.space.dao.mapper.UserCredentialEntityMapper;
import com.huyouxiao.space.dao.mapper.UserIdentityEntityMapper;
import com.huyouxiao.space.dao.mapper.UserEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserEntityMapper userEntityMapper;

  @Autowired
  private UserCredentialEntityMapper userCredentialEntityMapper;


  @Autowired
  private UserIdentityEntityMapper userIdentityEntityMapper;

  @Autowired
  private MailService mailService;

  @Value("${space.one.time.password.length}")
  private Integer oneTimePasswordLength;


  @Value("${space.active.code.length}")
  private Integer activeCodeLength;


  @Override
  public void signUp(SignUpRequest request) {
    UserEntity user = checkPhoneExist(request.getPhone());
    checkMailExist(request.getEmail(), user);
    // TODO:
    createUserInfo(request, user);
  }

  private UserEntity checkPhoneExist(String phone) {
    UserEntity user = userEntityMapper.selectByUserPhone(phone);
    // phone is not used.
    if (null == user) {
      return null;
    }

    // the same user is already register but not active.
    if (UserStatusEnum.INACTIVE.name().equals(user.getStatus())) {
      return user;
    }

    log.warn("phone {} is already used by user_id:{}, user status:{}", user.getPhone(), user.getId(), user.getStatus());
    throw new BusinessException(ResultEnum.USER_PHONE_ALREADY_EXIST);
  }

  private void checkMailExist(String mail, UserEntity user) {
    UserIdentityEntity userIdentity = userIdentityEntityMapper.selectByValue(UserIdentityTypeEnum.EMAIL.name(), mail);

    // email is not used.
    if (null == userIdentity) {
      return;
    }

    // email is already registered but not active.
    if (null != user && user.getId().equals(userIdentity.getUserId())) {
      return;
    }

    // email is used by other people.
    log.warn("user identity {} is already exist for user id:{}, identity type:{}, identity value:{}", userIdentity.getUserId(), userIdentity.getIdentityType(), userIdentity.getIdentityValue());
    throw new BusinessException(ResultEnum.USER_PHONE_ALREADY_EXIST);
  }

  private void createUserInfo(SignUpRequest request, UserEntity user) {
    // generate one user
    if (null == user) {
      user = new UserEntity();
      user.setPhone(request.getPhone());
      user.setStatus(UserStatusEnum.INACTIVE.name());
      user.setDataStatus(DataStatusEnum.NORMAL.getCode());
      userEntityMapper.insert(user);
    } else {
      log.warn("user is already exist but not active. not create user again. but need obsolete previous setting password and one time password.");
      // delete email active code.
      userCredentialEntityMapper.obsoleteCredentialByType(user.getId(), CredentialTypeEnum.ACTIVE_CODE.getCode());
      // delete current one password.
      userCredentialEntityMapper.obsoleteCredentialByType(user.getId(), CredentialTypeEnum.ONE_TIME_PASSWORD.getCode());
      // delete current password.
      userCredentialEntityMapper.obsoleteCredentialByType(user.getId(), CredentialTypeEnum.PASSWORD.getCode());
    }
    // generate active code for email
    String activeCode = PasswordGenerator.generatePassword(activeCodeLength);
    EncryptionResult activeCodeEncryptionResult = Encryption.md5(activeCode);

    UserCredentialEntity activeCodeCredential = new UserCredentialEntity();
    activeCodeCredential.setUserId(user.getId());
    activeCodeCredential.setCredentialType(CredentialTypeEnum.ONE_TIME_PASSWORD.getCode());
    activeCodeCredential.setCredentialValue(activeCodeEncryptionResult.getOutput());
    activeCodeCredential.setStatus(CredentialStatusEnum.ACTIVE_CODE_NOT_USED.getStatus());
    activeCodeCredential.setDataStatus(DataStatusEnum.NORMAL.getCode());
    // set salt
    activeCodeCredential.setSalt(activeCodeEncryptionResult.getSalt());

    userCredentialEntityMapper.insert(activeCodeCredential);

    // generate one time password for active
    String oneTimePassword = PasswordGenerator.generateOTP(oneTimePasswordLength);
    EncryptionResult encryptionResult = Encryption.md5(oneTimePassword);

    UserCredentialEntity otpCredential = new UserCredentialEntity();
    otpCredential.setUserId(user.getId());
    otpCredential.setCredentialType(CredentialTypeEnum.ONE_TIME_PASSWORD.getCode());
    otpCredential.setCredentialValue(encryptionResult.getOutput());
    otpCredential.setStatus(CredentialStatusEnum.OTP_NOT_USED.getStatus());
    otpCredential.setDataStatus(DataStatusEnum.NORMAL.getCode());
    // set salt
    otpCredential.setSalt(encryptionResult.getSalt());

    userCredentialEntityMapper.insert(otpCredential);

    // save user password.
    UserCredentialEntity passwordCredential = new UserCredentialEntity();
    EncryptionResult passwordEncryptionResult = Encryption.md5(request.getPassword());

    passwordCredential.setUserId(user.getId());
    passwordCredential.setCredentialType(CredentialTypeEnum.PASSWORD.getCode());
    passwordCredential.setCredentialValue(passwordEncryptionResult.getOutput());
    passwordCredential.setStatus(CredentialStatusEnum.PASSWORD_NOT_ACTIVE.getStatus());
    passwordCredential.setDataStatus(DataStatusEnum.NORMAL.getCode());
    // set salt
    passwordCredential.setSalt(encryptionResult.getSalt());

    userCredentialEntityMapper.insert(passwordCredential);

    // send one time password to user.
    sendActiveEmail(request.getEmail(), user.getId(), activeCode, oneTimePassword);
  }

  private void sendActiveEmail(String email, Long userId, String activeCode, String oneTimePassword) {
    String content = MailContentGenerator.getActiveContent(email, userId, activeCode, oneTimePassword);
    mailService.sendMail(email, MailContentGenerator.mailActiveTitle, content);
  }
}