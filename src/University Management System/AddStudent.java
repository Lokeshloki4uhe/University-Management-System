package University_Management_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {

    JTextField textName, textFather, textAadhar, textAddress, textphone, textemail, textM10, textM12;
    JLabel empText;
    JDateChooser cdob;

    JComboBox coursebox, departementbox;
    JButton submit, cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {

        getContentPane().setBackground(new Color(238, 245, 255)); // Light blue background

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(new Color(26, 13, 171)); // Dark blue text
        add(heading);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setForeground(new Color(26, 13, 171));
        add(name);

        textName = new JTextField();
        textName.setBounds(200, 150, 150, 30);
        add(textName);

        // Father's Name
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("Arial", Font.BOLD, 20));
        fname.setForeground(new Color(26, 13, 171));
        add(fname);

        textFather = new JTextField();
        textFather.setBounds(600, 150, 150, 30);
        add(textFather);

        // Roll Number
        JLabel empID = new JLabel("Roll Number");
        empID.setBounds(50, 200, 200, 30);
        empID.setFont(new Font("Arial", Font.BOLD, 20));
        empID.setForeground(new Color(26, 13, 171));
        add(empID);

        empText = new JLabel("Student" + f4);
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("Arial", Font.BOLD, 20));
        empText.setForeground(new Color(26, 13, 171));
        add(empText);

        // DOB
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("Arial", Font.BOLD, 20));
        dob.setForeground(new Color(26, 13, 171));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600, 200, 150, 30);
        add(cdob);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("Arial", Font.BOLD, 20));
        address.setForeground(new Color(26, 13, 171));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        add(textAddress);

        // Phone Number
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("Arial", Font.BOLD, 20));
        phone.setForeground(new Color(26, 13, 171));
        add(phone);

        textphone = new JTextField();
        textphone.setBounds(600, 250, 150, 30);
        add(textphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("Arial", Font.BOLD, 20));
        email.setForeground(new Color(26, 13, 171));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200, 300, 150, 30);
        add(textemail);

        // Marks X
        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400, 300, 200, 30);
        M10.setFont(new Font("Arial", Font.BOLD, 20));
        M10.setForeground(new Color(26, 13, 171));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(600, 300, 150, 30);
        add(textM10);

        // Marks 12
        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50, 350, 200, 30);
        M12.setFont(new Font("Arial", Font.BOLD, 20));
        M12.setForeground(new Color(26, 13, 171));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(200, 350, 150, 30);
        add(textM12);

        // Aadhar
        JLabel Aadhar = new JLabel("Aadhar Number");
        Aadhar.setBounds(400, 350, 200, 30);
        Aadhar.setFont(new Font("Arial", Font.BOLD, 20));
        Aadhar.setForeground(new Color(26, 13, 171));
        add(Aadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(600, 350, 150, 30);
        add(textAadhar);

        // Qualification
        JLabel qua = new JLabel("Course");
        qua.setBounds(50, 400, 200, 30);
        qua.setFont(new Font("Arial", Font.BOLD, 20));
        qua.setForeground(new Color(26, 13, 171));
        add(qua);

        String course[] = {"B.Tech", "BBA", "BCA", "BSC", "MSC", "MBA", "MCA", "MCom", "MA", "BA"};
        coursebox = new JComboBox(course);
        coursebox.setBounds(200, 400, 150, 30);
        coursebox.setBackground(Color.WHITE);
        add(coursebox);

        // Department
        JLabel depa = new JLabel("Branch");
        depa.setBounds(400, 400, 200, 30);
        depa.setFont(new Font("Arial", Font.BOLD, 20));
        depa.setForeground(new Color(26, 13, 171));
        add(depa);

        String department[] = {"CSE", "ECE", "MECH", "CIVIL", "IT"};
        departementbox = new JComboBox(department);
        departementbox.setBounds(600, 400, 150, 30);
        departementbox.setBackground(Color.WHITE);
        add(departementbox);

        // Submit
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(new Color(34, 193, 195)); // Attractive button color
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        // Cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(new Color(255, 87, 34)); // Attractive button color
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = textName.getText();
            String fname = textFather.getText();
            String empID = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textphone.getText();
            String email = textemail.getText();
            String class_X = textM10.getText();
            String class_XII = textM12.getText();
            String aadhar = textAadhar.getText();
            String course = (String) coursebox.getSelectedItem();
            String department = (String) departementbox.getSelectedItem();

            try {
                String q = "insert into student values('" + name + "','" + fname + "','" + empID + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + class_X + "','" + class_XII + "','" + aadhar + "','" + course + "','" + department + "')";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Inserted");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
