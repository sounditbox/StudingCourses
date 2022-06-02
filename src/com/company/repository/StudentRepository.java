package com.company.repository;

import com.company.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentRepository {
    // CRUD - Create, Read, Update, Delete
    private static String url = "jdbc:postgresql://localhost:5432/lms1.7.21";
    private static String user = "postgres"; // TODO: введите свои логин и пароль
    private static String password = "123";

    // CRUD - Create, Read, Update, Delete

    // read
    public static ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String query = "select * from students order by id";
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String id = results.getString("id");
                String name = results.getString("name");
                String surname = results.getString("surname");
                students.add(new Student(Integer.parseInt(id), name, surname));
            }

            System.out.println("Выполнено:");
            System.out.println(query);

            conn.close();
        } catch (Exception e) {
            System.out.println("Не удалось подключиться к БД");
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static Student getStudent(int id) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "select * from students where id=" + id;
            // запустим соединение
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(query);

            conn.close();
            results.next();

            System.out.println("Выполнено:");
            System.out.println(query);
            return new Student(Integer.parseInt(results.getString("id")),
                    results.getString("name"),
                    results.getString("surname"));
        } catch (Exception e) {
            System.out.println("Не удалось подключиться к БД");
            System.out.println(e.getMessage());
        }

        return null;
    }

    // Create
    public static void add(int id, String name, String surname) {
        String query = "insert into students (id, name, surname) values (?, ?, ?)";
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            PreparedStatement statement =
                    conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, surname);
            statement.executeUpdate();

            System.out.println("Выполнено:");
            System.out.println(query);
            conn.close();
        } catch (Exception e) {
            System.out.println("Не удалось добавить студента");
            System.out.println(e.getMessage());
        }
    }

    // update
    public static void update(int id, String name, String surname) {
        String query = "update students set name=?, surname=? where id=?";

        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            PreparedStatement statement =
                    conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt(3, id);


            System.out.println("Выполнено:");
            System.out.println(query);
            statement.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println("Не удалось изменить студента");
            System.out.println(e.getMessage());
        }
    }


    // delete

    public static void delete(int id) {
        String query = "DELETE FROM students where (id= " + id + ")";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = conn.prepareStatement(query);
            statement.executeUpdate();            System.out.println("Выполнено");
            System.out.println(query);
            conn.close();
        } catch (Exception e) {
            System.out.println("Не удалось удалить студента");
            System.out.println(e.getMessage());
        }
    }
}