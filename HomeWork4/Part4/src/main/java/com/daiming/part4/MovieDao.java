package com.daiming.part4;


import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class MovieDao extends Dao {

    public void addMovie(HttpServletRequest request) {
        Connection connection = null;
        String title = request.getParameter("movie_title");
        String actress = request.getParameter("lead_actress");
        String actor = request.getParameter("lead_actor");
        String genre = request.getParameter("genre");
        int year = Integer.parseInt(request.getParameter("year"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            System.out.println("connection success");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO movies (title, actor, actress, genre, year) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, title);
            statement.setString(2, actor);
            statement.setString(3, actress);
            statement.setString(4, genre);
            statement.setInt(5, year);
            statement.executeUpdate();
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (!connection.equals(null)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public ResultSet searchMovie(HttpServletRequest request) {
        Connection connection = null;
        String keyword = request.getParameter("keyword");
        String searchBy = request.getParameter("search_by");
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM movies WHERE " + searchBy +" = ? ");
            statement.setString(1, keyword);
            resultSet = statement.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
