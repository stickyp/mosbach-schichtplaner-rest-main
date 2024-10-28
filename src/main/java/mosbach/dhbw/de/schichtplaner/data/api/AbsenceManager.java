package mosbach.dhbw.de.schichtplaner.data.api;

import mosbach.dhbw.de.schichtplaner.data.api.Absence;
import java.util.List;

public interface AbsenceManager {
    List<Absence> getAllAbsences();
    List<Absence>  getAbsencesByUserId(int absenceId);
    void addAbsence(Absence absence);
    void updateAbsence(Absence absence);
    void deleteAbsence(int absenceId);
}
