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
 * UpdateEventRequest
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "startDateTime",
        "endDateTime",
        "location",
        "description",
        "assignedUserId"
})
public class UpdateEventRequest {

    @JsonProperty("title")
    @JsonPropertyDescription("The updated title of the event")
    @NotNull
    private String title;

    @JsonProperty("startDateTime")
    @JsonPropertyDescription("The updated start time of the event")
    @NotNull
    private Date startDateTime;

    @JsonProperty("endDateTime")
    @JsonPropertyDescription("The updated end time of the event")
    @NotNull
    private Date endDateTime;

    @JsonProperty("location")
    @JsonPropertyDescription("The updated location of the event")
    private String location;

    @JsonProperty("description")
    @JsonPropertyDescription("The updated description of the event")
    private String description;

    @JsonProperty("assignedUserId")
    @JsonPropertyDescription("The ID of the user assigned to this event")
    private Integer assignedUserId;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    // Constructor
    public UpdateEventRequest() {
    }

    public UpdateEventRequest(String title, Date startDateTime, Date endDateTime, String location, String description, Integer assignedUserId) {
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.description = description;
        this.assignedUserId = assignedUserId;
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

    @JsonProperty("assignedUserId")
    public Integer getAssignedUserId() {
        return assignedUserId;
    }

    @JsonProperty("assignedUserId")
    public void setAssignedUserId(Integer assignedUserId) {
        this.assignedUserId = assignedUserId;
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
