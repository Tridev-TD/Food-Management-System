import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class newaccount implements ActionListener {
    JFrame newframe;
    newaccount() {


        JLabel titleLabel = new JLabel("Create a New Account");
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setBounds(100, 50, 300, 30);

        ImageIcon img2=new ImageIcon("D:\\vs_code\\java project\\Food-Management-System\\images\\l1.png");

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

        JTextField tf=new JTextField();
        tf.setBounds(200, 350, 200, 30);

        JLabel passlabel=new JLabel();
        passlabel.setText("Choose Password:");  
        passlabel.setHorizontalTextPosition(JLabel.CENTER);
        passlabel.setVerticalTextPosition(JLabel.BOTTOM);
        passlabel.setHorizontalAlignment(JLabel.CENTER);
        passlabel.setVerticalAlignment(JLabel.CENTER);
        passlabel.setBounds(70, 400, 120, 30);
        
        JTextField tf2=new JTextField();
        tf2.setBounds(200, 400, 200, 30);

        JLabel roleLabel = new JLabel("Select Role:");
        roleLabel.setBounds(70, 450, 100, 30);
        JCheckBox checkBox = new JCheckBox("DONOR");
        checkBox.setBounds(200, 450, 100, 30);
        JCheckBox checkBox2 = new JCheckBox("RECIPIENT");
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
            newframe.dispose();
            gui g=new gui();
        }
    }
}   