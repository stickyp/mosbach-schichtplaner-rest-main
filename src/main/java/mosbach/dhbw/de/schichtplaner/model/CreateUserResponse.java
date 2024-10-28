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
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "userId",
        "role"
})
public class CreateUserResponse {

    @JsonProperty("message")
    @JsonPropertyDescription("The status message indicating user creation success")
    @NotNull
    private String message;

    @JsonProperty("userId")
    @JsonPropertyDescription("The unique ID of the newly created user")
    @NotNull
    private Integer userId;

    @JsonProperty("role")
    @JsonPropertyDescription("The role of the newly created user")
    @NotNull
    private String role;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public CreateUserResponse() {
    }

    public CreateUserResponse(String message, Integer userId, String role) {
        this.message = message;
        this.userId = userId;
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
