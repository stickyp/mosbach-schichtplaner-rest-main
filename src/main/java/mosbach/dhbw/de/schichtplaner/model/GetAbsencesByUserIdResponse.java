package mosbach.dhbw.de.schichtplaner.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "absences"
})
public class GetAbsencesByUserIdResponse {

    @JsonProperty("absences")
    @Valid
    private List<Absence> absences;

    public GetAbsencesByUserIdResponse() {}

    public GetAbsencesByUserIdResponse(List<Absence> absences) {
        this.absences = absences;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }
}
