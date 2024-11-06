package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login, back;

    Login() {
        // Set background color for the frame
        getContentPane().setBackground(new Color(240, 248, 255));  // Light Blue background

        JLabel labelname = new JLabel("Username");
        labelname.setBounds(40, 20, 100, 20);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 14));  // Font change
        add(labelname);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 20, 150, 20);
        textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 14));  // Font change
        add(textFieldName);

        JLabel labelpass = new JLabel("Password");
        labelpass.setBounds(40, 70, 100, 20);
        labelpass.setFont(new Font("Tahoma", Font.BOLD, 14));  // Font change
        add(labelpass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));  // Font change
        add(passwordField);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(new Color(70, 130, 180));  // Steel Blue button background
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Tahoma", Font.BOLD, 14));  // Font change
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(180, 140, 120, 30);
        back.setBackground(new Color(70, 130, 180));  // Steel Blue button background
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));  // Font change
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 20, 200, 200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/loginback.png"));
        Image i22 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 600, 300);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = textFieldName.getText();
            String password = passwordField.getText();

            String query = "Select * from login Where username = '" + username + "' and password = '" + password + "'";

            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);

                if (resultSet.next()) {
                    setVisible(false);
                    //next class
                    new Main();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
