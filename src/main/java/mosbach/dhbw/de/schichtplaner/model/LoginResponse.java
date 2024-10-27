package mosbach.dhbw.de.schichtplaner.model;

package mosbach.dhbw.de.schichtplaner.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
 * LoginResponse
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "token",
        "expiresIn",
        "user"
})
@Generated("jsonschema2pojo")
public class LoginResponse {

    /**
     * The JWT token issued to the user
     * (Required)
     *
     */
    @JsonProperty("token")
    @JsonPropertyDescription("The JWT token issued to the user")
    @NotNull
    private String token;
    /**
     * The token expiration time in seconds
     * (Required)
     *
     */
    @JsonProperty("expiresIn")
    @JsonPropertyDescription("The token expiration time in seconds")
    @NotNull
    private Integer expiresIn;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("user")
    @Valid
    @NotNull
    private User user;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public LoginResponse() {
    }

    /**
     *
     * @param expiresIn
     * The token expiration time in seconds.
     * @param token
     * The JWT token issued to the user.
     */
    public LoginResponse(String token, Integer expiresIn, User user) {
        super();
        this.token = token;
        this.expiresIn = expiresIn;
        this.user = user;
    }

    /**
     * The JWT token issued to the user
     * (Required)
     *
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    /**
     * The JWT token issued to the user
     * (Required)
     *
     */
    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * The token expiration time in seconds
     * (Required)
     *
     */
    @JsonProperty("expiresIn")
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * The token expiration time in seconds
     * (Required)
     *
     */
    @JsonProperty("expiresIn")
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
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