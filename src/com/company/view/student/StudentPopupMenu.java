package com.company.view.student;

import com.company.model.Student;
import com.company.view.course.CourseChoice;
import com.company.view.course.GetCoursesFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPopupMenu extends JPopupMenu {
    public static MenuActionListener menuActionListener = new MenuActionListener();
    public StudentPopupMenu() {

        add(item("Сохранить", "save"));
        addSeparator();
        add(item("Зачислить на курс", "addCourse"));
        add(item("Показать курсы", "getCourses"));
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
            int rowIndex = StudentListPanel.table.getSelectedRow();
            int id = Integer.parseInt(StudentListPanel.table.getValueAt(rowIndex, 0).toString());
            String name = StudentListPanel.table.getValueAt(rowIndex, 1).toString();
            String surname = StudentListPanel.table.getValueAt(rowIndex, 2).toString();

            switch (e.getActionCommand()){
                case "save":
                    Student.update(id, name, surname);
                    break;
                case "delete":
                    Student.delete(id, rowIndex);
                    break;
                case "addCourse":
                    new CourseChoice(Student.getStudentById(id));
                    break;
                case "getCourses":
                    new GetCoursesFrame(Student.getStudentById(id));
                default:
                    System.out.println("Непонятно, что тыкнули!");
                    break;
            }
        }
    }
}
