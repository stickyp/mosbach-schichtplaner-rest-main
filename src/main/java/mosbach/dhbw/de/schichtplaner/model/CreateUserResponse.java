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
 * CreateUserResponse
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "userId"
})
public class CreateUserResponse {

    /**
     * The status message indicating user creation success
     * (Required)
     *
     */
    @JsonProperty("message")
    @JsonPropertyDescription("The status message indicating user creation success")
    @NotNull
    private String message;
    /**
     * The unique ID of the newly created user
     * (Required)
     *
     */
    @JsonProperty("userId")
    @JsonPropertyDescription("The unique ID of the newly created user")
    @NotNull
    private Integer userId;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public CreateUserResponse() {
    }

    /**
     *
     * @param message
     * The status message indicating user creation success.
     * @param userId
     * The unique ID of the newly created user.
     */
    public CreateUserResponse(String message, Integer userId) {
        super();
        this.message = message;
        this.userId = userId;
    }

    /**
     * The status message indicating user creation success
     * (Required)
     *
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * The status message indicating user creation success
     * (Required)
     *
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * The unique ID of the newly created user
     * (Required)
     *
     */
    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    /**
     * The unique ID of the newly created user
     * (Required)
     *
     */
    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
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