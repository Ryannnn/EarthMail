package earth.mail.send;

import org.junit.Test;
import earth.mail.send.Mail;
import earth.mail.send.MailSender;

public class MailSenderTest {

    private FakeSender fakeSender = new FakeSender();
    private MailSender mailSender = new MailSender(fakeSender);

    @Test
    public void send_correct_mail_content() throws Exception {
        Mail mail = new Mail("topic", "body", "zhoutaoo@foxmail.com");

        mailSender.send(mail);

        fakeSender.verifyMailSent("topic", "body", "zhoutaoo@foxmail.com",
                "earthmailuser@163.com");
    }

}
