package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice choiceempID;
    JTable table;

    JButton search, cancel, print;

    TeacherLeaveDetails() {
        getContentPane().setBackground(new Color(250, 172, 206));
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 150, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        choiceempID = new Choice();
        choiceempID.setBounds(180, 20, 150, 20);
        add(choiceempID);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()) {
                choiceempID.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
        add(scrollPane);

        // Search button
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 30);
        search.setBackground(new Color(30, 144, 255)); // Dodger Blue
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        // Print button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 30);
        print.setBackground(new Color(34, 139, 34)); // Forest Green
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 30);
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
            String q = "select * from teacherleave where empID = '" + choiceempID.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                if (!resultSet.isBeforeFirst()) { // Check if the result set is empty
                    JOptionPane.showMessageDialog(null, "No records found for the selected Employee ID.");
                } else {
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }
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
        new TeacherLeaveDetails();
    }
}
