package library_management_.system;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Return_bookDao {

    public static int delete(String stu_id, String book_name) 
    {
        int status = 0;
        try 
        {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from issue_books where student_id=? and book_name =?");
            ps.setString(1, stu_id);
            ps.setString(2, book_name);
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
