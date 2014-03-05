package earth.mail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import earth.mail.send.Mail;
import earth.mail.send.MailSender;

public class EmailSenderServlet extends HttpServlet {
    private MailSender mailsender;
    
    public EmailSenderServlet(MailSender sender) {
        this.mailsender = sender;
    }
    
    public EmailSenderServlet() {
        this(new MailSender());
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws java.io.IOException, ServletException {
        this.doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws java.io.IOException, ServletException {
        mailsender.send(new Mail("", "", ""));
    }

}
