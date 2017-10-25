
package library_management_.system;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class library_memberDao 
{
    public static int save(String name, String position, String contact, String joining_date) 
    {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into library_member(name,position,contact,joining_date) values(?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, position);
            ps.setString(3, contact);
            ps.setString(4, joining_date);
            status = ps.executeUpdate();
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return status;
    }
}
