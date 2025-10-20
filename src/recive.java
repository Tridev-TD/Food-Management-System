import javax.swing.*;
import java.awt.event.MouseEvent;   
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
public class recive implements ActionListener {
    JFrame reciveFrame;
    JTextArea donationsArea;
    JButton logoutButton, refreshButton;

    recive() {
        reciveFrame = new JFrame("Recipient Page");
        reciveFrame.setSize(550, 600);
        reciveFrame.setLayout(null);
        reciveFrame.setResizable(false);
        reciveFrame.getContentPane().setBackground(new Color(220, 240, 255));
        reciveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel showdonationsLabel = new JLabel("Available Food Donations:");
        showdonationsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        showdonationsLabel.setBounds(150, 40, 300, 30);
        reciveFrame.add(showdonationsLabel);

        refreshButton = new JButton("Refresh List");
        refreshButton.setBounds(10, 10, 100, 30);
        refreshButton.setFont(new Font("Dialog", Font.PLAIN, 12));
        refreshButton.setFocusable(true);
        refreshButton.setBackground(Color.BLACK);
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setBorderPainted(false);
        refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        refreshButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                refreshButton.setBackground(Color.DARK_GRAY);
            }

            public void mouseExited(MouseEvent evt) {
                refreshButton.setBackground(Color.BLACK);
            }
        });
        reciveFrame.add(refreshButton);

        JButton donateButton = new JButton("Donate");
        donateButton.setBounds(120, 10, 100, 30);
        donateButton.setFont(new Font("Dialog", Font.PLAIN, 12));
        donateButton.setFocusable(true);
        donateButton.setBackground(Color.BLACK);
        donateButton.setForeground(Color.WHITE);
        donateButton.setBorderPainted(false);
        donateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        donateButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                donateButton.setBackground(Color.DARK_GRAY);
            }

            public void mouseExited(MouseEvent evt) {
                donateButton.setBackground(Color.BLACK);
            }
        });
        reciveFrame.add(donateButton);

        donationsArea = new JTextArea();
        donationsArea.setEditable(false);
        donationsArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(donationsArea);
        scrollPane.setBounds(50, 70, 450, 300);
        reciveFrame.add(scrollPane);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(400, 10, 100, 30);
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

        reciveFrame.add(logoutButton);
        logoutButton.addActionListener(this);
        refreshButton.addActionListener(this);
        donateButton.addActionListener(this);
        reciveFrame.setLocationRelativeTo(null);
        reciveFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Logout")) {
            reciveFrame.dispose();
            gui g = new gui();
        } else if (command.equals("Donate Food")) {
            reciveFrame.dispose();
            donation d = new donation();
        } else if (command.equals("Refresh List")) {
            donationsArea.append("");
            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:login.db");
                String sql = "SELECT name,food,quantity,date,contact FROM donate";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                donationsArea.setText("");
                while (rs.next()) {
                    
                    String name = rs.getString("name");
                    String foodItem = rs.getString("food");
                    int quantity = rs.getInt("quantity");
                    String expiryDate = rs.getString("date");
                    String contactInfo = rs.getString("contact");

                    donationsArea.append("Donor: " + name + "\n");
                    donationsArea.append("Food Item: " + foodItem + "\n");
                    donationsArea.append("Quantity: " + quantity + "\n");
                    donationsArea.append("Expiry Date: " + expiryDate + "\n");
                    donationsArea.append("Contact Info: " + contactInfo + "\n");
                    donationsArea.append("----------------------------------------\n");
                }

                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                donationsArea.append("Error retrieving donations: " + ex.getMessage() + "\n");
            }
        }
    }
    

}
