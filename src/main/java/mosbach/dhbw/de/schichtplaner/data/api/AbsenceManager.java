package mosbach.dhbw.de.schichtplaner.data.api;

import java.util.List;

public interface AbsenceManager {

    /**
     * Generates a unique ID for a new absence.
     * @return int - a unique absence ID.
     */
    int generateID();

    /**
     * Gets all absences.
     * @return List<Absence> - a list of all absences.
     */
    List<Absence> getAllAbsences();

    /**
     * Gets absences by user ID.
     * @param userId - the ID of the user.
     * @return List<Absence> - a list of absences for the specified user.
     */
    List<Absence> getAbsencesByUserId(int userId);

    /**
     * Adds a new absence.
     * @param absence - the absence to be added.
     */
    void addAbsence(Absence absence);

    /**
     * Updates an existing absence.
     * @param absence - the absence with updated information.
     */
    void updateAbsence(Absence absence);

    /**
     * Deletes an existing absence.
     * @param absenceId - the ID of the absence to be deleted.
     */
    void deleteAbsence(int absenceId);
}
