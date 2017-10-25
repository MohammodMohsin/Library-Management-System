

package library_management_.system;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main_Menu extends JFrame implements ActionListener
{
    String colorlayout_ = "#607D8B";
    String colorlabel_ = "#263238";
    String colorpane_ = "#B0BEC5";
    //String colorWhite100_ = "#ffffff";
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    
    JLabel l_welcome = new JLabel("Welcome To Library Management System");
    
    JLabel l_reserve_book = new JLabel("Reserve Books");
    //JLabel l_view_reserve_book = new JLabel("View Reserve Books");
    
    //JLabel l_view_issue_book = new JLabel("View Issue Books");
    JLabel l_library_member = new JLabel("Library Member");
    JLabel l_issue_book = new JLabel("Issue Book");
    JLabel l_library_card_user = new JLabel("Library Card User");
    JLabel l_return_book = new JLabel("Return Book");
    JLabel l_due_book = new JLabel("Due Book");
    
    
    JButton b_reserve_book=new JButton("",new ImageIcon("image/kk.jpg"));
    //JButton b_view_reserve_book=new JButton("",new ImageIcon("image/r.jpg"));
    
    JButton b_issue_book=new JButton("",new ImageIcon("image/books.jpg"));
   // JButton b_view_issue_book=new JButton("",new ImageIcon("image/bv.png"));
    
    JButton b_library_member=new JButton("",new ImageIcon("image/member.png"));
    JButton b_library_card_user=new JButton("",new ImageIcon("image/vm.jpg"));
    
    JButton b_return_book=new JButton("",new ImageIcon("image/rb.jpg"));
    JButton b_due_books=new JButton("",new ImageIcon("image/ss.jpg"));
    //JPanel panel = new JPanel();
    JDesktopPane pane = new JDesktopPane();
    ImageIcon ic=new ImageIcon();
    Font menufnt = new Font("Times New Roman", Font.PLAIN, 35);
    Font lfnt = new Font("Times New Roman", Font.PLAIN, 23);
    Connection con=null;
    Statement st = null;
    ResultSet rs=null;
    PreparedStatement ps = null;

    Main_Menu() 
    {
        super("Main Menu");
        Container conn= this.getContentPane();
        conn.setLayout(new BorderLayout());
        conn.setBackground(Color.decode(colorlayout_));
        //Lwelcome.setForeground(Color.decode(colorWhite100_));
       // Lwelcome.setFont(Lwelcome.getFont().deriveFont(40f));
        l_welcome.setHorizontalAlignment(SwingConstants.CENTER);
        l_welcome.setPreferredSize(new Dimension(80, 100));
        conn.add(l_welcome, BorderLayout.NORTH);
        setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
        setLocationRelativeTo(null);
        //pane.setLayout(null);
        conn.add(pane, BorderLayout.CENTER);
        pane.setBackground(Color.decode(colorpane_));
        pane.setLayout(null);
        add(pane);
        //pane.setBackground(Color.LIGHT_GRAY);
        setSize(dim);
        setVisible(true);
        //setLocation(400, 70);
        //setResizable(false);
        label();
        button();

    }
    void label()
    {
       // Lwelcome.setBounds(430, 30,900,60);
        l_welcome.setFont(menufnt);
        l_welcome.setForeground(Color.decode(colorlabel_));
        
        l_reserve_book.setBounds(180, 40,200,60);
        l_reserve_book.setFont(lfnt);
        l_reserve_book.setForeground(Color.BLACK);
        pane.add(l_reserve_book);
        
        l_issue_book.setBounds(660, 30, 200, 80);
        l_issue_book.setFont(lfnt);
        l_issue_book.setForeground(Color.BLACK);
        pane.add(l_issue_book);
        
       /* l_view_reserve_book.setBounds(270, 300,200,60);
        l_view_reserve_book.setFont(lfnt);
        l_view_reserve_book.setForeground(Color.BLACK);
        pane.add(l_view_reserve_book);
        
        l_view_issue_book.setBounds(610, 300,200,60);
        l_view_issue_book.setFont(lfnt);
        l_view_issue_book.setForeground(Color.BLACK);
        pane.add(l_view_issue_book);*/
        
        l_library_member.setBounds(180, 300,200,60);
        l_library_member.setFont(lfnt);
        l_library_member.setForeground(Color.black);
        pane.add(l_library_member);
        
        l_library_card_user.setBounds(630, 290, 300, 80);
        l_library_card_user.setFont(lfnt);
        l_library_card_user.setForeground(Color.black);
        pane.add(l_library_card_user);
        
        l_return_book.setBounds(1110, 30, 200, 80);
        l_return_book.setFont(lfnt);
        l_return_book.setForeground(Color.black);
        pane.add(l_return_book);
        
        l_due_book.setBounds(1125, 290, 200, 80);
        l_due_book.setFont(lfnt);
        l_due_book.setForeground(Color.black);
        pane.add(l_due_book);
       
    }
    
    void button()
    {
      
        b_reserve_book.setBounds(125,100, 240, 180);
        b_reserve_book.addActionListener(this);
        pane.add(b_reserve_book);
        
        b_issue_book.setBounds(590,100, 240, 180);
        b_issue_book.addActionListener(this);
        pane.add(b_issue_book);
        
       /* b_view_reserve_book.setBounds(275,360, 200, 150);
        b_view_reserve_book.addActionListener(this);
        pane.add(b_view_reserve_book);
        
        b_view_issue_book.setBounds(595,360, 200, 150);
        b_view_issue_book.addActionListener(this);
        pane.add(b_view_issue_book);*/
        
        b_library_member.setBounds(125,360, 240, 180);
        b_library_member.addActionListener(this);
        pane.add(b_library_member);
        
        b_return_book.setBounds(1055,100, 240, 180);
        b_return_book.addActionListener(this);
        pane.add(b_return_book);
        
        
        b_library_card_user.setBounds(590,360, 240, 180);
        b_library_card_user.addActionListener(this);
        pane.add(b_library_card_user);
        
        b_due_books.setBounds(1055,360, 240, 180);
        b_due_books.addActionListener(this);
        pane.add(b_due_books);

    }
    public static void main(String[] args)
    {
        Main_Menu ob=new Main_Menu();
    }
   
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b_reserve_book)
        {
            new Add_book();
            //dispose();
        
        }
        if(e.getSource()==b_issue_book)
        {
            new Book_issue();
            //dispose();
        
        }
        if(e.getSource()==b_library_member)
        {
            new library_member();
            //dispose();
        
        }
        /*if(e.getSource()==b_view_reserve_book)
        {
            new View_Library_Books();
            //dispose();
        
        }
        if(e.getSource()==b_view_issue_book)
        {
            new View_issue_books();
            //dispose();
        
        }*/
        
        if(e.getSource()==b_library_card_user)
        {
            new Student_info();
            //dispose();
        
        }
        
        if(e.getSource()==b_return_book)
        {
            new Return_book();
            //dispose();
        
        }
        
        if(e.getSource()==b_due_books)
        {
            new due_books();
            //dispose();
        
        }
        /*if (e.getSource() == b_due_books) {

            try {

                con = DB.getConnection();

            //   ps = con.prepareStatement("select library_books.book_name,library_books.author,library_books.publisher,library_books.quantity,count(issue_books.book_id) as issued   from library_books,issue_books  where library_books.book_id= issue_books.book_id group by(issue_books.book_id)");    
            ps = con.prepareStatement("select student_id,issue_date,return_date from issue_books");
            ps.execute();
            rs = ps.getResultSet();
            String student_id=rs.getString("student_id");
            String issue_date=rs.getString("issue_date");
            String return_date=rs.getString("return_date");
            String due = null;
            int books = 0;
            if(issue_date!=return_date)
            {
               due=new String("ok");
            }
            if(student_id!=null)
            {
               books=1;
            }
            else
            {
                books=0;
            }
            int i = Due_bookDao.save(student_id,issue_date,return_date,due,books);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } 
                else 
                {
                    System.out.println("failed");
                }

            } 
            catch (Exception ee) 
            {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
            
        }*/
        
        
 
    }
    }
    

