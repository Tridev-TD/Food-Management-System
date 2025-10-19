import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loggedin implements ActionListener {
    JFrame loggedinframe;
    JLabel titleLabel, nameLabel, foodLabel, quantityLabel, expiryLabel, contactLabel;
    JTextField nameField, foodField, quantityField, expiryField, contactField;
    JTextArea outputArea;
    JButton submitButton, clearButton, logoutButton;

    loggedin() {

        loggedinframe = new JFrame("Food Donation Page");
        loggedinframe.setSize(550, 600);
        loggedinframe.setLayout(null);
        loggedinframe.setResizable(false);
        loggedinframe.getContentPane().setBackground(new Color(220, 240, 255));
        loggedinframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Food Donation Form");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(160, 20, 300, 30);
        loggedinframe.add(titleLabel);

        nameLabel = new JLabel("Donor Name:");
        foodLabel = new JLabel("Food Item:");
        quantityLabel = new JLabel("Quantity:");
        expiryLabel = new JLabel("Expiry Date:");
        contactLabel = new JLabel("Contact Number:");

        nameLabel.setBounds(80, 80, 120, 25);
        foodLabel.setBounds(80, 120, 120, 25);
        quantityLabel.setBounds(80, 160, 120, 25);
        expiryLabel.setBounds(80, 200, 120, 25);
        contactLabel.setBounds(80, 240, 120, 25);

        loggedinframe.add(nameLabel);
        loggedinframe.add(foodLabel);
        loggedinframe.add(quantityLabel);
        loggedinframe.add(expiryLabel);
        loggedinframe.add(contactLabel);

        nameField = new JTextField();
        foodField = new JTextField();
        quantityField = new JTextField();
        expiryField = new JTextField();
        contactField = new JTextField();

        nameField.setBounds(210, 80, 220, 25);
        foodField.setBounds(210, 120, 220, 25);
        quantityField.setBounds(210, 160, 220, 25);
        expiryField.setBounds(210, 200, 220, 25);
        contactField.setBounds(210, 240, 220, 25);

        loggedinframe.add(nameField);
        loggedinframe.add(foodField);
        loggedinframe.add(quantityField);
        loggedinframe.add(expiryField);
        loggedinframe.add(contactField);

        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        submitButton.setBounds(150, 290, 100, 30);
        clearButton.setBounds(280, 290, 100, 30);
        loggedinframe.add(submitButton);
        loggedinframe.add(clearButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(60, 350, 410, 180);
        loggedinframe.add(scrollPane);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String food = foodField.getText().trim();
                String qty = quantityField.getText().trim();
                String expiry = expiryField.getText().trim();
                String contact = contactField.getText().trim();

                if (name.isEmpty() || food.isEmpty() || qty.isEmpty() || expiry.isEmpty() || contact.isEmpty()) {
                    JOptionPane.showMessageDialog(loggedinframe, "Please fill all fields!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    try {
                        // Load SQLite JDBC driver
                        Class.forName("org.sqlite.JDBC");
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:login.db")) {

                        String insertSql = "INSERT INTO donate(name, food, quantity, date, contact) VALUES(?, ?, ?, ?, ?)";
                        PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                        insertStmt.setString(1, name);
                        insertStmt.setString(2, food);
                        insertStmt.setString(3, qty);
                        insertStmt.setString(4, expiry);
                        insertStmt.setString(5, contact);

                        insertStmt.executeUpdate();
                        System.out.println("Data inserted successfully!");
                    }

                    catch (SQLException ei) {
                        ei.printStackTrace();
                    }

                    outputArea.setText("Donation Details:\n");
                    outputArea.append("----------------------------------------\n");
                    outputArea.append("Donor Name: " + name + "\n");
                    outputArea.append("Food Item: " + food + "\n");
                    outputArea.append("Quantity: " + qty + "\n");
                    outputArea.append("Expiry Date: " + expiry + "\n");
                    outputArea.append("Contact Number: " + contact + "\n");
                    outputArea.append("----------------------------------------\n");
                    outputArea.append("Thank you, " + name + "! Your donation has been recorded.\n");

                    nameField.setText("");
                    foodField.setText("");
                    quantityField.setText("");
                    expiryField.setText("");
                    contactField.setText("");

                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                foodField.setText("");
                quantityField.setText("");
                expiryField.setText("");
                contactField.setText("");
                outputArea.setText("");
            }
        });

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

        loggedinframe.add(logoutButton);
        logoutButton.addActionListener(this);

        loggedinframe.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Logout")) {
            loggedinframe.dispose();
            gui g = new gui();
        }
    }
}
