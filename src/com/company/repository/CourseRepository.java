package com.company.repository;

import com.company.model.Course;

import java.sql.*;

public class CourseRepository {
    private static String url = "jdbc:postgresql://localhost:5432/lms1.7.21";
    private static String user = "postgres"; // TODO: введите свои логин и пароль
    private static String password = "123";
    public static void getAll(){
        try {
//            создадим соединение
            Connection connection = DriverManager.getConnection(url, user, password);
//            запустим соединение
            Statement statement = connection.createStatement();
            String query = "Select * from courses order by id";
            ResultSet resultSet = statement.executeQuery("Select * from courses order by id");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                new Course(Integer.parseInt(id), title, description);
            }

            System.out.println("Выполнено:");
            System.out.println(query);
            connection.close();
        } catch (Exception e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }

    public static void insertCourse(int id, String title, String description){
        try {
            String query = "insert into courses (id, title, description) values (?, ?, ?)";
//            создадим соединение
            Connection connection = DriverManager.getConnection(url, user, password);
//            запустим соединение
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.executeUpdate();

            System.out.println("Выполнено:");
            System.out.println(query);
            connection.close();
        } catch (Exception e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getMessage());
        }
    }
    // update
    public static void update(int id, String title, String description) {
        try {
            String query = "update courses " +
                    "set title=?, description=?" +
                    "where id=?";
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);
            // запустим соединение
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setInt(3, id);

            System.out.println("Выполнено:");
            System.out.println(query);
            statement.executeUpdate();
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось изменить студента");
            System.out.println(e.getMessage());
        }
    }


    // delete

    public static void delete(int id) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);
            // выполним запрос
            String sql = "DELETE FROM courses where (id= " + id + ")";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();


            System.out.println("Выполнено:");
            System.out.println(sql);
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось удалить студента");
            System.out.println(e.getMessage());
        }
    }

}