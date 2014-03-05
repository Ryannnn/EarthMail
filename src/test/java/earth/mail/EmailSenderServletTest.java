package earth.mail;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import earth.mail.send.Mail;
import earth.mail.send.MailSender;

public class EmailSenderServletTest {

	@Test  
    public void servlet_validator_pass() throws Exception {
	    MailSender sender = mock(MailSender.class);
	    EmailAddressValidator emailAdressValidator = new EmailAddressValidator();
        EmailSenderServlet emailSenderServlet = new EmailSenderServlet(sender, emailAdressValidator);
        
	    HttpServletRequest request = mock(HttpServletRequest.class);
	    when(request.getParameter("topic")).thenReturn("Subject");
	    when(request.getParameter("body")).thenReturn("Email content");
	    when(request.getParameter("recipients")).thenReturn("henry@163.com");
	    
        HttpServletResponse response = mock(HttpServletResponse.class); 
        
        emailSenderServlet.doPost(request, response); 
        verify(sender).send(any(Mail.class));
	}

}
