package com.company.model;


import com.company.repository.StudentRepository;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Student {
    private int id;
    String name;
    String surname;

    private static int lastId = 1;
    public static DefaultTableModel model = new DefaultTableModel();
    public static ArrayList<Student> allStudents = new ArrayList<>();

    public Student(String name, String surname) {
        setProperties(++lastId, name, surname);
        StudentRepository.add(id, name, surname);
    }

    public Student(int id, String name, String surname) {
        lastId = id;
        setProperties(id, name, surname);
    }


    private void setProperties(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        model.addRow(new Object[]{id, name, surname});
        allStudents.add(this);
    }

    public String getInfo() {
        return this.id + " " + this.name + " " + this.surname;
    }

    public static void delete(int id, int rowIndex) {
        model.removeRow(rowIndex);
        StudentRepository.delete(id);
        allStudents.remove(rowIndex);
    }

    public static Student getStudentById(int id) {
        for (Student student : allStudents) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }


    public static void update(int id, String name, String surname) {

        StudentRepository.update(id, name, surname);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public ArrayList<Course> getCourses() {
        return Enrollment.getCoursesByStudent(this);
    }


    public ArrayList<Integer> getMarks(Course course) {
        return AcademicPerformance.getMarksByStudentAndCourse(this, course);
    }

}