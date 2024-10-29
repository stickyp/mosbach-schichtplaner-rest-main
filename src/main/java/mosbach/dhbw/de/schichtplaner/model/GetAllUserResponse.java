package mosbach.dhbw.de.schichtplaner.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
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
import mosbach.dhbw.de.schichtplaner.data.api.Absence;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "lastLogin",
        "absence"
})
public class GetAllUserResponse {

    @JsonProperty("id")
    @JsonPropertyDescription("The unique ID of the user")
    @NotNull
    private Integer id;

    @JsonProperty("name")
    @JsonPropertyDescription("The name of the user")
    @NotNull
    private String name;

    @JsonProperty("lastLogin")
    @JsonPropertyDescription("The last login time of the user")
    private Date lastLogin;

    @JsonProperty("absence")
    @Valid
    private List<Absence> absence;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    public GetAllUserResponse() {
    }

    public GetAllUserResponse(Integer id, String name, Date lastLogin, List<Absence> absence) {
        this.id = id;
        this.name = name;
        this.lastLogin = lastLogin;
        this.absence = absence;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("lastLogin")
    public Date getLastLogin() {
        return lastLogin;
    }

    @JsonProperty("lastLogin")
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @JsonProperty("absence")
    public List<Absence> getAbsence() {
        return absence;
    }

    @JsonProperty("absence")
    public void setAbsence(List<Absence> absence) {
        this.absence = absence;
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
