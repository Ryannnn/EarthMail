package earth.mail.send;

import java.util.ArrayList;

import org.junit.Test;

import earth.mail.send.Mail;
import earth.mail.send.MailSender;

public class MailSenderTest {

    private FakeSender fakeSender = new FakeSender();
    private MailSender mailSender = new MailSender(fakeSender);

    @Test
    public void send_correct_mail_content() throws Exception {
        ArrayList<String> list =new ArrayList<String>();
        
        list.add("zhoutaoo@foxmail.com");
        list.add("wuhzh719@163.com");
        Mail mail = new Mail("topic", "body",list);
        mailSender.send(mail);
        fakeSender.verifyMailSent("topic", "body", list,"earthmailuser@163.com");
    }

}
