package earth.mail.send;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.junit.Test;

public class EmailSenderDataTest {
 
    private final static String hostEmailDataFile = "HostEmailData.properties";
    private final static EmailSenderData senderData = new EmailSenderData(hostEmailDataFile);
    
    
    @Test
    public void get_corrected_Sender_Data () {
        String smpt = senderData.getSmpt();
        String expectedSmpt = "smtp.163.com";
        assertEquals(expectedSmpt, smpt);
        
        String port = senderData.getMailServerPort();
        String expectedPort = "25";
        assertEquals(expectedPort, port);
        
        String fromAddress = senderData.getFromAddress();
        String expectedFromAddress = "earthmailuser@163.com";
        assertEquals(expectedFromAddress, fromAddress);
        
        String hostEmailUserName = senderData.getHostEmailUserName();
        String expectedHostEmailUserName = "earthmailuser";
        assertEquals(expectedHostEmailUserName, hostEmailUserName);
        
        String hostEmailPassword = senderData.getHostEmailPassword();
        String expectedHostEmailPassword = "password";
        assertEquals(expectedHostEmailPassword, hostEmailPassword);
    }
    
   @Test
   public void get_corrected_Serder_properties () {
       Properties senderProperty = senderData.getSenderProperty();
       Properties expectedProperty = new Properties();
       String hostName = "smtp.163.com";
       String serverPort = "25";
       String auth = "true";
       expectedProperty.put("mail.smtp.host", hostName);
       expectedProperty.put("mail.smtp.port", serverPort);
       expectedProperty.put("mail.smtp.auth", auth);
       assertEquals(senderProperty, senderProperty);
   }
}
