import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class newaccount implements ActionListener {
    JFrame newframe;
    private JTextField tf; 
    private JTextField tf2; 
    private JCheckBox checkBox; 
    private JCheckBox checkBox2; 
    newaccount() {


        JLabel titleLabel = new JLabel("Create a New Account");
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setBounds(100, 50, 300, 30);

        ImageIcon img2=new ImageIcon("C:\\Java Project\\Food-Management-System\\images\\l1.png");

        JPanel createPanel=new JPanel();
        java.awt.Image img=img2.getImage();
        java.awt.Image newimg=img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        img2=new ImageIcon(newimg);
        JLabel imgLabel=new JLabel();
        imgLabel.setText("LOGIN");
        imgLabel.setIcon(img2);
        imgLabel.setHorizontalTextPosition(JLabel.CENTER);
        imgLabel.setVerticalTextPosition(JLabel.BOTTOM);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setVerticalAlignment(JLabel.CENTER);
        imgLabel.setBounds(120, 100, 250, 250);
        createPanel.add(imgLabel);
        createPanel.setVisible(true);
        createPanel.setBounds(120, 100, 250, 250);
        createPanel.setBackground(new java.awt.Color(123, 50, 250));


        JLabel userlabel=new JLabel();
        userlabel.setText("Choose Username:");
        userlabel.setHorizontalTextPosition(JLabel.CENTER);
        userlabel.setVerticalTextPosition(JLabel.BOTTOM);
        userlabel.setHorizontalAlignment(JLabel.CENTER);
        userlabel.setVerticalAlignment(JLabel.CENTER);
        userlabel.setBounds(70, 350, 120, 30);

    tf=new JTextField();
    tf.setBounds(200, 350, 200, 30);

        JLabel passlabel=new JLabel();
        passlabel.setText("Choose Password:");  
        passlabel.setHorizontalTextPosition(JLabel.CENTER);
        passlabel.setVerticalTextPosition(JLabel.BOTTOM);
        passlabel.setHorizontalAlignment(JLabel.CENTER);
        passlabel.setVerticalAlignment(JLabel.CENTER);
        passlabel.setBounds(70, 400, 120, 30);
        
    tf2=new JTextField();
    tf2.setBounds(200, 400, 200, 30);

        JLabel roleLabel = new JLabel("Select Role:");
        roleLabel.setBounds(70, 450, 100, 30);
    checkBox = new JCheckBox("DONOR");
    checkBox.setBounds(200, 450, 100, 30);
    checkBox2 = new JCheckBox("RECIPIENT");
    checkBox2.setBounds(300, 450, 100, 30);
        JButton createButton = new JButton("CREATE ACCOUNT");
        createButton.setBounds(180, 500, 150, 30);


        newframe = new JFrame();
        newframe.setTitle("New Account");
        newframe.setSize(500, 600);
        newframe.getContentPane().setBackground(new java.awt.Color(123, 50, 250));
        newframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newframe.setVisible(true);
        newframe.setLayout(null);
        newframe.add(titleLabel);
        newframe.add(createPanel);
        newframe.add(userlabel);
        newframe.add(tf);
        newframe.add(passlabel);
        newframe.add(tf2);  
        newframe.add(roleLabel);
        newframe.add(checkBox);
        newframe.add(checkBox2);
        newframe.add(createButton);
        createButton.addActionListener(this);
        

    }public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();

        if(command.equals("CREATE ACCOUNT")) {
            String username = tf.getText();

            String password = tf2.getText();
            

            if(username.trim().isEmpty() || password.trim().isEmpty()){
                JOptionPane.showMessageDialog(newframe, "Username and password cannot be empty", "Validation", JOptionPane.WARNING_MESSAGE);
                return;
            }

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);


            JOptionPane.showMessageDialog(newframe, "Created account\nUser: " + username , "Account Created", JOptionPane.INFORMATION_MESSAGE);

                    try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
}
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:login.db")) {

            String checkSql = "SELECT COUNT(*) FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Username already exists!");
            } else {
                // Insert new user
                String insertSql = "INSERT INTO users(username, password) VALUES(?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setString(1, username);
                insertStmt.setString(2, password);
                insertStmt.executeUpdate();
                System.out.println("User added successfully!");
            }

        } catch (SQLException ei) {
            ei.printStackTrace();
        }
    }

            newframe.dispose();
            gui g=new gui();
        }
    }
