import javax.swing.*;
class gui extends Main {
    
    JFrame jf;
    JLabel jl,jl2;
    gui() {
        jl=new JLabel();
        jl.setText("Welcome to Food Management System");
        jl.setHorizontalTextPosition(jl.CENTER);
        jl.setVerticalTextPosition(jl.TOP);
        jl.setHorizontalAlignment(jl.CENTER);
        jl.setVerticalAlignment(jl.CENTER);
        jl.setBounds(50, 10, 400, 100);

        ImageIcon img1=new ImageIcon("C:\\Users\\surya\\OneDrive\\Documents\\GitHub\\Food-Management-System\\images\\img1.jpg");
        ImageIcon img2=new ImageIcon("C:\\Users\\surya\\OneDrive\\Documents\\GitHub\\Food-Management-System\\images\\img2.png");
        java.awt.Image img=img2.getImage();
        java.awt.Image newimg=img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        img2=new ImageIcon(newimg);
        jl2=new JLabel();
        jl2.setText("LOGIN");
        jl2.setIcon(img2);
        jl2.setHorizontalTextPosition(jl2.CENTER);
        jl2.setVerticalTextPosition(jl2.BOTTOM);
        jl2.setHorizontalAlignment(jl2.CENTER);
        jl2.setVerticalAlignment(jl2.CENTER);
        jl2.setBounds(150, 100, 250, 250);

        jf = new JFrame();
        jf.setTitle("Food Management System");
        jf.setSize(500, 500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(new java.awt.Color(123, 50, 250));
        jf.setIconImage(img1.getImage());
        jf.add(jl);
        jf.add(jl2);
        //jf.setLayout(null);
        //jf.pack();

    }
}