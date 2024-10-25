package schichtplanerbackend.repository;

import com.yourapp.utils.DatabaseConnection;
import schichtplanerbackend.entities.Absence;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AbsenceRepository {

    public void saveAbsence(Absence absence) throws SQLException {
        String query = "INSERT INTO absences (start_date_time, end_date_time, reason, user_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setTimestamp(1, Timestamp.valueOf(absence.getStartDateTime()));
            pstmt.setTimestamp(2, Timestamp.valueOf(absence.getEndDateTime()));
            pstmt.setString(3, absence.getReason());
            pstmt.setInt(4, absence.getUserId());
            pstmt.executeUpdate();
        }
    }

    public List<Absence> findAbsencesByUserId(int userId) throws SQLException {
        List<Absence> absences = new ArrayList<>();
        String query = "SELECT * FROM absences WHERE user_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                absences.add(new Absence(
                        rs.getInt("id"),
                        rs.getTimestamp("start_date_time").toLocalDateTime(),
                        rs.getTimestamp("end_date_time").toLocalDateTime(),
                        rs.getString("reason"),
                        rs.getInt("user_id")
                ));
            }
        }
        return absences;
    }

    public void deleteAbsence(int id) throws SQLException {
        String query = "DELETE FROM absences WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
