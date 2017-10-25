package library_management_.system;



import java.sql.Connection;
import java.sql.PreparedStatement;


public class Old_memberDao
{
    public static int save(String name, String position, String contact, String resigning_date) 
    {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into old_library_member(name,position,contact,resigning_date) values(?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, position);
            ps.setString(3, contact);
            ps.setString(4, resigning_date);
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
