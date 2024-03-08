package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Publisher;

public class PubLisherUtils {
    public static List<Publisher> getAllPublishers(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Publisher";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Publisher> publisherList = new ArrayList<>();
        while (rs.next()) {
            Publisher publisher = new Publisher();
            publisher.setPublisherId(rs.getInt("PublisherId"));
            publisher.setPublisherName(rs.getString("PublisherName"));
            publisher.setPhone(rs.getString("Phone"));
            publisher.setAddress(rs.getString("Address"));
            publisherList.add(publisher);
        }
        return publisherList;
    }

    public static Publisher findPublisherById(Connection conn, int publisherId) throws SQLException {
        String sql = "SELECT * FROM Publisher WHERE PublisherId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, publisherId);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            Publisher publisher = new Publisher();
            publisher.setPublisherId(rs.getInt("PublisherId"));
            publisher.setPublisherName(rs.getString("PublisherName"));
            publisher.setPhone(rs.getString("Phone"));
            publisher.setAddress(rs.getString("Address"));
            return publisher;
        }
        return null;
    }

    public static void addPublisher(Connection conn, Publisher publisher) throws SQLException {
        String sql = "INSERT INTO Publisher (PublisherName, Phone, Address) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, publisher.getPublisherName());
        statement.setString(2, publisher.getPhone());
        statement.setString(3, publisher.getAddress());
        statement.executeUpdate();
    }

    public static void updatePublisher(Connection conn, Publisher publisher) throws SQLException {
        String sql = "UPDATE Publisher SET PublisherName = ?, Phone = ?, Address = ? WHERE PublisherId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, publisher.getPublisherName());
        statement.setString(2, publisher.getPhone());
        statement.setString(3, publisher.getAddress());
        statement.setInt(4, publisher.getPublisherId());
        statement.executeUpdate();
    }

    public static void deletePublisherById(Connection conn, int publisherId) throws SQLException {
        String sql = "DELETE FROM Publisher WHERE PublisherId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, publisherId);
        statement.executeUpdate();
    }
}