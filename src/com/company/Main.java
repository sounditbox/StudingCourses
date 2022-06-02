package com.company;


import com.company.model.Enrollment;
import com.company.repository.CourseRepository;
import com.company.repository.EnrollmentRepository;
import com.company.repository.StudentRepository;
import com.company.view.MainFrame;


public class Main {
    public static MainFrame mainFrame = new MainFrame();
    public static void main(String[] args) {
        StudentRepository.getAll();
        CourseRepository.getAll();
        EnrollmentRepository.getAll();
        for (Enrollment e : Enrollment.allEnrollments){
            e.getEnrollment();
        }

    }
}