package earth.mail.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SetCharacterEncodingFilter implements Filter {
    
    private static final String UTF_8 = "UTF-8";

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        request.setCharacterEncoding(UTF_8);

        chain.doFilter(request, response);
    }

    public void init(FilterConfig arg0) throws ServletException {
        // Do nothing!
    }

    public void destroy() {
        // Do nothing!
    }
}
