

package library_management_.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;


public class Student_info extends JFrame implements ActionListener 
{
    String colorpanel_ = "#90A4AE";
    String color_up_button_ = "#B0BEC5";
    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();
    
    JLabel l_student_id = new JLabel("Student Id :");
    JTextField tf_student_id = new JTextField(15);
    
    JLabel l_name = new JLabel("Name :");
    JTextField tf_name = new JTextField(15);
    
    JLabel l_roll= new JLabel("Roll :");
    JTextField tf_roll = new JTextField(15);
    
    JLabel l_batch = new JLabel("Batch :");
    JTextField tf_batch = new JTextField(15);
    
    JLabel l_department = new JLabel("Department :  ");
    String dep[] = {"CSE", "LLB", "BBA", "ENGLISH"};
    JComboBox tf_department = new JComboBox(dep);
    
    JLabel l_year = new JLabel("Year :");
    JTextField tf_year = new JTextField(15);
    
    JLabel l_contact = new JLabel("Contact :");
    JTextField tf_contact = new JTextField(15);
    
    JLabel l_issue_card = new JLabel("Issue Card :");
    JTextField tf_issue_card = new JTextField(15);
    
    JTextField tf_search = new JTextField(15);
    
    JButton b_view_lc_user = new JButton("View library card user");

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

    Student_info() {

        super("Student Information");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
        add(panel);
        setSize(550, 665);
        setVisible(true);
        setLocation(480, 40);
        Add_Component_E();

    }

    void Add_Component_E() 
    {

        l_student_id.setBounds(100, 30,200,60);
        tf_student_id.setBounds(220, 45, 150, 35);
        panel.add(l_student_id);
        panel.add(tf_student_id);
       
        l_name.setBounds(100, 80, 200, 80);
        tf_name.setBounds(220, 105, 150, 35);
        panel.add(l_name);
        panel.add(tf_name);
        
        l_roll.setBounds(100, 165, 130, 40);
        tf_roll.setBounds(220, 170, 150, 35);
        panel.add(l_roll);
        panel.add(tf_roll);
        
        l_batch.setBounds(100, 230,130,40);
        tf_batch.setBounds(220, 235, 150, 35);
        panel.add(l_batch);
        panel.add(tf_batch);
        
        l_year.setBounds(100, 290,200,60);
        tf_year.setBounds(220, 305, 150, 35);
        panel.add(l_year);
        panel.add(tf_year);
        
        l_department.setBounds(100, 355,200,60);
        tf_department.setBounds(220, 370, 150, 35);
        panel.add(l_department);
        panel.add(tf_department);
        
        l_contact.setBounds(100, 420,200,60);
        tf_contact.setBounds(220, 435, 150, 35);
        panel.add(l_contact);
        panel.add(tf_contact);
        
        
        l_issue_card.setBounds(100, 485,200,60);
        tf_issue_card.setBounds(220, 500, 150, 35);
        panel.add(l_issue_card);
        panel.add(tf_issue_card);
        
        
        tf_search.setBounds(282, 1, 150, 34);
        panel.add(tf_search);
        
        
        tf_student_id.setBackground(Color.decode(colorbutton_));
        tf_name.setBackground(Color.decode(colorbutton_));
        tf_roll.setBackground(Color.decode(colorbutton_));
        tf_batch.setBackground(Color.decode(colorbutton_));
        tf_department.setBackground(Color.decode(colorbutton_));
        tf_year.setBackground(Color.decode(colorbutton_));
        tf_contact.setBackground(Color.decode(colorbutton_));
        tf_issue_card.setBackground(Color.decode(colorbutton_));
        
        tf_search.setBackground(Color.decode(colorbutton_));
        
        b_view_lc_user.setBounds(1, 1, 170, 35);
        b_view_lc_user.setForeground(Color.BLACK);
        b_view_lc_user.addActionListener(this);
        //b_view_library_member.setToolTipText("View library member");
        //sb.setMnemonic(KeyEvent.VK_S);
        panel.add(b_view_lc_user);
        
        sb.setBounds(135, 565,100,30);
        sb.setForeground(Color.BLACK);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        panel.add(sb);

        bb.setBounds(265, 565,100,30);
        bb.setForeground(Color.BLACK);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);
        
        b_search.setBounds(433, 1, 100, 35);
        b_search.setForeground(Color.BLACK);
        b_search.addActionListener(this);
        panel.add(b_search);
        
        b_view_lc_user.setBackground(Color.decode(color_up_button_));
        
        sb.setBackground(Color.decode(colorbutton_));
        bb.setBackground(Color.decode(colorbutton_));
        b_search.setBackground(Color.decode(color_up_button_));

    }

    public static void main(String args[]) {

        Student_info ob = new Student_info();
    }

    public void actionPerformed(ActionEvent einfo) {
        if (einfo.getSource() == sb) {

            try {

                String student_id = tf_student_id.getText();
                
                String name = tf_name.getText();
                
                String roll = tf_roll.getText();
                
                String batch = tf_batch.getText();
                
                String department = tf_department.getSelectedItem().toString();
                
                String year = tf_year.getText();
                
                String c_id = tf_contact.getText().toString();
                int contact = Integer.parseInt(c_id);
                
                String issue_card = tf_issue_card.getText();
                
                int i = StudentDao.save(student_id,name, roll, batch, department,year,contact,issue_card);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } 
                else 
                {
                    System.out.println(einfo.toString());
                }
                tf_student_id.setText(null);
                tf_name.setText(null);
                tf_roll.setText(null);
                tf_batch.setText(null);
                tf_department.setSelectedItem(null);
                tf_year.setText(null);
                tf_contact.setText(null);
                tf_issue_card.setText(null);
                

            } 
            catch (Exception ee) 
            {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }
        if(einfo.getSource()== b_view_lc_user)
        {
            new view_student_info();
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
               ps=con.prepareStatement("select * from student where student_id='"+tf_search.getText()+"'");
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
                          columnNames.addElement("Student ID");
            columnNames.addElement("Name");
            columnNames.addElement("Roll");
            columnNames.addElement("Batch");
            columnNames.addElement("Department");
            columnNames.addElement("Year");
            columnNames.addElement("Contact");
            columnNames.addElement("Issue Card");
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
