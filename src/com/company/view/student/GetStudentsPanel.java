package com.company.view.student;

import com.company.model.Course;
import com.company.model.Student;
import com.company.view.course.GetCoursesPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GetStudentsPanel extends JPanel {
    public JTable table = new JTable();
    public DefaultTableModel model = new DefaultTableModel();
    public GetStudentsPanel(Course course){

        String[] headers = {"ID", "Title", "Description"};
        table.setModel(model);
        model.setColumnIdentifiers(headers);
        for (var student : course.getStudents()){
            model.addRow(new Object[] {student.getId(), student.getName(), student.getSurname()});
        }
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
    }
}
