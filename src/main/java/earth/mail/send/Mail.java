package earth.mail.send;

import java.util.ArrayList;

public class Mail {

    private final String topic;

    private final String body;

    private final ArrayList<String> recipients;

    public Mail(String topic, String body,  ArrayList<String> recipients) {
        this.topic = topic;
        this.body = body;
        this.recipients = recipients;
    }

    public String getTopic() {
        return topic;
    }

    public String getBody() {
        return body;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }

}
