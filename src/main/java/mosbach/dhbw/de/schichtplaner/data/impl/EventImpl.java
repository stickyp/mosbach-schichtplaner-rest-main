package mosbach.dhbw.de.schichtplaner.data.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import mosbach.dhbw.de.schichtplaner.data.api.Event;

import java.util.Date;

public class EventImpl implements Event {

    private Integer id;
    private String title;
    private Date startTime;
    private Date endTime;
    private String location;
    private String description;
    private Integer assignedUserId;

    public EventImpl(
            @JsonProperty("id") Integer id,
            @JsonProperty("title") String title,
            @JsonProperty("startTime") Date startTime,
            @JsonProperty("endTime") Date endTime,
            @JsonProperty("location") String location,
            @JsonProperty("description") String description,
            @JsonProperty("assignedUserId") Integer assignedUserId) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.description = description;
        this.assignedUserId = assignedUserId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Integer getAssignedUserId() {
        return assignedUserId;
    }

    @Override
    public void setAssignedUserId(Integer assignedUserId) {
        this.assignedUserId = assignedUserId;
    }
}
