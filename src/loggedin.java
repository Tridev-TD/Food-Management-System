import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class loggedin implements ActionListener {
    JFrame loggedinframe;
    JLabel titleLabel, nameLabel, foodLabel, quantityLabel, expiryLabel, contactLabel;
    JTextField nameField, foodField, quantityField, expiryField, contactField;
    JTextArea outputArea;
    JButton submitButton, clearButton, logoutButton;
    gui gui;
    donation donation;
    recive recive;
    

    loggedin() {

        loggedinframe = new JFrame("DASHBOARD");
        loggedinframe.setSize(550, 600);
        loggedinframe.setLayout(null);
        loggedinframe.setResizable(false);
        loggedinframe.getContentPane().setBackground(new Color(220, 240, 255));
        loggedinframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(10, 20, 300, 30);
        loggedinframe.add(titleLabel);

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
        
        JLabel welcomeLabel = new JLabel("Welcome to the Food Management System!");
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        welcomeLabel.setBounds(130, 100, 350, 30);
        loggedinframe.add(welcomeLabel);

        JLabel DonateLabel = new JLabel("To donate food, please visit the Donation Page.");
        DonateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        DonateLabel.setBounds(100, 180, 400, 30);
        loggedinframe.add(DonateLabel);

        JButton Donatebutton = new JButton("Go to Donation Page");
        Donatebutton.setBounds(200, 220, 150, 30);
        Donatebutton.setFont(new Font("Dialog", Font.PLAIN, 12));
        Donatebutton.setFocusable(true);
        Donatebutton.setBackground(Color.BLACK);
        Donatebutton.setForeground(Color.WHITE);
        Donatebutton.setBorderPainted(false);
        Donatebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Donatebutton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                Donatebutton.setBackground(Color.DARK_GRAY);
            }

            public void mouseExited(MouseEvent evt) {
                Donatebutton.setBackground(Color.BLACK);
            }
        });

        JLabel ReciveLabel = new JLabel("To receive food, please visit the Recipient Page.");  
        ReciveLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        ReciveLabel.setBounds(100, 260, 400, 30);
        loggedinframe.add(ReciveLabel);

        JButton Recivebutton = new JButton("Go to Recipient Page");
        Recivebutton.setBounds(200, 300, 150, 30);
        Recivebutton.setFont(new Font("Dialog", Font.PLAIN, 12));
        Recivebutton.setFocusable(true);
        Recivebutton.setBackground(Color.BLACK);
        Recivebutton.setForeground(Color.WHITE);
        Recivebutton.setBorderPainted(false);
        Recivebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Recivebutton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                Recivebutton.setBackground(Color.DARK_GRAY);
            }

            public void mouseExited(MouseEvent evt) {
                Recivebutton.setBackground(Color.BLACK);
            }
        });

        JLabel infoLabel = new JLabel("Thank you for being a part of our community!");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        infoLabel.setBounds(100, 340, 400, 30);
        loggedinframe.add(infoLabel);

        loggedinframe.add(Recivebutton);
        loggedinframe.add(Donatebutton);
        loggedinframe.add(logoutButton);

        logoutButton.addActionListener(this);
        Donatebutton.addActionListener(this);
        Recivebutton.addActionListener(this);


        loggedinframe.setLocationRelativeTo(null);
        loggedinframe.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Logout")) {
            loggedinframe.dispose();
            gui = new gui();
        } else if (command.equals("Go to Donation Page")) {
            loggedinframe.dispose();
            donation = new donation();
        } else if (command.equals("Go to Recipient Page")) {
            loggedinframe.dispose();
            recive = new recive();
        }
    }
}
