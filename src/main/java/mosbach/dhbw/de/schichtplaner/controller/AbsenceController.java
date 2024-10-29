package mosbach.dhbw.de.schichtplaner.controller;

import mosbach.dhbw.de.schichtplaner.data.api.Absence;
import mosbach.dhbw.de.schichtplaner.data.api.AbsenceManager;
import mosbach.dhbw.de.schichtplaner.data.impl.AbsenceImpl;
import mosbach.dhbw.de.schichtplaner.data.impl.AbsenceManagerImpl;
import mosbach.dhbw.de.schichtplaner.model.CreateAbsenceRequest;
import mosbach.dhbw.de.schichtplaner.model.CreateAbsenceResponse;
import mosbach.dhbw.de.schichtplaner.model.UpdateAbsenceRequest;
import mosbach.dhbw.de.schichtplaner.model.UpdateAbsenceResponse;
import mosbach.dhbw.de.schichtplaner.model.DeleteAbsenceResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@CrossOrigin(origins = "https://eventcalender-sleepy-wallaby-ri.apps.01.cf.eu01.stackit.cloud/", allowedHeaders = "*")
@RestController
@RequestMapping("/api/absences")
public class AbsenceController {

    private final AbsenceManager absenceManager = AbsenceManagerImpl.getInstance();
    private static final Logger logger = Logger.getLogger(AbsenceController.class.getName());

    @PostMapping
    public ResponseEntity<CreateAbsenceResponse> createAbsence(@RequestBody CreateAbsenceRequest request) {
        logger.log(Level.INFO, "Creating new absence for user ID: " + request.getUserId());

        Absence newAbsence = new AbsenceImpl(
                AbsenceManagerImpl.getInstance().generateID(),
                request.getUserId(),
                request.getStartDateTime(),
                request.getEndDateTime(),
                request.getReason()
        );

        absenceManager.addAbsence(newAbsence);

        CreateAbsenceResponse response = new CreateAbsenceResponse("Absence created successfully", newAbsence.getId());
        return ResponseEntity.ok(response);
    }

    @PutMapping(path ="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UpdateAbsenceResponse> updateAbsence(@PathVariable int id, @RequestBody UpdateAbsenceRequest request) {
        logger.log(Level.INFO, "Updating absence ID: " + id);

        Absence updatedAbsence = new AbsenceImpl(
                id,
                request.getUserId(),
                request.getStartDateTime(),
                request.getEndDateTime(),
                request.getReason()
        );

        absenceManager.updateAbsence(updatedAbsence);

        UpdateAbsenceResponse response = new UpdateAbsenceResponse("Absence updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteAbsenceResponse> deleteAbsence(@PathVariable int id) {
        logger.log(Level.INFO, "Deleting absence ID: " + id);

        absenceManager.deleteAbsence(id);

        DeleteAbsenceResponse response = new DeleteAbsenceResponse("Absence deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Absence>> getAbsencesByUserId(@PathVariable int userId) {
        logger.log(Level.INFO, "Fetching absences for user ID: " + userId);

        List<Absence> absences = absenceManager.getAbsencesByUserId(userId);
        return ResponseEntity.ok(absences);
    }
}
