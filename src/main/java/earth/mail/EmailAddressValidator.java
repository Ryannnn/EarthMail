package earth.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailAddressValidator{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final String EMAIL_PATTERN = 
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isEmailAddressValidated(String emailAddress) {
        // TODO Auto-generated method stub

        Pattern emailAddressPatten = Pattern.compile(EMAIL_PATTERN);

        Matcher emailAddressMacher = emailAddressPatten.matcher(emailAddress);

        return emailAddressMacher.matches();
    }
    


}
