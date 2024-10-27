package mosbach.dhbw.de.schichtplaner.data.api;

import java.util.Date;

public interface Absence {
    Integer getId();
    Integer getUserId();
    Date getStartTime();
    Date getEndTime();
    String getReason();

    void setId(Integer id);
    void setUserId(Integer userId);
    void setStartTime(Date startTime);
    void setEndTime(Date endTime);
    void setReason(String reason);
}

