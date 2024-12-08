package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice CrollNumber;
    JComboBox<String> coursebox, departementbox, semesterbox;
    JLabel totalAmount;
    JButton pay, update, back;

    StudentFeeForm() {
        getContentPane().setBackground(new Color(210, 252, 251));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fee.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400, 50, 500, 300);
        add(img);

        JLabel rollnumber = new JLabel("Select Roll Number");
        rollnumber.setBounds(40, 60, 150, 20);
        rollnumber.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(rollnumber);

        CrollNumber = new Choice();
        CrollNumber.setBounds(200, 60, 150, 20);
        add(CrollNumber);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while (resultSet.next()) {
                CrollNumber.add(resultSet.getString("rollnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(40, 100, 150, 20);
        add(name);

        JLabel textname = new JLabel();
        textname.setBounds(200, 100, 150, 20);
        add(textname);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(40, 140, 150, 20);
        add(fname);

        JLabel textfname = new JLabel();
        textfname.setBounds(200, 140, 150, 20);
        add(textfname);

        CrollNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    String q = "select * from student where rollnumber = '" + CrollNumber.getSelectedItem() + "'";
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()) {
                        textname.setText(resultSet.getString("name"));
                        textfname.setText(resultSet.getString("fname"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        // Qualification
        JLabel qua = new JLabel("Course");
        qua.setBounds(40, 180, 150, 20);
        add(qua);

        String[] course = {"BTech", "BBA", "BCA", "BSC", "MSC", "MBA", "MCA", "MCom", "MA", "BA"};
        coursebox = new JComboBox<>(course);
        coursebox.setBounds(200, 180, 150, 20);
        coursebox.setBackground(Color.WHITE);
        add(coursebox);

        // Department
        JLabel depa = new JLabel("Branch");
        depa.setBounds(40, 220, 150, 20);
        add(depa);

        String[] department = {"CSE", "ECE", "MECH", "CIVIL", "IT"};
        departementbox = new JComboBox<>(department);
        departementbox.setBounds(200, 220, 150, 20);
        departementbox.setBackground(Color.WHITE);
        add(departementbox);

        // Semester
        JLabel textsemester = new JLabel("Semester");
        textsemester.setBounds(40, 250, 150, 20);
        add(textsemester);

        String[] semester = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        semesterbox = new JComboBox<>(semester);
        semesterbox.setBounds(200, 260, 150, 20);
        add(semesterbox);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40, 300, 150, 20);
        add(total);

        totalAmount = new JLabel();
        totalAmount.setBounds(200, 300, 150, 20);
        add(totalAmount);

        // Buttons
        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(new Color(0, 0, 0, 150));
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(new Color(0, 0, 0, 150));
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(new Color(0, 0, 0, 150));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String course = (String) coursebox.getSelectedItem();
            String semester = (String) semesterbox.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("select * from fee where course = '" + course + "'");
                while (resultSet.next()) {
                    totalAmount.setText(resultSet.getString(semester));
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == pay) {
            String rollnumber = CrollNumber.getSelectedItem();
            String course = (String) coursebox.getSelectedItem();
            String semester = (String) semesterbox.getSelectedItem();
            String branch = (String) departementbox.getSelectedItem();
            String total = totalAmount.getText();

            try {
                Conn c = new Conn();
                String q = "insert into feecollege values ('" + rollnumber + "','" + course + "','" + branch + "','" + semester + "','" + total + "')";
                c.statement.executeUpdate(q);  // Pass the query string to executeUpdate()
                JOptionPane.showMessageDialog(null, "Fee Submitted Successfully");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
