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
 * <p>
 *
 *
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

    /**
     * The title of the event
     * (Required)
     *
     */
    @JsonProperty("title")
    @JsonPropertyDescription("The title of the event")
    @NotNull
    private String title;
    /**
     * The start time of the event
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    @JsonPropertyDescription("The start time of the event")
    @NotNull
    private Date startDateTime;
    /**
     * The end time of the event
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    @JsonPropertyDescription("The end time of the event")
    @NotNull
    private Date endDateTime;
    /**
     * The ID of the user assigned to this event
     *
     */
    @JsonProperty("assignedUserId")
    @JsonPropertyDescription("The ID of the user assigned to this event")
    private Integer assignedUserId;
    /**
     * The location of the event
     *
     */
    @JsonProperty("location")
    @JsonPropertyDescription("The location of the event")
    private String location;
    /**
     * The description of the event
     *
     */
    @JsonProperty("description")
    @JsonPropertyDescription("The description of the event")
    private String description;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public CreateEventRequest() {
    }

    /**
     *
     * @param startDateTime
     * The start time of the event.
     * @param description
     * The description of the event.
     * @param location
     * The location of the event.
     * @param title
     * The title of the event.
     * @param endDateTime
     * The end time of the event.
     * @param assignedUserId
     * The ID of the user assigned to this event.
     */
    public CreateEventRequest(String title, Date startDateTime, Date endDateTime, Integer assignedUserId, String location, String description) {
        super();
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.assignedUserId = assignedUserId;
        this.location = location;
        this.description = description;
    }

    /**
     * The title of the event
     * (Required)
     *
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * The title of the event
     * (Required)
     *
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * The start time of the event
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    public Date getStartDateTime() {
        return startDateTime;
    }

    /**
     * The start time of the event
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * The end time of the event
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    public Date getEndDateTime() {
        return endDateTime;
    }

    /**
     * The end time of the event
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * The ID of the user assigned to this event
     *
     */
    @JsonProperty("assignedUserId")
    public Integer getAssignedUserId() {
        return assignedUserId;
    }

    /**
     * The ID of the user assigned to this event
     *
     */
    @JsonProperty("assignedUserId")
    public void setAssignedUserId(Integer assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    /**
     * The location of the event
     *
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * The location of the event
     *
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * The description of the event
     *
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * The description of the event
     *
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
