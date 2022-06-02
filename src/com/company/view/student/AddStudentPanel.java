package com.company.view.student;

import com.company.model.Student;
import com.company.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentPanel extends JPanel {
    public AddStudentPanel() {
        JTextField name = new JTextField(10);
        JTextField surname = new JTextField(10);
        JButton saveButton = new JButton("Создать");

        add(name);
        add(surname);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!name.getText().concat(surname.getText()).isEmpty()) {
                    new Student(name.getText(), surname.getText());
                    name.setText("");
                    surname.setText("");
                    MainFrame.addStudentFrame.setVisible(false);
                }
            }
        });
    }
}