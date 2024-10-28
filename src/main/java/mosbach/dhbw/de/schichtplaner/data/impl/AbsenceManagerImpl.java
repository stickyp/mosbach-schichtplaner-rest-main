package mosbach.dhbw.de.schichtplaner.data.impl;

import mosbach.dhbw.de.schichtplaner.data.api.Absence;
import mosbach.dhbw.de.schichtplaner.data.api.AbsenceManager;
import mosbach.dhbw.de.schichtplaner.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbsenceManagerImpl implements AbsenceManager {

    // Singleton instance
    private static AbsenceManagerImpl instance;

    // Private constructor to prevent direct instantiation
    private AbsenceManagerImpl() {}

    // Public method to provide the singleton instance
    public static AbsenceManagerImpl getInstance() {
        if (instance == null) {
            synchronized (AbsenceManagerImpl.class) {
                if (instance == null) {
                    instance = new AbsenceManagerImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Absence> getAllAbsences() {
        List<Absence> absences = new ArrayList<>();
        final Logger logger = Logger.getLogger("ReadAbsenceLogger");
        logger.log(Level.INFO, "Fetching all absences");

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM group19absences")) {

            while (rs.next()) {
                absences.add(new AbsenceImpl(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("start_time"),
                        rs.getTimestamp("end_time"),
                        rs.getString("reason")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return absences;
    }

    @Override
    public List<Absence> getAbsencesByUserId(int userId) {
        final Logger getAbsencesLogger = Logger.getLogger("GetAbsencesLogger");
        getAbsencesLogger.log(Level.INFO, "Fetching absences for user ID: " + userId);

        List<Absence> absences = new ArrayList<>();
        String selectSQL = "SELECT * FROM group19absences WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(selectSQL)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Absence absence = new AbsenceImpl(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("start_time"),
                        rs.getTimestamp("end_time"),
                        rs.getString("reason")
                );
                absences.add(absence);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return absences;
    }

    @Override
    public void addAbsence(Absence absence) {
        final Logger createAbsenceLogger = Logger.getLogger("CreateAbsenceLogger");
        createAbsenceLogger.log(Level.INFO, "Start creating absence for user ID: " + absence.getUserId());

        String insertSQL = "INSERT INTO group19absences (user_id, start_time, end_time, reason) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(insertSQL)) {

            stmt.setInt(1, absence.getUserId());
            stmt.setTimestamp(2, new Timestamp(absence.getStartTime().getTime()));
            stmt.setTimestamp(3, new Timestamp(absence.getEndTime().getTime()));
            stmt.setString(4, absence.getReason());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAbsence(Absence absence) {
        final Logger updateAbsenceLogger = Logger.getLogger("UpdateAbsenceLogger");
        updateAbsenceLogger.log(Level.INFO, "Start updating absence ID: " + absence.getId());

        String updateSQL = "UPDATE group19absences SET start_time = ?, end_time = ?, reason = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(updateSQL)) {

            stmt.setTimestamp(1, new Timestamp(absence.getStartTime().getTime()));
            stmt.setTimestamp(2, new Timestamp(absence.getEndTime().getTime()));
            stmt.setString(3, absence.getReason());
            stmt.setInt(4, absence.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAbsence(int absenceId) {
        final Logger deleteAbsenceLogger = Logger.getLogger("DeleteAbsenceLogger");
        deleteAbsenceLogger.log(Level.INFO, "Start deleting absence ID: " + absenceId);

        String deleteSQL = "DELETE FROM group19absences WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(deleteSQL)) {

            stmt.setInt(1, absenceId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
