package servlets;

import data.userData;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 *
 * @author abdel
 */
public class welcomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        userData use = (userData) request.getSession().getAttribute("cust");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<title>welcome servlet</title>");

        out.println("<b>Welcome </b>" + use.getName());


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
