package earth.mail.send;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EarthMailAuthenticator extends Authenticator {
    String userName;
    String password;

    public EarthMailAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}