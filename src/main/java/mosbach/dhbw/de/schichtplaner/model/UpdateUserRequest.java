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
 * UpdateUserRequest
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "password"
})
public class UpdateUserRequest {

    /**
     * The updated name of the user
     * (Required)
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("The updated name of the user")
    @NotNull
    private String name;
    /**
     * The updated password of the user
     * (Required)
     *
     */
    @JsonProperty("password")
    @JsonPropertyDescription("The updated password of the user")
    @NotNull
    private String password;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public UpdateUserRequest() {
    }

    /**
     *
     * @param password
     * The updated password of the user.
     * @param name
     * The updated name of the user.
     */
    public UpdateUserRequest(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    /**
     * The updated name of the user
     * (Required)
     *
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The updated name of the user
     * (Required)
     *
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The updated password of the user
     * (Required)
     *
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * The updated password of the user
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