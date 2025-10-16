import javax.swing.*;
import java.awt.*;
class gui extends Main {
    
    JFrame jf;
    JLabel jl,jl2;
    gui() {
        jl=new JLabel();
        jl.setText("Welcome to Food Management System");
        jl.setHorizontalTextPosition(SwingConstants.CENTER);
        jl.setVerticalTextPosition(SwingConstants .BOTTOM);
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setVerticalAlignment(SwingConstants.CENTER);
        jl.setBounds(50, 10, 400, 100);
        ImageIcon img1=new ImageIcon("D:\\vs_code\\java project\\Food-Management-System\\images\\img1.jpg");
        ImageIcon img2=new ImageIcon("D:\\vs_code\\java project\\Food-Management-System\\images\\img2.png");
        java.awt.Image img=img2.getImage();
        java.awt.Image newimg=img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        img2=new ImageIcon(newimg);
        jl2=new JLabel();
        jl2.setText("LOGIN");
        jl2.setIcon(img2);
        jl2.setHorizontalTextPosition(SwingConstants.CENTER);
        jl2.setVerticalTextPosition(SwingConstants.BOTTOM);
        jl2.setHorizontalAlignment(SwingConstants.CENTER);
        jl2.setVerticalAlignment(SwingConstants.CENTER);
        jl2.setBounds(150, 100, 250, 250);

        JLabel userlabel=new JLabel();
        userlabel.setText("Username:");
        userlabel.setHorizontalTextPosition(SwingConstants.CENTER);
        userlabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        userlabel.setHorizontalAlignment(SwingConstants.CENTER);
        userlabel.setVerticalAlignment(SwingConstants.CENTER);
        userlabel.setBounds(70, 370, 100, 30);
        JTextField tf=new JTextField();
        tf.setBounds(150, 370, 200, 30);

        JLabel passlabel=new JLabel();
        passlabel.setText("Password:");
        passlabel.setHorizontalTextPosition(SwingConstants.CENTER);
        passlabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        passlabel.setHorizontalAlignment(SwingConstants.CENTER);
        passlabel.setVerticalAlignment(SwingConstants.CENTER);
        passlabel.setBounds(70, 410, 100, 30);
        JTextField tf2=new JTextField();
        tf2.setBounds(150, 410, 200, 30);

        JButton btn=new JButton();
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setVerticalAlignment(SwingConstants.CENTER);
        btn.setBounds(200, 450, 100, 30);
        btn.setText("LOGIN");

        jf = new JFrame();
        jf.setTitle("Food Management System");
        jf.setSize(800, 800);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(new java.awt.Color(123, 50, 250));
        jf.setIconImage(img1.getImage());
        jf.add(jl);
        jf.add(jl2);
        jf.add(userlabel);
        jf.add(tf);
        jf.add(passlabel);
        jf.add(tf2);
        jf.add(btn);
        jf.setLayout(null);
        //jf.pack();

    }
}