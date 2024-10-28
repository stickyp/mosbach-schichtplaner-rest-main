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
        "user",
        "location",
        "description"
})
public class GetAllEventResponse {

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

    @JsonProperty("user")
    @Valid
    @NotNull
    private User user;

    @JsonProperty("location")
    @Valid
    @NotNull
    private Location location;

    @JsonProperty("description")
    @JsonPropertyDescription("The description of the event")
    @NotNull
    private String description;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public GetAllEventResponse() {
    }

    public GetAllEventResponse(Integer id, String title, Date startDateTime, Date endDateTime, User user, Location location, String description) {
        super();
        this.id = id;
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.user = user;
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

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
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
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    // Inner class for AssignedUser
    public static class AssignedUser extends User {

        @JsonProperty("id")
        @JsonPropertyDescription("The unique identifier of the assigned user")
        private Integer id;

        @JsonProperty("name")
        @JsonPropertyDescription("The name of the assigned user")
        private String name;

        public AssignedUser() {
        }

        public AssignedUser(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }
    }

    // Inner class for Location
    public static class Location {

        @JsonProperty("address")
        @JsonPropertyDescription("The address of the event location")
        private String address;

        @JsonProperty("latitude")
        @JsonPropertyDescription("The latitude of the event location")
        private Double latitude;

        @JsonProperty("longitude")
        @JsonPropertyDescription("The longitude of the event location")
        private Double longitude;

        public Location() {
        }

        public Location(String address, Double latitude, Double longitude) {
            this.address = address;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @JsonProperty("address")
        public String getAddress() {
            return address;
        }

        @JsonProperty("address")
        public void setAddress(String address) {
            this.address = address;
        }

        @JsonProperty("latitude")
        public Double getLatitude() {
            return latitude;
        }

        @JsonProperty("latitude")
        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        @JsonProperty("longitude")
        public Double getLongitude() {
            return longitude;
        }

        @JsonProperty("longitude")
        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }
    }
}
