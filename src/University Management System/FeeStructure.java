package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class FeeStructure extends JFrame {
    FeeStructure() {

        getContentPane().setBackground(new Color(240, 250, 240)); // Soft green background

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(400, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(new Color(70, 90, 140)); // Attractive color for the heading
        add(heading);

        JTable table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 60, 1000, 700);
        add(js);

        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}
