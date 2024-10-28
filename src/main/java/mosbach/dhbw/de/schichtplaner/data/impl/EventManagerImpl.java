package mosbach.dhbw.de.schichtplaner.data.impl;

import mosbach.dhbw.de.schichtplaner.data.api.Event;
import mosbach.dhbw.de.schichtplaner.data.api.EventManager;
import mosbach.dhbw.de.schichtplaner.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventManagerImpl implements EventManager {

    // Singleton instance
    private static EventManagerImpl instance;

    // Private constructor to prevent direct instantiation
    private EventManagerImpl() {}

    // Public method to provide the singleton instance
    public static EventManagerImpl getInstance() {
        if (instance == null) {
            synchronized (EventManagerImpl.class) {
                if (instance == null) {
                    instance = new EventManagerImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        final Logger logger = Logger.getLogger("ReadEventLogger");
        logger.log(Level.INFO, "Fetching all events");

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM group19events")) {

            while (rs.next()) {
                events.add(new EventImpl(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getTimestamp("start_time"),
                        rs.getTimestamp("end_time"),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getInt("assigned_user_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public Event getEventById(int eventId) {
        final Logger getEventLogger = Logger.getLogger("GetEventLogger");
        getEventLogger.log(Level.INFO, "Fetching event with ID: " + eventId);

        String selectSQL = "SELECT e.id, e.title, e.start_time, e.end_time, e.location, e.description, "
                + "u.id AS user_id, u.name AS user_name, u.role AS user_role, u.jwt_token "
                + "FROM group19events e "
                + "LEFT JOIN group19users u ON e.assigned_user_id = u.id "
                + "WHERE e.id = ?";

        Event event = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(selectSQL)) {

            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                event = new EventImpl(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getTimestamp("start_time"),
                        rs.getTimestamp("end_time"),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getInt("user_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return event;
    }

    @Override
    public void addEvent(Event event) {
        final Logger createEventLogger = Logger.getLogger("CreateEventLogger");
        createEventLogger.log(Level.INFO, "Start creating event: " + event.getTitle());

        String insertSQL = "INSERT INTO group19events (title, start_time, end_time, location, description, assigned_user_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(insertSQL)) {

            stmt.setString(1, event.getTitle());
            stmt.setTimestamp(2, new Timestamp(event.getStartTime().getTime()));
            stmt.setTimestamp(3, new Timestamp(event.getEndTime().getTime()));
            stmt.setString(4, event.getLocation());
            stmt.setString(5, event.getDescription());
            stmt.setInt(6, event.getAssignedUserId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEvent(Event event) {
        final Logger updateEventLogger = Logger.getLogger("UpdateEventLogger");
        updateEventLogger.log(Level.INFO, "Start updating event ID: " + event.getId());

        String updateSQL = "UPDATE group19events SET title = ?, start_time = ?, end_time = ?, location = ?, description = ?, assigned_user_id = ? " +
                "WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(updateSQL)) {

            stmt.setString(1, event.getTitle());
            stmt.setTimestamp(2, new Timestamp(event.getStartTime().getTime()));
            stmt.setTimestamp(3, new Timestamp(event.getEndTime().getTime()));
            stmt.setString(4, event.getLocation());
            stmt.setString(5, event.getDescription());
            stmt.setInt(6, event.getAssignedUserId());
            stmt.setInt(7, event.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEvent(int eventId) {
        final Logger deleteEventLogger = Logger.getLogger("DeleteEventLogger");
        deleteEventLogger.log(Level.INFO, "Start deleting event ID: " + eventId);

        String deleteSQL = "DELETE FROM group19events WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(deleteSQL)) {

            stmt.setInt(1, eventId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
