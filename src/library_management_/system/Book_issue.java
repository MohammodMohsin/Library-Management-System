

package library_management_.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;


public class Book_issue extends JFrame implements ActionListener 
{
    String colorpanel_ = "#90A4AE";
    String colorbutton_ = "#CFD8DC";
    String color_up_button_ = "#B0BEC5";
    
    LocalDateTime ldt=LocalDateTime.now();
    JLabel issue_date = new JLabel("Issue Date :");
    JTextField tf_issue_date;
    
    JPanel panel = new JPanel();
    JLabel b_id = new JLabel("Book ID  : ");
    JTextField tf_b_id = new JTextField(15);

    JLabel b_name = new JLabel("Book Name :  ");
    JTextField tf_bname = new JTextField(15);

    JLabel stu_name = new JLabel("Student Name :  ");

    JTextField tf_stu_name = new JTextField(15);

    JLabel stu_id = new JLabel("Student ID: ");
    JTextField tf_stu_id = new JTextField(15);

  //  JLabel issue_date = new JLabel("Issue Date");
   // JTextField tf_issue_date = new JTextField(15);
    
    JLabel return_date = new JLabel("Return Date  :");
    JTextField tf_return_date = new JTextField(15);
    
    JTextField tf_search = new JTextField(15);
    
    JButton b_view_issue_book = new JButton("View Issue Book");

    JButton sb = new JButton("Save", new ImageIcon("image/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("image/Regis.png"));
     JButton b_search = new JButton("Search");

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 15);
    ImageIcon ic = new ImageIcon();
    Connection con=null;
    Statement st = null;
    ResultSet rs=null;
    PreparedStatement ps = null;
        Vector data = new Vector();
        JPanel panel_search = new JPanel();
        JTable table;

    Book_issue() {

        super("Issue Book");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
        add(panel);
        setSize(550, 630);
        setVisible(true);
        setLocation(480, 50);
        Add_Component_E();

    }

    void Add_Component_E() 
    {
        
        
        //tf__date= new JTextField(s);

        b_id.setBounds(90, 70, 130, 40);
        tf_b_id.setBounds(210, 70, 150, 40);
        panel.add(b_id);
        panel.add(tf_b_id);

        b_name.setBounds(90, 160, 130, 40);
        tf_bname.setBounds(210, 160, 150, 40);
        panel.add(b_name);
        panel.add(tf_bname);

        stu_name.setBounds(90, 240, 130, 40);
        tf_stu_name.setBounds(210, 240, 150, 40);
        panel.add(stu_name);
        panel.add(tf_stu_name);

        stu_id.setBounds(90, 320, 130, 40);
        tf_stu_id.setBounds(210, 320, 150, 40);
        panel.add(stu_id);
        panel.add(tf_stu_id);
        
        issue_date.setBounds(90, 400, 130, 40);
        panel.add(issue_date);
        
        return_date.setBounds(90, 475, 130, 40);
        panel.add(return_date);
        
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.YYYY");
        String s=sdf.format(d);
        tf_issue_date= new JTextField(s);

        //issue_date.setBounds(90, 400, 130, 40);
        tf_issue_date.setBounds(210, 400, 150, 40);
        //panel.add(issue_date);
        panel.add(tf_issue_date);
        
        
        
       //return_date.setBounds(90, 450, 130, 40);
        tf_return_date.setBounds(210, 475, 150, 40);
       // panel.add(return_date);
        panel.add(tf_return_date);
        
        tf_search.setBounds(282, 1, 150, 34);
        panel.add(tf_search);
        
        tf_b_id.setBackground(Color.decode(colorbutton_));
        tf_bname.setBackground(Color.decode(colorbutton_));
        tf_stu_name.setBackground(Color.decode(colorbutton_));
        tf_stu_id.setBackground(Color.decode(colorbutton_));
        tf_issue_date.setBackground(Color.decode(colorbutton_));
        tf_return_date.setBackground(Color.decode(colorbutton_));
        tf_search.setBackground(Color.decode(colorbutton_));
        
        b_view_issue_book.setBounds(1, 1, 170, 35);
        b_view_issue_book.setForeground(Color.BLACK);
        b_view_issue_book.addActionListener(this);
        panel.add(b_view_issue_book);

        sb.setBounds(100, 540, 140, 40);
        sb.setForeground(Color.BLACK);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        panel.add(sb);

        bb.setBounds(290, 540, 140, 40);
        bb.setForeground(Color.BLACK);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);
        
        b_search.setBounds(433, 1, 100, 35);
        b_search.setForeground(Color.BLACK);
        b_search.addActionListener(this);
        panel.add(b_search);
        
        b_search.setBackground(Color.decode(color_up_button_));
        b_view_issue_book.setBackground(Color.decode(color_up_button_));
        sb.setBackground(Color.decode(colorbutton_));
        bb.setBackground(Color.decode(colorbutton_));

    }

    public static void main(String args[]) {

        Book_issue ob = new Book_issue();
    }

    public void actionPerformed(ActionEvent einfo) {
        if (einfo.getSource() == sb) 
        {

            try {
                Connection con=DB.getConnection();
                String query="select * from student where student_id='"+tf_stu_id.getText()+"'";
                       st=con.createStatement();
                       rs=st.executeQuery(query);
                       rs.next();
                       String student_id=rs.getString("student_id");

                String stu_name = tf_stu_name.getText();
                
                String s_id = tf_b_id.getText().toString();
                int b_id = Integer.parseInt(s_id);
                
                String book_name = tf_bname.getText();
                
                String stu_id = tf_stu_id.getText();
                
                String issue_dat = tf_issue_date.getText();
                
                String return_date = tf_return_date.getText();
                
                int i = Issue_BookDao.save(b_id, book_name, stu_name, stu_id, issue_dat,return_date);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } 
                else if(tf_stu_id.getText().equals(stu_id)&&tf_stu_id.getText().equals(student_id))
                {
                    
                }
                else
                {
                    System.out.println(einfo.toString());
                }
                tf_b_id.setText(null);
                tf_bname.setText(null);
                tf_stu_name.setText(null);
                tf_stu_id.setText(null);
                tf_issue_date.setText(null);
                tf_return_date.setText(null);

            } 
            catch (Exception ee) 
            {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }
        if(einfo.getSource()== b_view_issue_book)
        {
            new View_issue_books();
            dispose();
        }
        if(einfo.getSource()== bb)
        {
            //new Main_Menu();
            dispose();
        }
        if(einfo.getSource()==b_search)
        {
           try
           {
              // String book_name=tf_search.getText();
               Connection con=DB.getConnection();
               ps=con.prepareStatement("select * from issue_books where student_id='"+tf_search.getText()+"'");
               ps.execute();
               rs = ps.getResultSet();
               //String book_name=rs.getString("book_name");
               ResultSetMetaData rsmt = rs.getMetaData();
               
              
                      int a = rsmt.getColumnCount();
                      
                      Vector column = new Vector(a);
                          for (int i = 1; i <= a; i++) 
                          {
                             column.add(rsmt.getColumnName(i));
                          }
                           //data.add(column);
                          Vector row = new Vector();
                          while (rs.next()) 
                           {
                              row = new Vector(a);
                              for (int i = 1; i <= a; i++) 
                              {
                                 row.add(rs.getString(i));
                              }
                           
                            data.add(row);
                           }
                           
                          Vector columnNames = new Vector();
                          columnNames.addElement("Book ID");
                          columnNames.addElement("Book Name");
                          columnNames.addElement("Student Name");
                          columnNames.addElement("Student ID");
                          columnNames.addElement("Issue Date");
                          columnNames.addElement("Return Date");
                          table = new JTable(data, columnNames);
            
            JFrame frame = new JFrame("Issue Books");
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            JScrollPane pane = new JScrollPane(table);
            //panel.add(b_back);
            
             panel_search.setLayout(new BorderLayout());
             panel_search.add(pane, BorderLayout.CENTER);
           // panel.setBackground(Color.decode(colorpanel_));
            frame.setContentPane(panel_search);
            
            frame.setVisible(true);
                                           
                          dispose();
                       
                       //else
                       //{
                           //JOptionPane.showMessageDialog(null, "No books","Warning!!!",JOptionPane.ERROR_MESSAGE);
                       //}
                       
                       
           }
           catch(Exception e)
           {
               System.out.println(e.toString());
           }
            

        }

    }

}
