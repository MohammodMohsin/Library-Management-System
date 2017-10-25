



package library_management_.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class View_Library_Books extends JFrame implements ActionListener 
{
      String colorpanel_ = "#90A4AE";
      //JButton add_b = new JButton("Add New Book");
     // JButton b_back = new JButton("Back");
      Font lb_fnt=new Font("",Font.BOLD,15);


    View_Library_Books() {

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
            ps = con.prepareStatement("select library_books.book_id,library_books.book_name,library_books.author,library_books.publisher,library_books.quantity,count(issue_books.book_id) as issued,library_books.quantity-count(issue_books.book_id) as store   from library_books,issue_books  where library_books.book_id= issue_books.book_id group by(issue_books.book_id)");
            ps.execute();
            rs = ps.getResultSet();
            ResultSetMetaData rsmt = rs.getMetaData();
            int c = rsmt.getColumnCount();
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
            columnNames.addElement("Name");
            columnNames.addElement("Author");
            columnNames.addElement("Publisher");
            columnNames.addElement("Quantity");
            columnNames.addElement("Issued");
            columnNames.addElement("Store Book");
            
            table = new JTable(data, columnNames);
            
            JFrame frame = new JFrame("Reserved Books");
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

        View_Library_Books ob = new View_Library_Books();

    }

    public void actionPerformed(ActionEvent e) 
    {
            
        /*if (e.getSource() == add_b) 
        {
            new Add_book();    
        }*/

    }

}
