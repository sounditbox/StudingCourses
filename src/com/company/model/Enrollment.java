package com.company.model;

import com.company.repository.CourseRepository;
import com.company.repository.EnrollmentRepository;

import java.util.ArrayList;

public class Enrollment {
    private int id;
    Student student;
    Course course;

    private static int lastId = 0;
    public static ArrayList<Enrollment> allEnrollments = new ArrayList<>();
    public int getId() {
        return id;
    }
    public Enrollment(Student student, Course course){

        setProperties(++lastId, student.getId(), course.getId());
        EnrollmentRepository.add(id, student, course);
    }

    public Enrollment(int id, int studentId, int courseId){
        lastId = id;
        setProperties(id, studentId, courseId);
    }

    void setProperties(int id, int studentId, int courseId){
        allEnrollments.add(this);
        this.id = id;
        this.student = Student.getStudentById(studentId);
        this.course  = Course.getCourseById(courseId);
    }

    public static ArrayList<Course> getCoursesByStudent(Student st){
        ArrayList<Course> courses = new ArrayList<>();
        for (Enrollment ce : allEnrollments){
            if (ce.student.getId() == st.getId()){
                courses.add(ce.course);
            }
        }
        return courses;
    }

    public static void delete(Student student, Course course){
        Enrollment ce = Enrollment.getEnrollment(student, course);
        allEnrollments.remove(ce);
        EnrollmentRepository.delete(ce.id);
    }

    static ArrayList<Student> getStudentsByCourse(Course c){
        ArrayList<Student> students = new ArrayList<>();
        for (Enrollment ce: allEnrollments){
            if (ce.course.getId() == c.getId()){
                students.add(ce.student);
            }
        }
        return students;
    }

    public static Enrollment getEnrollment(Student st, Course c){
        for (Enrollment ce: allEnrollments){
            if (ce.course.getId() == c.getId() && ce.student.getId() == st.getId()){
                return ce;
            }
        }
        return new Enrollment(st, c);
    }

    public void getEnrollment() {
        System.out.println(student.getName() + " " + course.getTitle());
    }
}