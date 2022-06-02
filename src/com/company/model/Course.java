package com.company.model;

import com.company.repository.CourseRepository;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Course {
    private int id;
    String title;
    String description;

    private static int lastId;
    public static ArrayList<Course> allCourses = new ArrayList<>();
    public static DefaultTableModel model = new DefaultTableModel();

    public Course(String title, String description) {
        setProperties(++lastId, title, description);
        CourseRepository.insertCourse(id, title, description);

    }

    public Course(int id, String title, String description) {
        lastId = id;
        setProperties(id, title, description);
    }

    public static Course getCourseById(int courseID) {
        for (Course course : allCourses){
            if (course.getId() == courseID){
                return course;
            }
        }
        return null;
    }

    private void setProperties(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        allCourses.add(this);
        model.addRow(new Object[]{id, title, description});
    }


    public static void delete(int id, int rowIndex) {
        model.removeRow(rowIndex);
        allCourses.remove(rowIndex);
        CourseRepository.delete(id);
    }

    public static void update(int id, String title, String description) {
        CourseRepository.update(id, title, description);
    }


    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getInfo() {
        return this.id + " " + this.title + " " + this.description;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Student> getStudents() {
        return Enrollment.getStudentsByCourse(this);
    }

    public Enrollment addStudent(Student student) {
        return new Enrollment(student, this);
    }

    public void addCourse(Course courseById) {

    }
}