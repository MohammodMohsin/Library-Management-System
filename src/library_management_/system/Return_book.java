package library_management_.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;

public class Return_book extends JFrame implements ActionListener 
{
    String colorpanel_ = "#90A4AE";
    //String colorTField_ = "#ECEFF1";
    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();
    //JLabel b_id = new JLabel("Book ID  : ");
   // JTextField t_id = new JTextField(15);

    JLabel b_name = new JLabel("Book Name  :  ");
    JTextField tf_bname = new JTextField(15);

    //JLabel stu_name = new JLabel("Student Name :  ");

    //JTextField tf_stu_name = new JTextField(15);

    JLabel stu_id = new JLabel("Student ID : ");
    JTextField tf_stu_id = new JTextField(15);

    //JLabel issue_date = new JLabel("Issue Date");
    //JTextField tf_issue_date = new JTextField(15);

    JButton ob = new JButton("Ok", new ImageIcon("image/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("image/Regis.png"));

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 15);
    ImageIcon ic = new ImageIcon();

    Return_book() {

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

        b_name.setBounds(110, 150, 100, 30);
        tf_bname.setBounds(200, 150, 150, 30);
        panel.add(b_name);
        panel.add(tf_bname);

        stu_id.setBounds(110, 75,100,30);
        tf_stu_id.setBounds(200, 75, 150, 30);
        panel.add(stu_id);
        panel.add(tf_stu_id);

        tf_stu_id.setBackground(Color.decode(colorbutton_));
        tf_bname.setBackground(Color.decode(colorbutton_));
        
        
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

        Return_book ob = new Return_book();
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == ob) {

            try {

                String stu_id = tf_stu_id.getText();
                String book_name = tf_bname.getText();
                int i= Return_bookDao.delete(stu_id, book_name);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! Return book successfully.");
                }
                
                else 
                {
                    //System.out.println(e.toString());
                    JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
                }
                tf_stu_id.setText(null);
                tf_bname.setText(null);

            } 
            catch (Exception ee) 
            {

                 System.out.println(e.toString());
                 //JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");

            }
        }
        if(e.getSource()== bb)
        {
            //new Main_Menu();
            dispose();
        }

    }

}
