package mosbach.dhbw.de.schichtplaner.data.api;

import java.util.Date;

public interface Event {
    Integer getId();
    String getTitle();
    Date getStartTime();
    Date getEndTime();
    String getLocation();
    String getDescription();
    Integer getAssignedUserId();

    void setId(Integer id);
    void setTitle(String title);
    void setStartTime(Date startTime);
    void setEndTime(Date endTime);
    void setLocation(String location);
    void setDescription(String description);
    void setAssignedUserId(Integer assignedUserId);
}
