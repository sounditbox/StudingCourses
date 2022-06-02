package com.company.view.student;

import com.company.model.Student;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentListPanel extends JPanel {
    public static JTable table = new JTable();


    public StudentListPanel() {
        String headers[] = {"ID", "Name", "Surname"};
        // Определение столбцов
        Student.model.setColumnIdentifiers(headers);
        table.setModel(Student.model);


        StudentPopupMenu popupMenu = new StudentPopupMenu();
        setComponentPopupMenu(popupMenu);
        table.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == 3) {
                            int currentRow = table.rowAtPoint(e.getPoint());
                            table.setRowSelectionInterval(currentRow, currentRow);
                            popupMenu.show(table, e.getX(), e.getY());
                        }
                    }
                }
        );


        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
    }
}