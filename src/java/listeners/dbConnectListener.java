package listeners;

import jakarta.servlet.*;
import java.sql.*;

public class dbConnectListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // connect to db
        Statement st = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo", "root", "");
            st = con.createStatement();
            
            sce.getServletContext().setAttribute("st", st);
            System.out.println("listener");
        }catch(Exception ex){
            ex.getMessage();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
