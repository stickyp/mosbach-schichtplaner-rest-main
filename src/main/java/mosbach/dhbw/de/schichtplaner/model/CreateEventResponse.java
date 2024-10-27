package mosbach.dhbw.de.schichtplaner.model;

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
 * CreateEventResponse
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "eventId"
})
public class CreateEventResponse {

    /**
     * The success message
     * (Required)
     *
     */
    @JsonProperty("message")
    @JsonPropertyDescription("The success message")
    @NotNull
    private String message;
    /**
     * The unique ID of the created event
     * (Required)
     *
     */
    @JsonProperty("eventId")
    @JsonPropertyDescription("The unique ID of the created event")
    @NotNull
    private Integer eventId;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public CreateEventResponse() {
    }

    /**
     *
     * @param eventId
     * The unique ID of the created event.
     * @param message
     * The success message.
     */
    public CreateEventResponse(String message, Integer eventId) {
        super();
        this.message = message;
        this.eventId = eventId;
    }

    /**
     * The success message
     * (Required)
     *
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * The success message
     * (Required)
     *
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * The unique ID of the created event
     * (Required)
     *
     */
    @JsonProperty("eventId")
    public Integer getEventId() {
        return eventId;
    }

    /**
     * The unique ID of the created event
     * (Required)
     *
     */
    @JsonProperty("eventId")
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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