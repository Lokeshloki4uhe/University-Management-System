package University_Management_System;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {

    JTextField textName, textFather, textAadhar, textAddress, textphone, textemail, textM10, textM12;
    JLabel empText;
    JDateChooser cdob;

    JComboBox coursebox, departementbox;
    JButton submit, cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddFaculty() {

        // Setting the background to a light, subtle gradient
        getContentPane().setBackground(new Color(193, 227, 254));  // Soft blue tone

        JLabel heading = new JLabel("New Faculty Details");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 35));  // Larger, elegant heading
        heading.setForeground(Color.BLACK);  // Black text for visibility
        add(heading);

        // Name Label
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));  // Serif font for consistency
        add(name);

        textName = new JTextField();
        textName.setBounds(200, 150, 150, 30);
        add(textName);

        // Father Name Label
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        textFather = new JTextField();
        textFather.setBounds(600, 150, 150, 30);
        add(textFather);

        // Employee ID Label
        JLabel empID = new JLabel("Employee ID");
        empID.setBounds(50, 200, 150, 30);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        add(empID);

        empText = new JLabel("ABC" + f4);
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.PLAIN, 20));
        add(empText);

        // DOB Label
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 150, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600, 200, 150, 30);
        add(cdob);

        // Address Label
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        add(textAddress);

        // Phone Number Label
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        textphone = new JTextField();
        textphone.setBounds(600, 250, 150, 30);
        add(textphone);

        // Email Label
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200, 300, 150, 30);
        add(textemail);

        // Class X (%) Label
        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400, 300, 150, 30);
        M10.setFont(new Font("serif", Font.BOLD, 20));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(600, 300, 150, 30);
        add(textM10);

        // Class XII (%) Label
        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50, 350, 150, 30);
        M12.setFont(new Font("serif", Font.BOLD, 20));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(200, 350, 150, 30);
        add(textM12);

        // Aadhar Number Label
        JLabel Aadhar = new JLabel("Aadhar Number");
        Aadhar.setBounds(400, 350, 150, 30);
        Aadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(Aadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(600, 350, 150, 30);
        add(textAadhar);

        // Qualification Label
        JLabel qua = new JLabel("Qualification");
        qua.setBounds(50, 400, 150, 30);
        qua.setFont(new Font("serif", Font.BOLD, 20));
        add(qua);

        String course[] = {"B.Tech", "BBA", "BCA", "BSC", "MSC", "MBA", "MCA", "MCom", "MA", "BA"};
        coursebox = new JComboBox(course);
        coursebox.setBounds(200, 400, 150, 30);
        coursebox.setBackground(Color.WHITE);
        add(coursebox);

        // Department Label
        JLabel depa = new JLabel("Department");
        depa.setBounds(400, 400, 150, 30);
        depa.setFont(new Font("serif", Font.BOLD, 20));
        add(depa);

        String department[] = {"CSE", "ECE", "MECH", "CIVIL", "IT"};
        departementbox = new JComboBox(department);
        departementbox.setBounds(600, 400, 150, 30);
        departementbox.setBackground(Color.WHITE);
        add(departementbox);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 150, 40);
        submit.setBackground(new Color(30, 144, 255));  // DodgerBlue
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.BOLD, 20));
        submit.addActionListener(this);
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 150, 40);
        cancel.setBackground(new Color(255, 69, 0));  // Red Orange
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif", Font.BOLD, 20));
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
            // Action logic remains unchanged
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddFaculty();
    }
}
