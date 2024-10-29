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
        "userId",
        "location",
        "description"
})
public class Event {

    @JsonProperty("id")
    @JsonPropertyDescription("The unique identifier of the event")
    @NotNull
    private Integer id;

    @JsonProperty("title")
    @JsonPropertyDescription("The title of the event")
    @NotNull
    private String title;

    @JsonProperty("startDateTime")
    @JsonPropertyDescription("The start date and time of the event")
    @NotNull
    private Date startDateTime;

    @JsonProperty("endDateTime")
    @JsonPropertyDescription("The end date and time of the event")
    @NotNull
    private Date endDateTime;

    @JsonProperty("userId")
    @JsonPropertyDescription("The unique identifier of the user associated with the event")
    @NotNull
    private Integer userId;

    @JsonProperty("location")
    @Valid
    @NotNull
    private GetAllEventResponse.Location location;

    @JsonProperty("description")
    @JsonPropertyDescription("The description of the event")
    private String description;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public Event() {
    }

    public Event(Integer id, String title, Date startDateTime, Date endDateTime, Integer userId, GetAllEventResponse.Location location, String description) {
        this.id = id;
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.userId = userId;
        this.location = location;
        this.description = description;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

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

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("location")
    public GetAllEventResponse.Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(GetAllEventResponse.Location location) {
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
