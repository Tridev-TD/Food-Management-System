import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
class gui extends Main implements ActionListener {
    
    JFrame jf;
    JLabel jl,jl2;
    JTextField tf;
    JPasswordField tf2;
    gui() {
        jl=new JLabel();
        Font font = new Font("Monospaced", Font.BOLD, 24);
        jl.setFont(font);
        jl.setText("Food Management System");
        jl.setHorizontalTextPosition(JLabel.CENTER);
        jl.setVerticalTextPosition(JLabel.BOTTOM);
        jl.setHorizontalAlignment(JLabel.CENTER);
        jl.setVerticalAlignment(JLabel.CENTER);
        jl.setBounds(50, 10, 400, 100);
        ImageIcon img1=new ImageIcon("D:\\vs_code\\java project\\Food-Management-System\\images\\img1.jpg");
        ImageIcon img2=new ImageIcon("D:\\vs_code\\java project\\Food-Management-System\\images\\l.png");

        JPanel panel=new JPanel();
        //java.awt.Image img=img2.getImage();
        //java.awt.Image newimg=img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        //img2=new ImageIcon(newimg);
        jl2=new JLabel();
        jl2.setFont(font);
        jl2.setText("LOGIN");
        jl2.setIcon(img2);
        jl2.setHorizontalTextPosition(JLabel.CENTER);
        jl2.setVerticalTextPosition(JLabel.BOTTOM);
        jl2.setHorizontalAlignment(JLabel.CENTER);
        jl2.setVerticalAlignment(JLabel.CENTER);
        jl2.setBounds(120, 100, 250, 250);
        panel.add(jl2);
        panel.setVisible(true);
        panel.setBounds(120, 100, 250, 250);
        panel.setBackground(new java.awt.Color(123, 50, 250));

        JLabel userlabel=new JLabel();
        userlabel.setText("Username:");
        userlabel.setHorizontalTextPosition(JLabel.CENTER);
        userlabel.setVerticalTextPosition(JLabel.BOTTOM);
        userlabel.setHorizontalAlignment(JLabel.CENTER);
        userlabel.setVerticalAlignment(JLabel.CENTER);
        userlabel.setBounds(70, 370, 100, 30);
        tf=new JTextField();
        tf.setBounds(150, 370, 200, 30);

        JLabel passlabel=new JLabel();
        passlabel.setText("Password:");
        passlabel.setHorizontalTextPosition(JLabel.CENTER);
        passlabel.setVerticalTextPosition(JLabel.BOTTOM);
        passlabel.setHorizontalAlignment(JLabel.CENTER);
        passlabel.setVerticalAlignment(JLabel.CENTER);
        passlabel.setBounds(70, 410, 100, 30);
        tf2=new JPasswordField();
        tf2.setBounds(150, 410, 200, 30);

        JButton btn=new JButton();
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setVerticalAlignment(JButton.CENTER);
        btn.setBounds(180, 450, 135, 30);
        btn.setText("LOGIN");
        btn.setFocusable(true);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent evt) {
        btn.setBackground(Color.DARK_GRAY); 
        }

        public void mouseExited(MouseEvent evt) {
        btn.setBackground(Color.BLACK);
        }
        });

        
        JButton btn1=new JButton();
        btn1.setHorizontalTextPosition(JButton.CENTER);
        btn1.setVerticalTextPosition(JButton.BOTTOM);
        btn1.setHorizontalAlignment(JButton.CENTER);
        btn1.setVerticalAlignment(JButton.CENTER);
        btn1.setBounds(180, 490, 135, 30);
        btn1.setText("NEW ACCOUNT");
            btn1.setFocusable(true);
        btn1.setFocusable(true);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setBorderPainted(false);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent evt) {
        btn1.setBackground(Color.DARK_GRAY); 
        }

        public void mouseExited(MouseEvent evt) {
        btn1.setBackground(Color.BLACK);
        }
        });

       

        jf = new JFrame();
        jf.setTitle("Food Management System");
        jf.setSize(500, 600);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(new java.awt.Color(123, 50, 250));
        jf.setIconImage(img1.getImage());
        jf.add(jl, BorderLayout.NORTH);
        jf.add(panel, BorderLayout.CENTER);
        jf.add(userlabel, BorderLayout.WEST);
        jf.add(tf, BorderLayout.EAST);
        jf.add(passlabel, BorderLayout.SOUTH);
        jf.add(tf2, BorderLayout.SOUTH);
        jf.add(btn, BorderLayout.SOUTH);
        jf.add(btn1, BorderLayout.SOUTH);

        jf.setLayout(null);
        btn.addActionListener(this);
        btn1.addActionListener(this);
        //jf.pack();
        

    }
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        if(command.equals("LOGIN")) {
            

             try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
}
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:login.db")) {
            String username = tf.getText();

            String password = tf2.getText();
             String checkSql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            checkStmt.setString(2, password);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                jf.dispose();
                loggedin LoggedIn = new loggedin();
            } else {
                
                JOptionPane.showMessageDialog(jf, "Invalid Credentials ", "Error", JOptionPane.INFORMATION_MESSAGE);

                
            }

        } catch (SQLException ei) {
            ei.printStackTrace();
        }
    }



        
        else if(command.equals("NEW ACCOUNT")) {
            jf.dispose();
            newaccount newacc = new newaccount();
        }


    }
}