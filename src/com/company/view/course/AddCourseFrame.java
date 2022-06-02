package com.company.view.course;

import javax.swing.*;

public class AddCourseFrame extends JFrame {

    public AddCourseFrame() {
        setTitle("Создание нового курса");
        setLocation(750, 500);
        setSize(500, 300);
        add(new AddCoursePanel());
        setVisible(false);
    }
}