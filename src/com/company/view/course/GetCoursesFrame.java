package com.company.view.course;

import com.company.model.Course;
import com.company.model.Enrollment;
import com.company.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetCoursesFrame extends JFrame {
    public static GetCoursesPanel panel;
    public GetCoursesFrame(Student student){
        setTitle("Курсы студента " + student.getName() + " " + student.getSurname());
        setLocation(750, 500);
        setSize(500, 520);
        setLayout(new FlowLayout());
        panel = new GetCoursesPanel(student);

        JButton button = new JButton("Отчислить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = panel.table.getSelectedRow();
                if (rowIndex != -1) {
                    int courseID = Integer.parseInt(panel.table.getValueAt(rowIndex, 0).toString());
                    panel.model.removeRow(rowIndex);
                    Enrollment.delete(student, Course.getCourseById(courseID));
                }
            }
        });
        add(button);
        add(panel);

        setVisible(true);

    }


}
