package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentDetails extends JFrame implements ActionListener {

    Choice choice;
    JTable table;

    JButton search, print, update, add, cancel;

    StudentDetails() {
        getContentPane().setBackground(new Color(210, 252, 218));

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(heading);

        choice = new Choice();
        choice.setBounds(180, 20, 150, 20);
        add(choice);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while (resultSet.next()) {
                choice.add(resultSet.getString("rollnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 100, 900, 600);
        add(js);

        // Search
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        // Print
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        // Add
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // Update
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        // Cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String q = "select * from student where rollnumber = '" + choice.getSelectedItem() + "'";
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
        } else if (e.getSource() == add) {
            setVisible(false);
            new AddStudent();
        } else if (e.getSource() == update) {
            // Update logic here
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
