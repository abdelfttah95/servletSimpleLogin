package db;

import java.sql.*;

public class dbConnect {

    public void connect(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo", "root", "");
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select id, name from user where pass=12345");

//            while (rs.next()) {
//                out.println("ID : " + rs.getString("id") + "<br>");
//                out.println("Name : " + rs.getString("name") + "<br>");
//                out.println("username : " + rs.getString("username") + "<br>");
//                out.println("password : " + rs.getString("pass") + "<br>");
//            }
           
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
