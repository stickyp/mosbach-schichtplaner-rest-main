package mosbach.dhbw.de.schichtplaner.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * CreateEventRequest
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "startDateTime",
        "endDateTime",
        "assignedUserId",
        "location",
        "description"
})
public class CreateEventRequest {

    @JsonProperty("title")
    @JsonPropertyDescription("The title of the event")
    @NotNull
    private String title;

    @JsonProperty("startDateTime")
    @JsonPropertyDescription("The start time of the event")
    @NotNull
    private Date startDateTime;

    @JsonProperty("endDateTime")
    @JsonPropertyDescription("The end time of the event")
    @NotNull
    private Date endDateTime;

    @JsonProperty("assignedUserId")
    @JsonPropertyDescription("The ID of the user assigned to this event")
    private Integer assignedUserId;

    @JsonProperty("location")
    @JsonPropertyDescription("The location of the event")
    private String location;

    @JsonProperty("description")
    @JsonPropertyDescription("The description of the event")
    private String description;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    // Constructor
    public CreateEventRequest() {
    }

    public CreateEventRequest(String title, Date startDateTime, Date endDateTime, Integer assignedUserId, String location, String description) {
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.assignedUserId = assignedUserId;
        this.location = location;
        this.description = description;
    }

    // Getters and Setters
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("startDateTime")
    public Date getStartDateTime() {
        return startDateTime;
    }

    @JsonProperty("startDateTime")
    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    @JsonProperty("endDateTime")
    public Date getEndDateTime() {
        return endDateTime;
    }

    @JsonProperty("endDateTime")
    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    @JsonProperty("assignedUserId")
    public Integer getAssignedUserId() {
        return assignedUserId;
    }

    @JsonProperty("assignedUserId")
    public void setAssignedUserId(Integer assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
