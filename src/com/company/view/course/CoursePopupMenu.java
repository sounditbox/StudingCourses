package com.company.view.course;


import com.company.model.Course;
import com.company.view.student.GetStudentsFrame;
import com.company.view.student.StudentChoice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursePopupMenu extends JPopupMenu {
    public static MenuActionListener menuActionListener = new MenuActionListener();
    public CoursePopupMenu() {

        add(item("Сохранить", "save"));
        add(item("Зачислить студента", "addStudent"));
        add(item("Список студентов", "getStudents"));
        addSeparator();
        add(item("Удалить", "delete"));

    }

    static JMenuItem item(String text, String command){
        JMenuItem item = new JMenuItem(text);
        item.setActionCommand(command);
        item.addActionListener(menuActionListener);
        return item;
    }

    static class MenuActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int rowIndex = CourseListPanel.table.getSelectedRow();
            int id = Integer.parseInt(CourseListPanel.table.getValueAt(rowIndex, 0).toString());
            String title = CourseListPanel.table.getValueAt(rowIndex, 1).toString();
            String description = CourseListPanel.table.getValueAt(rowIndex, 2).toString();

            switch (e.getActionCommand()){
                case "save":
                    Course.update(id, title, description);
                    break;
                case "delete":
                    Course.delete(id, rowIndex);
                    break;
                case "addStudent":
                    new StudentChoice(Course.getCourseById(id));
                    break;
                case "getStudents":
                    new GetStudentsFrame(Course.getCourseById(id));
                    break;
                default:
                    System.out.println("Непонятно, что тыкнули!");
                    break;
            }
        }
    }
}
