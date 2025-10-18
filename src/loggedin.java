import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class loggedin implements ActionListener {
    JFrame loggedinframe;
    loggedin() {

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(1430, 10, 100, 30);
        

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
