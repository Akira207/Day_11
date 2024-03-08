package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Book;

public class BookUtils {
    public static List<Book> getAllBooks(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Book";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Book> bookList = new ArrayList<>();
        while (rs.next()) {
            Book book = new Book();
            book.setBookId(rs.getString("BookId"));
            book.setTitle(rs.getString("Title"));
            book.setAuthor(rs.getString("Author"));
            book.setRelease(rs.getInt("Release"));
            book.setPrice(rs.getDouble("Price"));
            book.setPicture(rs.getString("Picture"));
            book.setPublisherId(rs.getInt("PublisherId"));
            book.setCategoryId(rs.getInt("CategoryId"));
            bookList.add(book);
        }
        return bookList;
    }
    public static Book findBookById(Connection conn, String bookId) throws SQLException {
        String sql = "SELECT * FROM Book WHERE BookId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, bookId);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            Book book = new Book();
            book.setBookId(rs.getString("BookId"));
            book.setTitle(rs.getString("Title"));
            book.setAuthor(rs.getString("Author"));
            book.setRelease(rs.getInt("Release"));
            book.setPrice(rs.getDouble("Price"));
            book.setPicture(rs.getString("Picture"));
            book.setPublisherId(rs.getInt("PublisherId"));
            book.setCategoryId(rs.getInt("CategoryId"));
            return book;
        }
        return null;
    }

    public static void addBook(Connection conn, Book book) throws SQLException {
        String sql = "INSERT INTO Book (BookId, Title, Author, Release, Price, Picture, PublisherId, CategoryId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, book.getBookId());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthor());
        statement.setInt(4, book.getRelease());
        statement.setDouble(5, book.getPrice());
        statement.setString(6, book.getPicture());
        statement.setInt(7, book.getPublisherId());
        statement.setInt(8, book.getCategoryId());
        statement.executeUpdate();
    }
    public static void updateBook(Connection conn, Book book) throws SQLException {
        String sql = "UPDATE Book SET Title = ?, Author = ?, Release = ?, Price = ?, Picture = ?, PublisherId = ?, CategoryId = ? WHERE BookId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setInt(3, book.getRelease());
        statement.setDouble(4, book.getPrice());
        statement.setString(5, book.getPicture());
        statement.setInt(6, book.getPublisherId());
        statement.setInt(7, book.getCategoryId());
        statement.setString(8, book.getBookId());
        statement.executeUpdate();
    }

    public static void deleteBookById(Connection conn, String bookId) throws SQLException {
        String sql = "DELETE FROM Book WHERE BookId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, bookId);
        statement.executeUpdate();
    }
}