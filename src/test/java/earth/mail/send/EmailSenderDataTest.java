package earth.mail.send;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmailSenderDataTest {
 
    @Test
    public void get_corrected_smpt_not_null () {
        String hostEmailDataFile = "HostEmailData.properties";
        EmailSenderData senderData = new EmailSenderData(hostEmailDataFile);
        
        String smpt = senderData.getSmpt();
        String expectedSmpt = "smtp.163.com";
        assertEquals(expectedSmpt, smpt);
    }
}
