package schichtplanerbackend.repository;



import schichtplanerbackend.entities.Event;
import schichtplanerbackend.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventRepository {

    public void saveEvent(Event event) throws SQLException {
        String query = "INSERT INTO events (title, start_date_time, end_date_time, location, description, assigned_user_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, event.getTitle());
            pstmt.setTimestamp(2, Timestamp.valueOf(event.getStartDateTime()));
            pstmt.setTimestamp(3, Timestamp.valueOf(event.getEndDateTime()));
            pstmt.setString(4, event.getLocation());
            pstmt.setString(5, event.getDescription());
            pstmt.setInt(6, event.getAssignedUserId());
            pstmt.executeUpdate();
        }
    }

    public List<Event> findAllEvents() throws SQLException {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM events";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                events.add(new Event(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getTimestamp("start_date_time").toLocalDateTime(),
                        rs.getTimestamp("end_date_time").toLocalDateTime(),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getInt("assigned_user_id")
                ));
            }
        }
        return events;
    }

    public void deleteEvent(int id) throws SQLException {
        String query = "DELETE FROM events WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public Event findEventById(int id) throws SQLException {
        String query = "SELECT * FROM events WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Event(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getTimestamp("start_date_time").toLocalDateTime(),
                        rs.getTimestamp("end_date_time").toLocalDateTime(),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getInt("assigned_user_id")
                );
            }
        }
        return null;
    }
}
