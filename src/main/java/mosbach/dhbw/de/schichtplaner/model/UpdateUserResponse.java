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
 * UpdateUserResponse
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message"
})
public class UpdateUserResponse {

    /**
     * The result message of user update
     * (Required)
     *
     */
    @JsonProperty("message")
    @JsonPropertyDescription("The result message of user update")
    @NotNull
    private String message;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public UpdateUserResponse() {
    }

    /**
     *
     * @param message
     * The result message of user update.
     */
    public UpdateUserResponse(String message) {
        super();
        this.message = message;
    }

    /**
     * The result message of user update
     * (Required)
     *
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * The result message of user update
     * (Required)
     *
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
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