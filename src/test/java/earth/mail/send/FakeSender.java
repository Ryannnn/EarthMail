package earth.mail.send;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

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

    public void verifyMailSent(String topic, String body,
            ArrayList<String> receiver, String from) throws MessagingException,
            IOException {

        assertTrue(isSent);
        assertEquals(topic, message.getSubject());
        assertEquals(body, message.getContent());
        for (int i = 0; i < receiver.size(); i++) {
            assertEquals(receiver.get(i),
                    message.getRecipients(RecipientType.TO)[i].toString());
        }

        assertEquals(from, message.getFrom()[0].toString());
    }

}
