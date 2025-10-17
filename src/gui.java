import javax.swing.*;
import java.awt.*;
class gui extends Main {
    
    JFrame jf;
    JLabel jl,jl2;
    gui() {
        jl=new JLabel();
        jl.setText("Welcome to Food Management System");
        jl.setHorizontalTextPosition(JLabel.CENTER);
        jl.setVerticalTextPosition(JLabel.BOTTOM);
        jl.setHorizontalAlignment(JLabel.CENTER);
        jl.setVerticalAlignment(JLabel.CENTER);
        jl.setBounds(50, 10, 400, 100);
        ImageIcon img1=new ImageIcon("D:\\vs_code\\java project\\Food-Management-System\\images\\img1.jpg");
        ImageIcon img2=new ImageIcon("D:\\vs_code\\java project\\Food-Management-System\\images\\img2.png");
        java.awt.Image img=img2.getImage();
        java.awt.Image newimg=img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        img2=new ImageIcon(newimg);
        jl2=new JLabel();
        jl2.setText("LOGIN");
        jl2.setIcon(img2);
        jl2.setHorizontalTextPosition(JLabel.CENTER);
        jl2.setVerticalTextPosition(JLabel.BOTTOM);
        jl2.setHorizontalAlignment(JLabel.CENTER);
        jl2.setVerticalAlignment(JLabel.CENTER);
        jl2.setBounds(150, 100, 250, 250);

        JLabel userlabel=new JLabel();
        userlabel.setText("Username:");
        userlabel.setHorizontalTextPosition(JLabel.CENTER);
        userlabel.setVerticalTextPosition(JLabel.BOTTOM);
        userlabel.setHorizontalAlignment(JLabel.CENTER);
        userlabel.setVerticalAlignment(JLabel.CENTER);
        userlabel.setBounds(70, 370, 100, 30);
        JTextField tf=new JTextField();
        tf.setBounds(150, 370, 200, 30);

        JLabel passlabel=new JLabel();
        passlabel.setText("Password:");
        passlabel.setHorizontalTextPosition(JLabel.CENTER);
        passlabel.setVerticalTextPosition(JLabel.BOTTOM);
        passlabel.setHorizontalAlignment(JLabel.CENTER);
        passlabel.setVerticalAlignment(JLabel.CENTER);
        passlabel.setBounds(70, 410, 100, 30);
        JTextField tf2=new JTextField();
        tf2.setBounds(150, 410, 200, 30);

        JButton btn=new JButton();
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setVerticalAlignment(JButton.CENTER);
        btn.setBounds(200, 450, 100, 30);
        btn.setText("LOGIN");

       

        jf = new JFrame();
        jf.setTitle("Food Management System");
        jf.setSize(500, 600);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(new java.awt.Color(123, 50, 250));
        jf.setIconImage(img1.getImage());
        jf.add(jl, BorderLayout.NORTH);
        jf.add(jl2, BorderLayout.CENTER);
        jf.add(userlabel, BorderLayout.WEST);
        jf.add(tf, BorderLayout.EAST);
        jf.add(passlabel, BorderLayout.SOUTH);
        jf.add(tf2, BorderLayout.SOUTH);
        jf.add(btn, BorderLayout.SOUTH);

        jf.setLayout(null);
        //jf.pack();
        

    }
}