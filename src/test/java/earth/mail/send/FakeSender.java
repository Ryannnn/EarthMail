package earth.mail.send;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;

public class FakeSender implements Sender {

    private boolean isSent = false;
    private Message message;

    public void send(Message message) {
        this.isSent = true;
        this.message = message;

    }

    public void verifyMailSent(String topic, String body, String receiver,
            String from) throws MessagingException, IOException {

        assertTrue(isSent);
        assertEquals(topic, message.getSubject());
        assertEquals(body, message.getContent());
        assertEquals(receiver,
                message.getRecipients(RecipientType.TO)[0].toString());
        assertEquals(from, message.getFrom()[0].toString());

    }

}
