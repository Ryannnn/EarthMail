package earth.mail;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import earth.mail.send.Mail;
import earth.mail.send.MailSender;

public class EmailSenderServlet extends HttpServlet {
    private MailSender mailsender;
    private EmailAddressValidator emailAdressValidator;

    public EmailSenderServlet( ) {
        this(new MailSender());
    }
    
    public EmailSenderServlet(MailSender sender) {
        this(sender,new EmailAddressValidator());
    }

    public EmailSenderServlet(MailSender sender,
            EmailAddressValidator emailAdressValidator) {
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
        String result = "";
        String topic = req.getParameter("topic");
        String recipients = req.getParameter("recipients");
        String body = req.getParameter("body");
        boolean isInvalidAddress = true;
        
        ArrayList<String> recipientList = new ArrayList<String>(); 
        
        for(String recipient: recipients.split(",")){
            isInvalidAddress = isInvalidAddress && emailAdressValidator.isEmailAddressValidated(recipient);
            recipientList.add(recipient);
        }
        
        if (isInvalidAddress) {
            mailsender.send(new Mail(topic, body, recipientList));
            result = "result=send success";
        }else{
            result = "result=email invalid";
        }
        resp.sendRedirect("index.jsp?"+result);
    }

}
