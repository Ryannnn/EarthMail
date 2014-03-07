package earth.mail.filter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class SetCharacterEncodingFilterTest {
    
    private SetCharacterEncodingFilter filter;
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    private FilterChain chain;
    
    @Test
    public void test_doFilter() throws IOException, ServletException {
        filter.doFilter(request, response, chain);
        
        verify(request).setCharacterEncoding("UTF-8");
        verify(chain).doFilter(request, response);
    }


    @Before
    public void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        chain = mock(FilterChain.class);
        
        filter = new SetCharacterEncodingFilter();
    }
}
