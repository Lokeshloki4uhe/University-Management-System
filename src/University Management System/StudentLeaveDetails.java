package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    Choice choiceempID;
    JTable table;

    JButton search, cancel, print;

    StudentLeaveDetails() {

        getContentPane().setBackground(new Color(250, 172, 206));
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(heading);

        choiceempID = new Choice();
        choiceempID.setBounds(220, 20, 150, 30);
        add(choiceempID);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while (resultSet.next()) {
                choiceempID.add(resultSet.getString("rollnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
        add(scrollPane);

        // Search button
        search = new JButton("Search");
        search.setBounds(20, 70, 100, 30);
        search.setBackground(new Color(30, 144, 255)); // Dodger Blue
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        // Print button
        print = new JButton("Print");
        print.setBounds(140, 70, 100, 30);
        print.setBackground(new Color(0, 128, 0)); // Green
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(260, 70, 100, 30);
        cancel.setBackground(new Color(255, 69, 0)); // Red-Orange
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == search) {
            String q = "select * from studentleave where rollnumber = '" + choiceempID.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}
