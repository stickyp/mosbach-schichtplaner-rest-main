package mosbach.dhbw.de.schichtplaner.data.impl;


import mosbach.dhbw.de.schichtplaner.data.api.Event;

import java.util.Date;

public class EventImpl implements Event {

    private int id;
    private String title;
    private Date startDateTime;
    private Date endDateTime;
    private String location;
    private String description;
    private int assignedUserId;

    // Constructor
    public EventImpl(int id, String title, Date startDateTime, Date endDateTime, String location, String description, int assignedUserId) {
        this.id = id;
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
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
        return startDateTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startDateTime = startTime;
    }

    @Override
    public Date getEndTime() {
        return endDateTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endDateTime = endTime;
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
