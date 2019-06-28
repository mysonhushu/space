package com.huyouxiao.space.common.mail.impl;

import com.huyouxiao.space.common.mail.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailServiceImpl implements MailService {

  @Autowired
  private JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String from;

  @Override
  public void sendMail(String to, String subject, String content) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setFrom(from);
    mailMessage.setTo(to);
    mailMessage.setSubject(subject);
    mailMessage.setText(content);

    javaMailSender.send(mailMessage);
  }
}
