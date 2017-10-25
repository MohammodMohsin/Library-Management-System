

package library_management_.system;


import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public static Connection getConnection()//connection with database using singleton design pattern.
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");//mysql

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");
            return con;

        } 
        catch (Exception e) 
        {
            System.out.println("Connection Error.");
            return null;

        }
    }

}
