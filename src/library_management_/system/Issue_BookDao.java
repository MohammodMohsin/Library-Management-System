

package library_management_.system;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class Issue_BookDao 
{

    public static int save(int b_id, String book_name, String stu_name, String stu_id, String issue_dat,String return_date) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into issue_books(book_id,book_name,student_name,student_id,issue_date,return_date) values(?,?,?,?,?,?)");
            ps.setInt(1, b_id);
            ps.setString(2, book_name);
            ps.setString(3, stu_name);
            ps.setString(4, stu_id);
            ps.setString(5, issue_dat);
            ps.setString(6, return_date);
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
