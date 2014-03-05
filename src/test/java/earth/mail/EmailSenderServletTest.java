package earth.mail;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import earth.mail.send.Mail;
import earth.mail.send.MailSender;

public class EmailSenderServletTest {
	
	@Test	
	public void servlet_send_email() throws Exception {
	    MailSender sender = mock(MailSender.class);
	    EmailSenderServlet emailSenderServlet = new EmailSenderServlet(sender);
	    HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    
        emailSenderServlet.doPost(request, response);        
        verify(sender).send(any(Mail.class));
    }

}
