package com.company.view.course;

import com.company.model.Course;
import com.company.model.Enrollment;
import com.company.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseChoice extends JFrame {
    public static CourseListPanel panel = new CourseListPanel();

    public CourseChoice(Student student) {
        setLayout(new FlowLayout());
        setTitle("Выбор курса для зачисления");
        setSize(500, 500);
        setLocation(1920 / 2 - 150, 1080 / 2 - 200);

        JButton button = new JButton("Зачислить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int rowIndex = panel.table.getSelectedRow();
                if (rowIndex != 1) {
                    int courseID = Integer.parseInt(panel.table.getValueAt(rowIndex, 0).toString());
                    new Enrollment(student, Course.getCourseById(courseID));

                }
            }
        });

        add(button);
        add(panel);

        setVisible(true);

    }
}
