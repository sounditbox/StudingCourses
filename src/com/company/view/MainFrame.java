package com.company.view;

import com.company.Main;
import com.company.view.course.AddCourseFrame;
import com.company.view.course.CourseListPanel;
import com.company.view.course.GetCoursesFrame;
import com.company.view.student.AddStudentFrame;
import com.company.view.student.StudentListPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static AddStudentFrame addStudentFrame = new AddStudentFrame();
    public static AddCourseFrame addCourseFrame = new AddCourseFrame();
    public static StudentListPanel studentListPanel = new StudentListPanel();
    public static CourseListPanel courseListPanel = new CourseListPanel();


    public MainFrame() {
        setTitle("LMS");
        setSize(500, 600);
        setLocation(750, 300);
        setLayout(new FlowLayout());
        setJMenuBar(new MainMenu());
        add(studentListPanel);
        setVisible(true);
    }
}