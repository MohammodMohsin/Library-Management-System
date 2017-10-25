

package library_management_.system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class due_books extends JFrame implements ActionListener {
      String colorpanel_ = "#90A4AE";
      //JButton add_b = new JButton("Add New Book");
     // JButton b_back = new JButton("Back");
      Font lb_fnt=new Font("",Font.BOLD,15);


    due_books() {

      //  super("Library");
        //    panel.setLayout(null);
        // panel.setBackground(Color.pink);
        // add(panel);
        //       setSize(650, 600);
        //   setVisible(true);
        
        disPlayData();
    }

    void disPlayData() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Vector data = new Vector();
        JPanel panel = new JPanel();
        JTable table;

        
       /* b_back.setBounds(200, 385, 100, 25);
        b_back.setFont(lb_fnt);
        b_back.setForeground(Color.DARK_GRAY);
        b_back.addActionListener(this);
       // b_back.setToolTipText("Back");
        b_back.setMnemonic(KeyEvent.VK_D);*/
        
        
        try {
            con = DB.getConnection();

            //   ps = con.prepareStatement("select library_books.book_name,library_books.author,library_books.publisher,library_books.quantity,count(issue_books.book_id) as issued   from library_books,issue_books  where library_books.book_id= issue_books.book_id group by(issue_books.book_id)");    
            ps = con.prepareStatement("select issue_books.book_id,issue_books.book_name,issue_books.student_name,issue_books.student_id,issue_books.issue_date,issue_books.return_date,issue_books.return_date-(issue_books.issue_date) as Due   from issue_books ");
            ps.execute();
            rs = ps.getResultSet();
           // String issue_date =rs.getString("issue_date");
           // String return_date=rs.getString("return_date");
            ResultSetMetaData rsmt = rs.getMetaData();int c = rsmt.getColumnCount();
            
            Vector column = new Vector(c);
            for (int i = 1; i <= c; i++) 
            {
                column.add(rsmt.getColumnName(i));
            }
            Vector row = new Vector();
            while (rs.next()) 
            {
                row = new Vector(c);
                for (int i = 1; i <= c; i++) 
                {
                    row.add(rs.getString(i));
                }
                
                
                data.add(row);
            }
            Vector columnNames = new Vector();
            columnNames.addElement("Book ID");
            columnNames.addElement("Book Name");
            columnNames.addElement("Student Name");
            columnNames.addElement("Student id");
            columnNames.addElement("issue Date");
            columnNames.addElement("Return Date");
            columnNames.addElement("Due");
            
            table = new JTable(data, columnNames);
            
            JFrame frame = new JFrame("Due Books");
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            JScrollPane pane = new JScrollPane(table);
            //panel.add(b_back);
            
            panel.setLayout(new BorderLayout());
            panel.add(pane, BorderLayout.CENTER);
           // panel.setBackground(Color.decode(colorpanel_));
            frame.setContentPane(panel);
            
            frame.setVisible(true);
            
            
        }
        catch (Exception e) 
        {
            // JOptionPane.showMessageDialog(null, e.toString());
            System.out.println(e.toString());
        }

    }

    public static void main(String args[]) {

        due_books ob = new due_books();

    }

    public void actionPerformed(ActionEvent e) 
    {
            
        /*if (e.getSource() == add_b) 
        {
            new Add_book();    
        }*/

    }

}