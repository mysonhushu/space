package com.huyouxiao.space.common.security;



import java.util.Random;

public class PasswordGenerator {

  private static final String PASSWORD_SEQUENCE =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";

  private static final String NUMBERS = "0123456789";

  private static final Random randomMethod = new Random();

  public static String generatePassword(int len)
  {
    char[] password = new char[len];

    for (int i = 0; i < len; i++)
    {
      password[i] = PASSWORD_SEQUENCE.charAt(randomMethod.nextInt(PASSWORD_SEQUENCE.length()));

    }
    return new String(password);
  }


  public static String generateOTP(int len)
  {
    char[] otp = new char[len];

    for (int i = 0; i < len; i++)
    {
      otp[i] = NUMBERS.charAt(randomMethod.nextInt(NUMBERS.length()));
    }
    return new String(otp);
  }

}
