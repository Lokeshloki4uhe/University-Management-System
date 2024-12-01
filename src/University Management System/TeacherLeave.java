package University_Management_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice choicerollno, chotime;
    JDateChooser selDate;

    JButton submit, cancel;

    TeacherLeave() {
        getContentPane().setBackground(new Color(210, 232, 252));

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel rollNoLabel = new JLabel("Search by Employee ID");
        rollNoLabel.setBounds(60, 100, 200, 20);
        rollNoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(rollNoLabel);

        choicerollno = new Choice();
        choicerollno.setBounds(60, 130, 200, 20);
        add(choicerollno);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()) {
                choicerollno.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Date Label and Picker
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);

        selDate = new JDateChooser();
        selDate.setBounds(60, 210, 200, 25);
        add(selDate);

        // Time Duration
        JLabel timeLabel = new JLabel("Time Duration");
        timeLabel.setBounds(60, 260, 200, 20);
        timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(timeLabel);

        chotime = new Choice();
        chotime.setBounds(60, 290, 200, 20);
        chotime.add("Full Day");
        chotime.add("Half Day");
        add(chotime);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 30);
        submit.setBackground(new Color(30, 144, 255)); // Dodger Blue
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 30);
        cancel.setBackground(new Color(255, 69, 0)); // Red-Orange
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String rollno = choicerollno.getSelectedItem();
            String date = ((JTextField) selDate.getDateEditor().getUiComponent()).getText();
            String time = chotime.getSelectedItem();

            // Basic validation
            if (rollno.isEmpty() || date.isEmpty() || time.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return;
            }

            String Q = "insert into teacherleave values('" + rollno + "','" + date + "','" + time + "')";

            try {
                Conn c = new Conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
