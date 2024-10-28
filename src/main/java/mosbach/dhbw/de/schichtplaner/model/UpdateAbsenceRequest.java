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
        "userId",
        "startDateTime",
        "endDateTime",
        "reason"
})
public class UpdateAbsenceRequest {

    @JsonProperty("userId")
    @NotNull
    private Integer userId;

    @JsonProperty("startDateTime")
    @JsonPropertyDescription("The updated start date and time of the user's absence")
    @NotNull
    private Date startDateTime;

    @JsonProperty("endDateTime")
    @JsonPropertyDescription("The updated end date and time of the user's absence")
    @NotNull
    private Date endDateTime;

    @JsonProperty("reason")
    @JsonPropertyDescription("The updated reason for the user's absence")
    @NotNull
    private String reason;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public UpdateAbsenceRequest() {
    }

    public UpdateAbsenceRequest(Integer userId, Date startDateTime, Date endDateTime, String reason) {
        super();
        this.userId = userId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.reason = reason;
    }

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
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

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

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
