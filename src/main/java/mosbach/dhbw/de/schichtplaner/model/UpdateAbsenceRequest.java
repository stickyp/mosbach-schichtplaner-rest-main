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
 * UpdateAbsenceRequest
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "startDateTime",
        "endDateTime",
        "reason"
})

public class UpdateAbsenceRequest {

    /**
     * The updated start date and time of the user's absence
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    @JsonPropertyDescription("The updated start date and time of the user's absence")
    @NotNull
    private Date startDateTime;
    /**
     * The updated end date and time of the user's absence
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    @JsonPropertyDescription("The updated end date and time of the user's absence")
    @NotNull
    private Date endDateTime;
    /**
     * The updated reason for the user's absence
     * (Required)
     *
     */
    @JsonProperty("reason")
    @JsonPropertyDescription("The updated reason for the user's absence")
    @NotNull
    private String reason;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public UpdateAbsenceRequest() {
    }

    /**
     *
     * @param reason
     * The updated reason for the user's absence.
     * @param startDateTime
     * The updated start date and time of the user's absence.
     * @param endDateTime
     * The updated end date and time of the user's absence.
     */
    public UpdateAbsenceRequest(Date startDateTime, Date endDateTime, String reason) {
        super();
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.reason = reason;
    }

    /**
     * The updated start date and time of the user's absence
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    public Date getStartDateTime() {
        return startDateTime;
    }

    /**
     * The updated start date and time of the user's absence
     * (Required)
     *
     */
    @JsonProperty("startDateTime")
    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * The updated end date and time of the user's absence
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    public Date getEndDateTime() {
        return endDateTime;
    }

    /**
     * The updated end date and time of the user's absence
     * (Required)
     *
     */
    @JsonProperty("endDateTime")
    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * The updated reason for the user's absence
     * (Required)
     *
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * The updated reason for the user's absence
     * (Required)
     *
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
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
