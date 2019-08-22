package com.huyouxiao.space.common.security;

import com.huyouxiao.space.common.security.bean.EncryptionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Slf4j
public class Encryption {

  private static Integer SALT_LENGTH = 8;

  @Autowired
  private static BASE64Encoder base64Encoder = new BASE64Encoder();


  @Autowired
  private static MessageDigest messageDigest;

  public static EncryptionResult md5(String input) {
    // generate one salt value.
    String salt = salt(input);

    String mixing = mixing(input, salt);

    String md5 = encryptMD5(mixing);

    return new EncryptionResult(salt, md5);
  }

  private static String encryptMD5(String mixing) {
    String md5 = null;
    try {
      if(null == messageDigest) {
        messageDigest = MessageDigest.getInstance("MD5");
      }
      // update input string in message digest
      messageDigest.update(mixing.getBytes(), 0, mixing.length());

      // converts message digest value in base 16 (hex)
      md5 = new BigInteger(1, messageDigest.digest()).toString(16);

    } catch (NoSuchAlgorithmException e) {
      log.warn("encrypt input using md5 failed.", e);
    }
    return md5;
  }


  public static Boolean md5Verify(String input, String salt, String output) {
   String mixing = mixing(input, salt);

   String md5 = encryptMD5(mixing);

   if(md5.equals(output)) {
     return true;
   }

   return false;
  }



  private static String salt(String input) {
    int saltLength = input.length() > SALT_LENGTH ? input.length() : SALT_LENGTH;

    String salt = PasswordGenerator.generatePassword(saltLength);

    return salt;
  }

  private static String mixing(String input, String salt) {
    String inputBase64 = base64Encoder.encode(input.getBytes());

    String saltBase64 = base64Encoder.encode(salt.getBytes());

    String temp = salt + inputBase64 + saltBase64;

    String mixing = base64Encoder.encode(temp.getBytes());

    return mixing;
  }

}
