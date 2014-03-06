package earth.mail.send;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmailSenderDataTest {
 
    private final static String hostEmailDataFile = "HostEmailData.properties";
    private final static EmailSenderData senderData = new EmailSenderData(hostEmailDataFile);
    
    
    @Test
    public void get_corrected_smpt () { 
        String smpt = senderData.getSmpt();
        String expectedSmpt = "smtp.163.com";
        assertEquals(expectedSmpt, smpt);
    }
    
    @Test
    public  void get_corrected_mailServerPort () {
        String port = senderData.getMailServerPort();
        String expectedPort = "25";
        assertEquals(expectedPort, port);
    }
    
    @Test
    public  void get_corrected_fromAddress () {
        String fromAddress = senderData.getFromAddress();
        String expectedFromAddress = "earthmailuser@163.com";
        assertEquals(expectedFromAddress, fromAddress);
    }
    
    @Test
    public  void get_corrected_HostEmailUserName () {
        String hostEmailUserName = senderData.getHostEmailUserName();
        String expectedHostEmailUserName = "earthmailuser";
        assertEquals(expectedHostEmailUserName, hostEmailUserName);
    }
    
   
}
