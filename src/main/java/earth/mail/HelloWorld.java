package earth.mail;

import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = -1376075419161046739L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws java.io.IOException, ServletException {
    	resp.getWriter().println("Hello, World!");
    }
}
