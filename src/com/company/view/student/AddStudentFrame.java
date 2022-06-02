package com.company.view.student;

import javax.swing.*;

public class AddStudentFrame extends JFrame {

    public AddStudentFrame() {
        setTitle("Создание нового студента");
        setLocation(750, 500);
        setSize(500, 300);
        add(new AddStudentPanel());
        setVisible(false);
    }
}
