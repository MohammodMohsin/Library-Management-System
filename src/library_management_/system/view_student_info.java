
package library_management_.system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class view_student_info  extends JFrame implements ActionListener {
      //JButton add_b = new JButton("Add New Book");
     // JButton del = new JButton("Back");
      Font lb_fnt=new Font("",Font.BOLD,20);


    view_student_info () 
    {

      
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

        /*add_b.setBounds(40, 385, 190, 25);
        add_b.setFont(lb_fnt);
        add_b.setForeground(Color.DARK_GRAY);
        add_b.addActionListener(this);
        add_b.setToolTipText("Add New Book");
        add_b.setMnemonic(KeyEvent.VK_S);
        
        del.setBounds(260, 385, 190, 25);
        del.setFont(lb_fnt);
        del.setForeground(Color.DARK_GRAY);
        del.addActionListener(this);
        del.setToolTipText("Delete Book");
        del.setMnemonic(KeyEvent.VK_D);*/
        
        try {
            con = DB.getConnection();

            //   ps = con.prepareStatement("select library_books.book_name,library_books.author,library_books.publisher,library_books.quantity,count(issue_books.book_id) as issued   from library_books,issue_books  where library_books.book_id= issue_books.book_id group by(issue_books.book_id)");    
            ps = con.prepareStatement("select student_id,name,roll,batch,department,year,contact,issue_card from student");
            ps.execute();
            rs = ps.getResultSet();
            ResultSetMetaData rsmt = rs.getMetaData();
            int c = rsmt.getColumnCount();
            Vector column = new Vector(c);
            for (int i = 1; i <= c; i++) {
                column.add(rsmt.getColumnName(i));
            }
            Vector row = new Vector();
            while (rs.next()) {
                row = new Vector(c);
                for (int i = 1; i <= c; i++) {
                    row.add(rs.getString(i));
                }
                
                
                data.add(row);
            }
            Vector columnNames = new Vector();
            columnNames.addElement("Student ID");
            columnNames.addElement("Name");
            columnNames.addElement("Roll");
            columnNames.addElement("Batch");
            columnNames.addElement("Department");
            columnNames.addElement("Year");
            columnNames.addElement("Contact");
            columnNames.addElement("Issue Card");

            
            table = new JTable(data, columnNames);
            
            JFrame frame = new JFrame("Library Card User");
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            JScrollPane pane = new JScrollPane(table);
            //panel.add(add_b);
           // panel.add(del);
            panel.setLayout(new BorderLayout());
            panel.add(pane, BorderLayout.CENTER);
            
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

       view_student_info ob = new view_student_info();

    }

    public void actionPerformed(ActionEvent e) {
            
       /* if (e.getSource() == add_b) 
        {
            new Book_issue();    
        }*/

    }

}