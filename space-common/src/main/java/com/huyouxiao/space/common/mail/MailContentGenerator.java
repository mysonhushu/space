package com.huyouxiao.space.common.mail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailContentGenerator {
  public static final String mailActiveTitle = "激活您的帐户并享受 瓠悠笑 服务";
  public static final String activeUrlFormat = "http://huyouxiao:8080/web/account/active?userId={userId}&activeCode={activeCode}&opt={opt}";
  public static final String retrieveUrlFormat = "http://huyouxiao:8080/web/account/email/retrieve?email={email}";

  public static String getActiveContent(String email, Long userId, String activeCode, String opt) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("请验证您的电子邮件地址。\n");
    stringBuffer.append("尊敬的客户:\n");
    stringBuffer.append("您已将 " + email + " 注册为您的 瓠悠笑 帐户 ID。\n");
    stringBuffer.append("请单击以下链接，验证所注册的电子邮件地址为您所有。\n");
    stringBuffer.append("\n");
    String tempUrl = activeUrlFormat;
    String activeUrl = tempUrl.replace("{userId}", String.valueOf(userId)).replace("{activeCode}", activeCode).replace("{opt}", opt);


    stringBuffer.append(activeUrl+"\n");
    stringBuffer.append("\n");
    stringBuffer.append("\n");
    stringBuffer.append("\n");
    stringBuffer.append("如果上面的链接不起作用，请将地址复制并粘贴到新的浏览器窗口。 \n");
    stringBuffer.append("或者在 瓠悠笑APP 上输入以下验证码进行激活:\n");
    stringBuffer.append("是否没有 瓠悠笑 帐户?\n");
    stringBuffer.append("其他用户可能无意中注册了错误的电子邮件地址。如果您在 瓠悠笑帐户 中没有创建帐户，请单击下面的链接保护您的我电子邮件信息。 \n");

    stringBuffer.append("\n");
    String retrieveUrlTemp = retrieveUrlFormat;
    String retrieveUrl = retrieveUrlTemp.replace("{email}", email);

    stringBuffer.append(retrieveUrl+"\n");
    stringBuffer.append("\n");
    stringBuffer.append("\n");
    stringBuffer.append("当然你也可以在 瓠悠笑APP 上面输入以下验证码进行激活登陆：\n");
    stringBuffer.append(opt+"\n");
    stringBuffer.append("\n");
    stringBuffer.append("\n");
    stringBuffer.append("\n");
    stringBuffer.append("瓠悠笑 账户 团队敬上\n");

    log.debug("send content:{}", stringBuffer.toString());
    return stringBuffer.toString();
  }
}
