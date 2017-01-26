package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcella
 */
public class ControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException 
    {
        String actionRequest = request.getParameter("actionRequest");
	String className = "controller."+ actionRequest;
	try {
		Class<?> classRequest = Class.forName(className);
		IController icontroller = (IController) classRequest.newInstance();
		// It receives the String to foward the results
		String pageResponse = icontroller.execute(request, response);
		// It fowards the result to a JSP Page
		request.getRequestDispatcher(pageResponse).forward(request, response);
	} catch (Exception e) {
		throw new ServletException("Error to execute ControllerServlet: ", e);
	}
        
            
    }

    
}
