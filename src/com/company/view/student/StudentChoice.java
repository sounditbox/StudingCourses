package com.company.view.student;

import com.company.model.Course;
import com.company.model.Enrollment;
import com.company.model.Student;
import com.company.view.course.CourseListPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentChoice extends JFrame {
    public static StudentListPanel panel = new StudentListPanel();

    public StudentChoice(Course course) {
        setLayout(new FlowLayout());
        setTitle("Зачисление студента на курс " + course.getTitle());
        setSize(500, 500);
        setLocation(1920 / 2 - 150, 1080 / 2 - 200);

        JButton button = new JButton("Зачислить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int rowIndex = panel.table.getSelectedRow();
                if (rowIndex != 1) {
                    int studentId = Integer.parseInt(panel.table.getValueAt(rowIndex, 0).toString());
                    new Enrollment(Student.getStudentById(studentId), course);
                }
            }
        });

        add(button);
        add(panel);

        setVisible(true);

    }
}
