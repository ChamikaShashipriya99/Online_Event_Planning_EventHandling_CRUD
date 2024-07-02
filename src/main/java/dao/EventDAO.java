package dao;

import model.Event;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public void addEvent(Event event) throws SQLException {
        // Ensure the column names match your database schema
        String sql = "INSERT INTO events (event_name, event_date, event_time, venue, ticket_price, event_type) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event.getEventName());
            pstmt.setDate(2, event.getEventDate());
            pstmt.setTime(3, event.getEventTime());
            pstmt.setString(4, event.getVenue());
            pstmt.setDouble(5, event.getTicketPrice());
            pstmt.setString(6, event.getEventType());
            pstmt.executeUpdate(); // Execute the insert statement
        }
    }

    public List<Event> getAllEvents() throws SQLException {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Event event = new Event();
                event.setId(rs.getInt("id"));
                event.setEventName(rs.getString("event_name")); // Ensure this matches the DB
                event.setEventDate(rs.getDate("event_date"));   // Ensure this matches the DB
                event.setEventTime(rs.getTime("event_time"));    // Ensure this matches the DB
                event.setVenue(rs.getString("venue"));            // Ensure this matches the DB
                event.setTicketPrice(rs.getDouble("ticket_price")); // Ensure this matches the DB
                event.setEventType(rs.getString("event_type"));   // Ensure this matches the DB
                events.add(event);
            }
        }
        return events;
    }

    public Event getEventById(int id) throws SQLException {
        String sql = "SELECT * FROM events WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Event event = new Event();
                    event.setId(rs.getInt("id"));
                    event.setEventName(rs.getString("event_name")); // Ensure this matches the DB
                    event.setEventDate(rs.getDate("event_date"));   // Ensure this matches the DB
                    event.setEventTime(rs.getTime("event_time"));    // Ensure this matches the DB
                    event.setVenue(rs.getString("venue"));            // Ensure this matches the DB
                    event.setTicketPrice(rs.getDouble("ticket_price")); // Ensure this matches the DB
                    event.setEventType(rs.getString("event_type"));   // Ensure this matches the DB
                    return event;
                }
            }
        }
        return null;
    }

    public void updateEvent(Event event) throws SQLException {
        String sql = "UPDATE events SET event_name=?, event_date=?, event_time=?, venue=?, ticket_price=?, event_type=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event.getEventName());
            pstmt.setDate(2, event.getEventDate());
            pstmt.setTime(3, event.getEventTime());
            pstmt.setString(4, event.getVenue());
            pstmt.setDouble(5, event.getTicketPrice());
            pstmt.setString(6, event.getEventType());
            pstmt.setInt(7, event.getId());  // Important: update the correct event using the ID
            pstmt.executeUpdate();
        }
    }

    public void deleteEvent(int id) throws SQLException {
        String sql = "DELETE FROM events WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
