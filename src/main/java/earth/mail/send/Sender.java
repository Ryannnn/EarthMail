package earth.mail.send;

import javax.mail.Message;
import javax.mail.MessagingException;

public interface Sender {
    public void send(Message message) throws MessagingException;
}
