package com.huyouxiao.space.common.mail;

import org.springframework.stereotype.Service;

@Service
public interface MailService {

  void sendMail(String to, String subject, String content);
}
