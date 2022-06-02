package com.company.view.course;

import com.company.model.Course;
import com.company.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCoursePanel extends JPanel {
    public AddCoursePanel() {
        JTextField title = new JTextField(10);
        JTextField description = new JTextField(10);
        JButton saveButton = new JButton("Создать");

        add(title);
        add(description);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!title.getText().concat(description.getText()).isEmpty()) {
                    new Course(title.getText(), description.getText());
                    title.setText("");
                    description.setText("");
                    MainFrame.addCourseFrame.setVisible(false);

                }
            }
        });
    }
}
