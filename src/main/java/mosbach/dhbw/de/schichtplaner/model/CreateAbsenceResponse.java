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
 * CreateAbsenceResponse
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "absenceId"
})
public class CreateAbsenceResponse {

    /**
     * Confirmation message for the created absence
     * (Required)
     *
     */
    @JsonProperty("message")
    @JsonPropertyDescription("Confirmation message for the created absence")
    @NotNull
    private String message;
    /**
     * The unique identifier of the newly created absence
     * (Required)
     *
     */
    @JsonProperty("absenceId")
    @JsonPropertyDescription("The unique identifier of the newly created absence")
    @NotNull
    private Integer absenceId;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public CreateAbsenceResponse() {
    }

    /**
     *
     * @param absenceId
     * The unique identifier of the newly created absence.
     * @param message
     * Confirmation message for the created absence.
     */
    public CreateAbsenceResponse(String message, Integer absenceId) {
        super();
        this.message = message;
        this.absenceId = absenceId;
    }

    /**
     * Confirmation message for the created absence
     * (Required)
     *
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Confirmation message for the created absence
     * (Required)
     *
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * The unique identifier of the newly created absence
     * (Required)
     *
     */
    @JsonProperty("absenceId")
    public Integer getAbsenceId() {
        return absenceId;
    }

    /**
     * The unique identifier of the newly created absence
     * (Required)
     *
     */
    @JsonProperty("absenceId")
    public void setAbsenceId(Integer absenceId) {
        this.absenceId = absenceId;
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