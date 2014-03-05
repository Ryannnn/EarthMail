package earth.mail;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class EmailAddressValidatorTest {
	
	public EmailAddressValidator emailAddressValidator = new EmailAddressValidator();
	
	@Test
	public void testEmailAddressValidated() {
		assertTrue(emailAddressValidator.isEmailAddressValidated("email@odde.com"));
	} 
	
	@Test
    public void testEmailAddressValidatedWithoutAt() {
        assertFalse(emailAddressValidator.isEmailAddressValidated("emailodde.com"));
    }
	
	@Test
    public void testEmailAddressValidatedNull() {
        assertFalse(emailAddressValidator.isEmailAddressValidated(""));
    }

}
