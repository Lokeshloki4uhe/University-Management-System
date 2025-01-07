package University_Management_System;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About() {

        // Updated the image scaling and placement
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/about.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(200, 20, 300, 200);  // Centered the image
        add(img);

        // Updated heading font and position
        JLabel heading = new JLabel("<html>ABC<br>University</html>");
        heading.setBounds(220, 220, 300, 100);
        heading.setFont(new Font("Serif", Font.BOLD, 32));  // Serif font for a more academic feel
        heading.setHorizontalAlignment(SwingConstants.CENTER);  // Centered text
        add(heading);

        // Updated name font and position
        JLabel name = new JLabel("Lokesh Chitalapudi");
        name.setBounds(200, 320, 300, 30);
        name.setFont(new Font("Serif", Font.PLAIN, 24));  // Elegant font style
        name.setHorizontalAlignment(SwingConstants.CENTER);
        add(name);

        // Updated contact font and position
        JLabel contact = new JLabel("chintalapudilokesh4444@gmail.com");
        contact.setBounds(120, 370, 460, 30);
        contact.setFont(new Font("Serif", Font.ITALIC, 20));  // Italic font for contact info
        contact.setHorizontalAlignment(SwingConstants.CENTER);
        add(contact);

        // Updated window size, location, and background color
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(new Color(232, 240, 254));  // Light blue for a calm background
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
