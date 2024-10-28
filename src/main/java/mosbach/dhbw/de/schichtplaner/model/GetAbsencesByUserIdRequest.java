package mosbach.dhbw.de.schichtplaner.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId"
})
public class GetAbsencesByUserIdRequest {

    @JsonProperty("userId")
    @NotNull
    private Integer userId;

    public GetAbsencesByUserIdRequest() {}

    public GetAbsencesByUserIdRequest(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
