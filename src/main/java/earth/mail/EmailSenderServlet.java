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

    public EmailSenderServlet() {
        this(new MailSender());
    }

    public EmailSenderServlet(MailSender sender) {
        this(sender, new EmailAddressValidator());
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
        String errorMessage = "";
        String topic = req.getParameter("topic");
        String recipients = req.getParameter("recipients");
        String body = req.getParameter("body");

        boolean isValidAddress = true;
        ArrayList<String> recipientList = new ArrayList<String>();

        int originalSize, actualSize = 0;
        originalSize = recipients.split(",").length;

        for (String recipient : recipients.split(",")) {
            isValidAddress = emailAdressValidator.isEmailAddressValidated(recipient);
            if (isValidAddress) {
                recipientList.add(recipient);
                actualSize++;
            }

        }
        
        String container = "";
        if (topic.equals("")) {
            errorMessage = "please input mail topic ";
            
            container = "index.jsp?result=" + errorMessage + "&body=" + body
                    + "&topic=" + topic + "&recipients=" + recipients;
        } else if (body.equals("")) {
            errorMessage = "please input mail content ";
            container = "index.jsp?result=" + errorMessage + "&body=" + body
                    + "&topic=" + topic + "&recipients=" + recipients;
        } else if (actualSize != originalSize && actualSize != 0) {
            errorMessage = "sent, but some address are invalidated";
            container = "index.jsp?result=" + errorMessage + "&body=" + body
                    + "&topic=" + topic + "&recipients=" + recipients;
        } else if (actualSize == 0) {
            errorMessage = "no validated email address";
            container = "index.jsp?result=" + errorMessage + "&body=" + body
                    + "&topic=" + topic + "&recipients=" + recipients;
        } else {
            errorMessage = "send.";
            container = "index.jsp?result=" + errorMessage;
        }

        if (actualSize > 0) {
            mailsender.send(new Mail(topic, body, recipientList));
        }
        resp.sendRedirect(container);
    }

}
