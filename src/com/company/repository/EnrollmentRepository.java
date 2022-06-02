package com.company.repository;

import com.company.model.Course;
import com.company.model.Enrollment;
import com.company.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class EnrollmentRepository {

    // CRUD - Create, Read, Update, Delete
    private static String url = "jdbc:postgresql://localhost:5432/lms1.7.21";
    private static String user = "postgres"; // TODO: введите свои логин и пароль
    private static String password = "123";

    // CRUD - Create, Read, Update, Delete

    // read
    public static void getAll() {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("select * from enrollments order by id");

            while (results.next()) {
                new Enrollment(
                        Integer.parseInt(results.getString("id")),
                        Integer.parseInt(results.getString("studentId")),
                        Integer.parseInt(results.getString("courseId")));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Не удалось подключиться к БД");
            System.out.println(e.getMessage());
        }
    }


    // Create
    public static void add(int id, Student student, Course course) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            PreparedStatement statement =
                    conn.prepareStatement("insert into enrollments " +
                            "(id, studentId, courseId) values (?, ?, ?)");
            statement.setInt(1, id);
            statement.setInt(2, student.getId());
            statement.setInt(3, course.getId());

            statement.executeUpdate();
            System.out.println("Выполнено:");
            System.out.println(statement);
            conn.close();
        } catch (Exception e) {
            System.out.println("Не удалось добавить студента");
            System.out.println(e.getMessage());
        }
    }
//
//    // update
//    public static void update(int id, String name, String surname) {
//        try {
//            // создаём соединение
//            Connection conn = DriverManager.getConnection(url, user, password);
//
//            // запустим соединение
//            PreparedStatement statement =
//                    conn.prepareStatement("update students " +
//                            "set name=?, surname=?" +
//                            "where id=?");
//            statement.setString(1, name);
//            statement.setString(2, surname);
//            statement.setInt(3, id);
//
//
//            statement.executeUpdate();
//            conn.close();
//        } catch (Exception e) {
//            System.out.println("Не удалось изменить студента");
//            System.out.println(e.getMessage());
//        }
//    }


    // delete

    public static void delete(int id) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);
            // выполним запрос
            String sql = "DELETE FROM enrollments where (id= " + id + ")";
            conn.createStatement().executeQuery(sql);
            conn.close();

            System.out.println("Выполнено:");
            System.out.println(sql);
        } catch (Exception e) {
            System.out.println("Не удалось удалить студента");
            System.out.println(e.getMessage());
        }
    }
}

