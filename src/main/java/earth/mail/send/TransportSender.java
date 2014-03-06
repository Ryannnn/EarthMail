package earth.mail.send;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

public class TransportSender implements Sender {

    public void send(Message message) throws MessagingException {
        Transport.send(message);
    }

}
