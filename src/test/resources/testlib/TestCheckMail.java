package testlib;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestCheckMail {
    CheckMail checkMail = new CheckMail();

    @Test
    public void checkMail() {
        assertTrue(checkMail.mailExists("foamtea30@126.com"));
    }
    
    @Test(expected=RuntimeException.class)
    public void checkMailNonExist() {
        checkMail.mailExists("nonexist@example.com");
        fail();
    }
}