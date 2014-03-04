package earth.mail.send;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    // 发送邮件的服务器的IP和端口
    private String mailServerHost = "smtp.163.com";
    private String mailServerPort = "25";
    // 邮件发送者的地址
    private String fromAddress = "earthmailuser@163.com";
    // 登陆邮件发送服务器的用户名和密码
    private String userName = "earthmailuser";
    private String password = "password";
    private Session sendMailSession;
    private Sender sender;

    public MailSender() {
        initSender();
    }

    public MailSender(Sender sender) {
        this.sender = sender;
    }

    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", "true");
        return p;
    }

    private void initSender() {
        this.sender = new TransportSender();
        // 判断是否需要身份认证
        Authenticator authenticator = new EarthAuthenticator(userName, password);
        Properties pro = getProperties();
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        sendMailSession = Session.getDefaultInstance(pro, authenticator);
    }

    public Boolean send(Mail mail) {
        try {
            sender.send(toMailMassage(mail));
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private Message toMailMassage(Mail mail) throws AddressException,
            MessagingException {
        // 根据session创建一个邮件消息
        Message mailMessage = new MimeMessage(sendMailSession);
        // 创建邮件发送者地址
        Address from = new InternetAddress(fromAddress);
        // 设置邮件消息的发送者
        mailMessage.setFrom(from);
        // 创建邮件的接收者地址，并设置到邮件消息中
        String[] list = mail.getRecipients().split(",");
        for (String address : list) {
            Address to = new InternetAddress(address);
            mailMessage.addRecipient(Message.RecipientType.TO, to);
        }

        // 设置邮件消息的主题
        mailMessage.setSubject(mail.getTopic());

        // 设置邮件消息的主要内容
        String mailContent = mail.getBody();
        mailMessage.setText(mailContent);
        return mailMessage;
    }

}
