package earth.mail;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import earth.mail.send.Mail;
import earth.mail.send.MailSender;

public class EmailSenderServletTest {
    private MailSender sender;
    private EmailAddressValidator emailAdressValidator;
    private EmailSenderServlet emailSenderServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Before
    public void setUp() {
        sender = mock(MailSender.class);
        emailAdressValidator = new EmailAddressValidator();
        emailSenderServlet = new EmailSenderServlet(sender,
                emailAdressValidator);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

    }

    @Test
    public void servlet_one_mail_validator_pass() throws Exception {

        when(request.getParameter("topic")).thenReturn("Subject");
        when(request.getParameter("body")).thenReturn("Email content");
        when(request.getParameter("recipients")).thenReturn("henry@163.com");

        emailSenderServlet.doPost(request, response);
        verify(sender).send(any(Mail.class));
    }

    @Test
    public void servlet_two_mail_validator_pass() throws Exception {

        when(request.getParameter("topic")).thenReturn("Subject");
        when(request.getParameter("body")).thenReturn("Email content");
        when(request.getParameter("recipients")).thenReturn(
                "henry@163.com,123@123.com");

        emailSenderServlet.doPost(request, response);
        verify(sender).send(any(Mail.class));
    }

    @Test
    public void servlet_one_mail_validator_fail() throws Exception {

        when(request.getParameter("topic")).thenReturn("Subject");
        when(request.getParameter("body")).thenReturn("Email content");
        when(request.getParameter("recipients")).thenReturn("henry");

        emailSenderServlet.doPost(request, response);
        verify(sender, Mockito.never()).send(any(Mail.class));
    }

}
