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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "startDateTime",
        "endDateTime",
        "location",
        "description"
})
public class GetUserEventsResponse {

    /**
     * The unique identifier of the event
     * (Required)
     *
     */
    @JsonProperty("id")
    @JsonPropertyDescription("The unique identifier of the event")
    @NotNull
    private Integer id;
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
     * The start date and time of the event
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    @JsonPropertyDescription("The start date and time of the event")
    @NotNull
    private Date startDateTime;
    /**
     * The end date and time of the event
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    @JsonPropertyDescription("The end date and time of the event")
    @NotNull
    private Date endDateTime;
    /**
     * The location of the event
     * (Required)
     *
     */
    @JsonProperty("location")
    @JsonPropertyDescription("The location of the event")
    @NotNull
    private String location;
    /**
     * The description of the event
     * (Required)
     *
     */
    @JsonProperty("description")
    @JsonPropertyDescription("The description of the event")
    @NotNull
    private String description;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public GetUserEventsResponse() {
    }

    /**
     *
     * @param startDateTime
     * The start date and time of the event.
     * @param description
     * The description of the event.
     * @param location
     * The location of the event.
     * @param id
     * The unique identifier of the event.
     * @param title
     * The title of the event.
     * @param endDateTime
     * The end date and time of the event.
     */
    public GetUserEventsResponse(Integer id, String title, Date startDateTime, Date endDateTime, String location, String description) {
        super();
        this.id = id;
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.description = description;
    }

    /**
     * The unique identifier of the event
     * (Required)
     *
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * The unique identifier of the event
     * (Required)
     *
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
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
     * The start date and time of the event
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    public Date getStartDateTime() {
        return startDateTime;
    }

    /**
     * The start date and time of the event
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * The end date and time of the event
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    public Date getEndDateTime() {
        return endDateTime;
    }

    /**
     * The end date and time of the event
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * The location of the event
     * (Required)
     *
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * The location of the event
     * (Required)
     *
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * The description of the event
     * (Required)
     *
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * The description of the event
     * (Required)
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