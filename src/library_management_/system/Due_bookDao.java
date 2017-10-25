

package library_management_.system;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class Due_bookDao 
{

    public static int save(String student_id, String issue_date,String return_date,String due,int books) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into due_books(student_id,issue_date,return_date,due,books) values(?,?,?,?,?)");
            ps.setString(1,student_id);
            ps.setString(2,issue_date);
            ps.setString(3, return_date);
            ps.setString(4, due);
            ps.setInt(5, books);
            
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
