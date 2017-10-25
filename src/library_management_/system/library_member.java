

package library_management_.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;


public class library_member extends JFrame implements ActionListener 
{
    String colorpanel_ = "#90A4AE";
    String color_up_button_ = "#B0BEC5";
    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();
    JLabel l_name = new JLabel("Name  : ");
    JTextField tf_name = new JTextField(15);

    JLabel l_position = new JLabel("Position :  ");
    JTextField tf_position = new JTextField(15);

    JLabel l_contact = new JLabel("Contact :  ");
    JTextField tf_contact = new JTextField(15);

    JLabel l_joining_date = new JLabel("Joining Date :");
    JTextField tf_joining_date = new JTextField(15);
    
    JButton b_view_library_member = new JButton("View Library Member");
    JButton b_delete_member = new JButton("Delete member");

    JButton sb = new JButton("Save", new ImageIcon("image/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("image/Regis.png"));

    Font lfnt = new Font("SERIF", Font.BOLD | Font.PLAIN, 40);
    ImageIcon ic = new ImageIcon();

    library_member() {

        super("Library Member");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
        add(panel);
        setSize(550, 500);
        setVisible(true);
        setLocation(480, 70);
        Add_Component_E();

    }

    void Add_Component_E() {

        l_name.setBounds(90, 70, 130, 40);
        tf_name.setBounds(210, 70, 150, 40);
        //l_name.setFont(lfnt);
        panel.add(l_name);
        panel.add(tf_name);

        l_position.setBounds(90, 150, 130, 40);
        tf_position.setBounds(210, 150, 150, 40);
       // l_position.setFont(lfnt);
        panel.add(l_position);
        panel.add(tf_position);

        l_contact.setBounds(90, 230, 130, 40);
        tf_contact.setBounds(210, 230, 150, 40);
        //l_contact.setFont(lfnt);
        panel.add(l_contact);
        panel.add(tf_contact);

        l_joining_date.setBounds(90, 310, 130, 40);
        tf_joining_date.setBounds(210, 310, 150, 40);
       // l_joining_date.setFont(lfnt);
        panel.add(l_joining_date);
        panel.add(tf_joining_date);
        
        tf_name.setBackground(Color.decode(colorbutton_));
        tf_position.setBackground(Color.decode(colorbutton_));
        tf_contact.setBackground(Color.decode(colorbutton_));
        tf_joining_date.setBackground(Color.decode(colorbutton_));
        
        b_view_library_member.setBounds(1, 1, 170, 35);
        b_view_library_member.setForeground(Color.BLACK);
        b_view_library_member.addActionListener(this);
        //b_view_library_member.setToolTipText("View library member");
        //sb.setMnemonic(KeyEvent.VK_S);
        panel.add(b_view_library_member);
        
        b_delete_member.setBounds(170, 1, 170, 35);
        b_delete_member.setForeground(Color.BLACK);
        b_delete_member.addActionListener(this);
        //b_view_library_member.setToolTipText("View library member");
        //sb.setMnemonic(KeyEvent.VK_S);
        panel.add(b_delete_member);

        sb.setBounds(100, 395, 140, 35);
        sb.setForeground(Color.BLACK);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        panel.add(sb);

        bb.setBounds(290, 395, 140, 35);
        bb.setForeground(Color.BLACK);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);
        
        b_view_library_member.setBackground(Color.decode(color_up_button_));
        b_delete_member.setBackground(Color.decode(color_up_button_));
        sb.setBackground(Color.decode(colorbutton_));
        bb.setBackground(Color.decode(colorbutton_));

    }

    public static void main(String args[]) {

        library_member ob = new library_member();
    }

    public void actionPerformed(ActionEvent einfo) {
        if (einfo.getSource() == sb) {

            try {

                String name = tf_name.getText();
                
                String position = tf_position.getText();
                
                String contact = tf_contact.getText();
                
                String joining_date = tf_joining_date.getText();
                
                int i = library_memberDao.save(name, position, contact, joining_date);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } 
                else 
                {
                    System.out.println(einfo.toString());
                }
                tf_name.setText(null);
                tf_position.setText(null);
                tf_contact.setText(null);
                tf_joining_date.setText(null);

            } 
            catch (Exception ee) 
            {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }
        if(einfo.getSource()== bb)
        {
            //new Main_Menu();
            dispose();
        }
        if(einfo.getSource()==b_view_library_member)
        {
            new view_library_member();
            dispose();
        
        }
        if(einfo.getSource()==b_delete_member)
        {
            new Delete_Member();
            dispose();
        
        }

    }

}
