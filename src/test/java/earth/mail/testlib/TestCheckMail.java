package earth.mail.testlib;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.mail.MessagingException;

import org.junit.Test;

public class TestCheckMail {
    CheckMail checkMail = new CheckMail();

    @Test
    public void checkMail() throws MessagingException {
        assertTrue(checkMail.mailExists("iamnotman88@126.com"));
    }
    
    @Test(expected=RuntimeException.class)
    public void checkMailNonExist() throws MessagingException {
        checkMail.mailExists("xxxx8@126.com");
        fail();
    }
}