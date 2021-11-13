package servlets;

import data.userData;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

/**
 *
 * @author abdel
 */
public class loginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<title>login servlet</title>");

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        ResultSet rs = null;

        try {
            Statement st = (Statement) getServletContext().getAttribute("st");
            rs = st.executeQuery("select * from user where username='" + user + "' and pass='" + pass + "'");

            if (rs.next()) {
                userData us = new userData();
                us.setName(rs.getString("name"));
                us.setId(rs.getString("id"));
                request.getSession().setAttribute("cust", us);
                RequestDispatcher req = request.getRequestDispatcher("/welcomeServlet");
                req.forward(request, response);

            } else {
                out.println("<b>" + user + " u r not registered !!</b>");
                RequestDispatcher rq = request.getRequestDispatcher("./login.html");
                rq.include(request, response);
            }

        } catch (Exception ex) {
            ex.getMessage();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
