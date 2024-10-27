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


/**
 * LoginRequest
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "password"
})
public class LoginRequest {

    /**
     * The username of the user
     * (Required)
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("The username of the user")
    private String name;
    /**
     * The password for the user
     * (Required)
     *
     */
    @JsonProperty("password")
    @JsonPropertyDescription("The password for the user")
    private String password;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public LoginRequest() {
    }

    /**
     *
     * @param password
     * The password for the user.
     * @param name
     * The username of the user.
     */
    public LoginRequest(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    /**
     * The username of the user
     * (Required)
     *
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The username of the user
     * (Required)
     *
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The password for the user
     * (Required)
     *
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * The password for the user
     * (Required)
     *
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
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