package University_Management_System;

import com.toedter.calendar.JDateChooser;
import jdk.jshell.spi.ExecutionControlProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField textAddress,textphone,textemail,textAadhar,textcourse,textbranch;
    JLabel empText;
    JButton submit,cancel;

    Choice cEMPID;
    UpdateTeacher() {


        getContentPane().setBackground(new Color(230, 210, 252));

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel empID = new JLabel("Select Employee ID");
        empID.setBounds(50, 100, 200, 20);
        empID.setFont(new Font("serif", Font.PLAIN, 20));
        add(empID);

        cEMPID = new Choice();
        cEMPID.setBounds(250, 100, 200, 20);
        add(cEMPID);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()) {
                cEMPID.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Name

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200, 150, 150, 30);
        add(textName);

        //FatherName

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        JLabel textFather = new JLabel();
        textFather.setBounds(600, 150, 150, 30);
        add(textFather);

        //Employee Id

        JLabel EMPIDD = new JLabel("Employee Id");
        EMPIDD.setBounds(50, 200, 200, 30);
        EMPIDD.setFont(new Font("serif", Font.BOLD, 20));
        add(EMPIDD);

        empText = new JLabel();
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        add(empText);

        //DOB

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        JLabel cdob = new JLabel();
        cdob.setBounds(600, 200, 150, 30);
        add(cdob);

        //Address

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        add(textAddress);

        //Phone Number

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        textphone = new JTextField();
        textphone.setBounds(600, 250, 150, 30);
        add(textphone);

        //Email

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200, 300, 150, 30);
        add(textemail);

        //Marks X

        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400, 300, 200, 30);
        M10.setFont(new Font("serif", Font.BOLD, 20));
        add(M10);

        JLabel textM10 = new JLabel();
        textM10.setBounds(600, 300, 150, 30);
        add(textM10);

        //Marks 12

        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50, 350, 200, 30);
        M12.setFont(new Font("serif", Font.BOLD, 20));
        add(M12);

        JLabel textM12 = new JLabel();
        textM12.setBounds(200, 350, 150, 30);
        add(textM12);

        //Aadhar

        JLabel Aadhar = new JLabel("Aadhar Number");
        Aadhar.setBounds(400, 350, 200, 30);
        Aadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(Aadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(600, 350, 150, 30);
        add(textAadhar);

        //Qualification

        JLabel qua = new JLabel("Qualification");
        qua.setBounds(50, 400, 200, 30);
        qua.setFont(new Font("serif", Font.BOLD, 20));
        add(qua);

        textcourse = new JTextField();
        textcourse.setBounds(200, 400, 150, 30);
        add(textcourse);


        //Department

        JLabel depa = new JLabel("Department");
        depa.setBounds(400, 400, 200, 30);
        depa.setFont(new Font("serif", Font.BOLD, 20));
        add(depa);

        textbranch = new JTextField();
        textbranch.setBounds(600, 400, 150, 30);
        add(textbranch);

        try {
            Conn c = new Conn();
            String query = "select * from teacher where empID = '" + cEMPID.getSelectedItem() + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textFather.setText(resultSet.getString("fname"));
                cdob.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textphone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_X"));
                textM12.setText(resultSet.getString("class_XII"));
                textAadhar.setText(resultSet.getString("aadhar"));
                empText.setText(resultSet.getString("empID"));
                textcourse.setText(resultSet.getString("qualification"));
                textbranch.setText(resultSet.getString("department"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        cEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where empID = '" + cEMPID.getSelectedItem() + "'";
                    ResultSet resultSet = c.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textFather.setText(resultSet.getString("fname"));
                        cdob.setText(resultSet.getString("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textphone.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));
                        textM10.setText(resultSet.getString("class_X"));
                        textM12.setText(resultSet.getString("class_XII"));
                        textAadhar.setText(resultSet.getString("aadhar"));
                        empText.setText(resultSet.getString("empID"));
                        textcourse.setText(resultSet.getString("qualification"));
                        textbranch.setText(resultSet.getString("department"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });


        //Submit

        submit = new JButton("Update");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        //Cancel

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
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

        if(e.getSource()==submit){
            String empid = empText.getText();
            String address = textAddress.getText();
            String phone  = textphone.getText();
            String email  = textemail.getText();
            String course = textcourse.getText();
            String branch = textbranch.getText();

            try{
                String q = "update teacher set address = '"+address+"',phone = '"+phone+"',email='"+email+"',qualification = '"+course+"',department = '"+branch+"'where empID = '"+empid+"'";
                Conn c = new Conn();
                c.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Details Updated");
                setVisible(false);

            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}

