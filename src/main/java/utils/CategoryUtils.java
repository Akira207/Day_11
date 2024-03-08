package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Category;

public class CategoryUtils {
    public static List<Category> getAllCategories(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Category";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Category> categoryList = new ArrayList<>();
        while (rs.next()) {
            Category category = new Category();
            category.setCategoryId(rs.getInt("CategoryId"));
            category.setCategoryName(rs.getString("CategoryName"));
            categoryList.add(category);
        }
        return categoryList;
    }

    public static Category findCategoryById(Connection conn, int categoryId) throws SQLException {
        String sql = "SELECT * FROM Category WHERE CategoryId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, categoryId);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            Category category = new Category();
            category.setCategoryId(rs.getInt("CategoryId"));
            category.setCategoryName(rs.getString("CategoryName"));
            return category;
        }
        return null;
    }

    public static void addCategory(Connection conn, Category category) throws SQLException {
        String sql = "INSERT INTO Category (CategoryName) VALUES (?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, category.getCategoryName());
        statement.executeUpdate();
    }

    public static void updateCategory(Connection conn, Category category) throws SQLException {
        String sql = "UPDATE Category SET CategoryName = ? WHERE CategoryId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, category.getCategoryName());
        statement.setInt(2, category.getCategoryId());
        statement.executeUpdate();
    }

    public static void deleteCategoryById(Connection conn, int categoryId) throws SQLException {
        String sql = "DELETE FROM Category WHERE CategoryId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, categoryId);
        statement.executeUpdate();
    }
}