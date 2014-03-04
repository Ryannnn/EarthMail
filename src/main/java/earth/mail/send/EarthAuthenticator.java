package earth.mail.send;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EarthAuthenticator extends Authenticator {
    String userName;
    String password;

    public EarthAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}