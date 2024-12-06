package University_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ExamDetails extends JFrame implements ActionListener {

    JTextField search;
    JButton result, back;
    JTable table;

    ExamDetails() {
        getContentPane().setBackground(new Color(250, 240, 230));

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(350, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(new Color(70, 90, 140)); // Attractive color for the heading
        add(heading);

        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        search.setBackground(new Color(255, 255, 255)); // White background for text field
        add(search);

        result = new JButton("Result");
        result.setBounds(300, 90, 120, 30);
        result.setBackground(new Color(52, 152, 219)); // Attractive button color
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        add(result);

        back = new JButton("Back");
        back.setBounds(440, 90, 120, 30);
        back.setBackground(new Color(231, 76, 60)); // Attractive button color
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 130, 1000, 310);
        add(scrollPane);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });

        setSize(1000, 475);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == result) {
            setVisible(false);
            new Marks(search.getText());
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ExamDetails();
    }
}
