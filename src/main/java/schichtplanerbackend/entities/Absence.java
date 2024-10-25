package schichtplanerbackend.entities;

import java.time.LocalDateTime;

public class Absence {
    private int id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String reason;
    private int userId;  // Foreign key to the User entity

    public Absence() {}

    public Absence(int id, LocalDateTime startDateTime, LocalDateTime endDateTime, String reason, int userId) {
        this.id = id;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.reason = reason;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
