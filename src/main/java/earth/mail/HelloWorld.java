package earth.mail;

import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws java.io.IOException, ServletException {
    	resp.getWriter().println("Hello, World!");
    }
}
