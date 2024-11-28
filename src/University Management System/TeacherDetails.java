package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice choice;
    JTable table;

    JButton search, print, update, add, cancel;

    TeacherDetails() {

        getContentPane().setBackground(new Color(192, 164, 252));

        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(heading);

        choice = new Choice();
        choice.setBounds(220, 20, 150, 30);
        add(choice);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()) {
                choice.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            // Optionally set row height or column width here
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 100, 900, 600);
        add(js);

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

        // Add button
        add = new JButton("Add");
        add.setBounds(260, 70, 100, 30);
        add.setBackground(new Color(30, 144, 255)); // Dodger Blue
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // Update button
        update = new JButton("Update");
        update.setBounds(380, 70, 100, 30);
        update.setBackground(new Color(255, 165, 0)); // Orange
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(500, 70, 100, 30);
        cancel.setBackground(new Color(255, 69, 0)); // Red-Orange
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
            String q = "select * from teacher where empID = '" + choice.getSelectedItem() + "'";
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
            new AddFaculty();
        } else if (e.getSource() == update) {
            // Handle update logic here (similar to add faculty)
            // For example, open an update dialog or a new window for updating details
            JOptionPane.showMessageDialog(null, "Update functionality to be implemented.");
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherDetails();
    }
}
