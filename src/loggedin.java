import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class loggedin implements ActionListener {
    JFrame loggedinframe;
    loggedin() {

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(1430, 10, 100, 30);
        logoutButton.setFont(new Font("Dialog", Font.PLAIN, 12));
        logoutButton.setFocusable(true);
        logoutButton.setBackground(Color.BLACK);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBorderPainted(false);
        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutButton.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent evt) {
        logoutButton.setBackground(Color.DARK_GRAY); 
        }

        public void mouseExited(MouseEvent evt) {
        logoutButton.setBackground(Color.BLACK);
        }
        });
        

        loggedinframe = new JFrame();
        loggedinframe.setTitle("Logged In");
        loggedinframe.setSize(1540, 820);
        loggedinframe.setResizable(false);
        loggedinframe.getContentPane().setBackground(new java.awt.Color(123, 50, 250));
        loggedinframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loggedinframe.setVisible(true);
        loggedinframe.setLayout(null);
        loggedinframe.add(logoutButton);
        logoutButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Logout")) {
            loggedinframe.dispose();
            gui g = new gui();
        }
    }
}
