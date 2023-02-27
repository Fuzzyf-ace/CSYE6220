package com.daiming.part5;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao extends Dao{
    public void addBook(HttpServletRequest request) {
        Connection connection = null;
        String[] isbn = request.getParameterValues("isbn");
        String[] bookTitle = request.getParameterValues("bookTitle");
        String[] authors = request.getParameterValues("authors");
        String[] price = request.getParameterValues("price");
//        List<Book> bookList = new ArrayList<>();
//        for (int i = 0; i < isbn.length; i++) {
//            Book book = new Book();
//            book.setIsbn(isbn[i]);
//            book.setTitle(bookTitle[i]);
//            book.setAuthors(authors[i]);
//            book.setPrice(Float.parseFloat(price[i]));
//            bookList.add(book);
//        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            for (int i = 0; i < isbn.length; i++) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO books (isbn, title, authors, price) VALUES (?, ?, ?, ?)");
                statement.setString(1, isbn[i]);
                statement.setString(2, bookTitle[i]);
                statement.setString(3, authors[i]);
                statement.setFloat(4, Float.parseFloat(price[i]));
                statement.executeUpdate();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


