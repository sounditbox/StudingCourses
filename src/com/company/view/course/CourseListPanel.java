package com.company.view.course;

import com.company.model.Course;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CourseListPanel extends JPanel {
    public static JTable table = new JTable();

    public CourseListPanel() {
        String headers[] = {"ID", "Title", "Description"};

        CoursePopupMenu popupMenu = new CoursePopupMenu();
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
        // Определение столбцов
        Course.model.setColumnIdentifiers(headers);


        table.setModel(Course.model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
    }



}