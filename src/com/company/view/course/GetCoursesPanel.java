package com.company.view.course;

import com.company.model.Course;
import com.company.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GetCoursesPanel extends JPanel {
    public JTable table = new JTable();
    public DefaultTableModel model = new DefaultTableModel();
    public GetCoursesPanel(Student student){

        String[] headers = {"ID", "Title", "Description"};
        table.setModel(model);
        model.setColumnIdentifiers(headers);
        for (var course : student.getCourses()){
            model.addRow(new Object[] {course.getId(), course.getTitle(), course.getDescription()});
        }
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
    }
}
