package com.company.model;

import java.util.ArrayList;

public class AcademicPerformance {
    private int id;
    private int mark;
    private Enrollment courseEnrollment;

    private static int lastID = 0;
    private static ArrayList<AcademicPerformance> list = new ArrayList<>();

    public AcademicPerformance(Enrollment courseEnrollment, int mark){
        this.id = ++lastID;
        this.courseEnrollment = courseEnrollment;
        setMark(mark);
        list.add(this);
    }
    public AcademicPerformance(Student student, Course course, int mark){
        this(Enrollment.getEnrollment(student, course), mark);
    }

    public void setMark(int mark){
        if (mark < 1) mark = 1;
        if (mark > 100) mark = 100;
        this.mark = mark;
    }

    public static ArrayList<Integer> getMarksByStudentAndCourse(Student student, Course course){
        ArrayList<Integer> marks = new ArrayList<>();
        Enrollment ce = Enrollment.getEnrollment(student, course);
        for (AcademicPerformance ap : list)
            if (ce == ap.courseEnrollment)
                marks.add(ap.mark);

        return marks;
    }

}