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
public class recive {
    JFrame reciveFrame;
    

    recive() {
        reciveFrame = new JFrame("Recipient Page");
        reciveFrame.setSize(550, 600);
        reciveFrame.setLayout(null);
        reciveFrame.setResizable(false);
        reciveFrame.getContentPane().setBackground(new Color(220, 240, 255));
        reciveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        

        reciveFrame.setLocationRelativeTo(null);
        reciveFrame.setVisible(true);
    }

}
