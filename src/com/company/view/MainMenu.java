package com.company.view;

import com.company.Main;
import com.company.view.course.AddCourseFrame;
import com.company.view.student.AddStudentFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JMenuBar {
    MainMenu() {
        add(fileMenu());
        add(helpMenu());
    }

    private JMenu listMenu() {
        JMenu lists = new JMenu("Списки");
        JMenuItem students = new JMenuItem("Студенты");
        JMenuItem courses = new JMenuItem("Курсы");

        lists.add(students);
        lists.add(courses);

        students.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.mainFrame.remove(MainFrame.courseListPanel);
                Main.mainFrame.add(MainFrame.studentListPanel);
                Main.mainFrame.pack();
            }
        });

        courses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.mainFrame.remove(MainFrame.studentListPanel);
                Main.mainFrame.add(MainFrame.courseListPanel);
                Main.mainFrame.pack();

            }
        });


        return lists;
    }

    // Создание выпадающего меню
    private JMenu helpMenu() {
        JMenu help = new JMenu("Помощь");
// Пункты меню из команды "Помощь"
        JMenuItem about = new JMenuItem("О программе");
        JMenuItem reference = new JMenuItem("Справка");

        help.add(about);
        help.add(reference);

        return help;
    }

    private JMenu fileMenu() {
        JMenu file = new JMenu("Файл");

        file.add(newMenu());
        file.add(listMenu());

        JMenuItem settings = new JMenuItem("Настройки");

        JMenuItem close = new JMenuItem("Выйти");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        file.add(settings);
        file.addSeparator();
        file.add(close);

        return file;
    }

    private JMenu newMenu() {

        JMenu newItem = new JMenu("Новый");

        JMenuItem newStudent = new JMenuItem("Студент");
        JMenuItem newCourse = new JMenuItem("Курс");
        newItem.add(newStudent);
        newItem.add(newCourse);

        newStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addStudentFrame.setVisible(true);
            }
        });

        newCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addCourseFrame.setVisible(true);
            }
        });
        return newItem;
    }
}