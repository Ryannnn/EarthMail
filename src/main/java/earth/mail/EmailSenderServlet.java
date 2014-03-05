package earth.mail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import earth.mail.send.Mail;
import earth.mail.send.MailSender;

public class EmailSenderServlet extends HttpServlet {
    private MailSender mailsender;
    private EmailAddressValidator emailAdressValidator;
    
    public EmailSenderServlet(MailSender sender) {
        this.mailsender = sender;
        this.emailAdressValidator = new EmailAddressValidator();
    }
    
    public EmailSenderServlet(MailSender sender, EmailAddressValidator emailAdressValidator) {
        this.mailsender = sender;
        this.emailAdressValidator = emailAdressValidator;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws java.io.IOException, ServletException {
        this.doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws java.io.IOException, ServletException {
        String recipients = req.getParameter("recipients");
        boolean validatedAddress = emailAdressValidator.isEmailAddressValidated(recipients);
        if(validatedAddress)
        {
            mailsender.send(new Mail("", "", recipients));
        }
    }

}
