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

    private Session sendMailSession;
    private Sender sender;
    EmailSenderData data = new EmailSenderData("HostEmailData.properties");

    private Properties property = new Properties();

    public MailSender() {
        initProperties();
        initSender();
    }

    public MailSender(Sender sender) {
        this.sender = sender;
    }

    public void initProperties() {
        property = data.getSenderProperty();
    }

    private void initSender() {
        Authenticator authenticator = new EarthMailAuthenticator(data.getHostEmailUserName(),
                data.getHostEmailPassword());
        sendMailSession = Session.getDefaultInstance(property, authenticator);
        this.sender = new TransportSender();
    }

    public Boolean send(Mail mail) {
        try {
            sender.send(toMailMassage(mail));
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private Message toMailMassage(Mail mail) throws AddressException,
            MessagingException {
        Message mailMessage = new MimeMessage(sendMailSession);
        Address from = new InternetAddress(data.getFromAddress());
        mailMessage.setFrom(from);
        for (String address : mail.getRecipients()) {
            Address to = new InternetAddress(address);
            mailMessage.addRecipient(Message.RecipientType.TO, to);
        }
        mailMessage.setSubject(mail.getTopic());
        mailMessage.setText(mail.getBody());
        return mailMessage;
    }
}
