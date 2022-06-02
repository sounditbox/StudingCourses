package com.company.view.student;

import com.company.model.Course;
import com.company.model.Enrollment;
import com.company.model.Student;
import com.company.view.course.GetCoursesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetStudentsFrame extends JFrame {
    public static GetStudentsPanel panel;
    public GetStudentsFrame(Course course) {
        setTitle("Студенты курса " + course.getTitle());
        setLocation(750, 500);
        setSize(500, 520);
        setLayout(new FlowLayout());
        panel = new GetStudentsPanel(course);

        JButton button = new JButton("Отчислить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = panel.table.getSelectedRow();
                if (rowIndex != -1) {
                    int studentID = Integer.parseInt(panel.table.getValueAt(rowIndex, 0).toString());
                    panel.model.removeRow(rowIndex);

                    Enrollment.delete(Student.getStudentById(studentID), course);
                }
            }
        });
        add(button);
        add(panel);

        setVisible(true);

    }
}
