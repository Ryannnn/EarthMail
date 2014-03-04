package earth.mail.send;

public class Mail {

    // 邮件主题
    private String topic;
    // 邮件的文本内容
    private String body;
    // 邮件接收者的地址
    private String recipients;

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public Mail(String topic, String body, String recipients) {
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

}
