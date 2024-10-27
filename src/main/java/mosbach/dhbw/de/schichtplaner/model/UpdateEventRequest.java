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
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "startDateTime",
        "endDateTime",
        "location",
        "description"
})
public class UpdateEventRequest {

    /**
     * The updated title of the event
     * (Required)
     *
     */
    @JsonProperty("title")
    @JsonPropertyDescription("The updated title of the event")
    @NotNull
    private String title;
    /**
     * The updated start time of the event
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    @JsonPropertyDescription("The updated start time of the event")
    @NotNull
    private Date startDateTime;
    /**
     * The updated end time of the event
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    @JsonPropertyDescription("The updated end time of the event")
    @NotNull
    private Date endDateTime;
    /**
     * The updated location of the event
     *
     */
    @JsonProperty("location")
    @JsonPropertyDescription("The updated location of the event")
    private String location;
    /**
     * The updated description of the event
     *
     */
    @JsonProperty("description")
    @JsonPropertyDescription("The updated description of the event")
    private String description;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public UpdateEventRequest() {
    }

    /**
     *
     * @param startDateTime
     * The updated start time of the event.
     * @param description
     * The updated description of the event.
     * @param location
     * The updated location of the event.
     * @param title
     * The updated title of the event.
     * @param endDateTime
     * The updated end time of the event.
     */
    public UpdateEventRequest(String title, Date startDateTime, Date endDateTime, String location, String description) {
        super();
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.description = description;
    }

    /**
     * The updated title of the event
     * (Required)
     *
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * The updated title of the event
     * (Required)
     *
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * The updated start time of the event
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    public Date getStartDateTime() {
        return startDateTime;
    }

    /**
     * The updated start time of the event
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * The updated end time of the event
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    public Date getEndDateTime() {
        return endDateTime;
    }

    /**
     * The updated end time of the event
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * The updated location of the event
     *
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * The updated location of the event
     *
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * The updated description of the event
     *
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * The updated description of the event
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