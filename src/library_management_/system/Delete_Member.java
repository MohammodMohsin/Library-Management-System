
package library_management_.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;

public class Delete_Member  extends JFrame implements ActionListener 
{
    String colorpanel_ = "#90A4AE";
    //String colorTField_ = "#ECEFF1";
    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();
    //JLabel b_id = new JLabel("Book ID  : ");
   // JTextField t_id = new JTextField(15);

    JLabel l_name = new JLabel("Name  :  ");
    JTextField tf_name = new JTextField(15);

    //JLabel stu_name = new JLabel("Student Name :  ");

    //JTextField tf_stu_name = new JTextField(15);

    JLabel l_position = new JLabel("Position : ");
    JTextField tf_position = new JTextField(15);

    //JLabel issue_date = new JLabel("Issue Date");
    //JTextField tf_issue_date = new JTextField(15);

    JButton ob = new JButton("Ok", new ImageIcon("image/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("image/Regis.png"));

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 15);
    ImageIcon ic = new ImageIcon();
    Connection con=null;
    Statement st = null;
    ResultSet rs=null;

    Delete_Member () {

        super("Return Book");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
        add(panel);
        setSize(480, 400);
        setVisible(true);
        setLocation(480, 150);
        Add_Component_E();

    }

    void Add_Component_E() {

       /* b_id.setBounds(90, 70, 130, 40);
        t_id.setBounds(210, 70, 150, 40);
        panel.add(b_id);
        panel.add(t_id);*/

        l_name.setBounds(110, 75,100,30);
        tf_name.setBounds(200, 75, 150, 30);
        panel.add(l_name);
        panel.add(tf_name);
        
        l_position.setBounds(110, 150, 100, 30);
        tf_position.setBounds(200, 150, 150, 30);
        panel.add(l_position);
        panel.add(tf_position);

        tf_name.setBackground(Color.decode(colorbutton_));
        tf_position.setBackground(Color.decode(colorbutton_));
        
        
        ob.setBounds(90, 250, 110, 30);
        ob.setBackground(Color.decode(colorbutton_));
        ob.setForeground(Color.BLACK);
        ob.addActionListener(this);
        ob.setToolTipText("Save");
        ob.setMnemonic(KeyEvent.VK_S);
        panel.add(ob);

        bb.setBounds(240, 250, 110, 30);
        bb.setBackground(Color.decode(colorbutton_));
        bb.setForeground(Color.BLACK);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);
        
        
        
    }

    public static void main(String args[]) 
    {

        Delete_Member ob = new Delete_Member();
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == ob) {

            try {

                String name = tf_name.getText();
                String position = tf_position.getText();
                int i= Delete_MemberDao.delete(name, position);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! Delete member successfully.");
                }
                
                else 
                {
                    //System.out.println(e.toString());
                    JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
                }
                tf_name.setText(null);
                tf_position.setText(null);

            } 
            catch (Exception ee) 
            {

                 System.out.println(e.toString());
                 //JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");

            }
        }
        if(e.getSource()== bb)
        {
            new library_member();
            dispose();
        }

    }

}

