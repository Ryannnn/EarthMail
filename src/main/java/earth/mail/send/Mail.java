package earth.mail.send;

import java.util.List;

public class Mail {

    private final String topic;

    private final String body;

    private final List<String> recipients;

    public Mail(String topic, String body,  List<String> recipients) {
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

    public List<String> getRecipients() {
        return recipients;
    }

}
