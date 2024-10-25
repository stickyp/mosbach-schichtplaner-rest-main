package schichtplanerbackend.controller;

import org.springframework.web.bind.annotation.*;
import schichtplanerbackend.entities.Absence;
import schichtplanerbackend.repository.AbsenceRepository;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {
    private final AbsenceRepository absenceRepository = new AbsenceRepository();

    @PostMapping
    public void addAbsence(@RequestBody Absence absence) throws SQLException {
        absenceRepository.saveAbsence(absence);
    }

    @GetMapping("/user/{userId}")
    public List<Absence> getUserAbsences(@PathVariable int userId) throws SQLException {
        return absenceRepository.findAbsencesByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteAbsence(@PathVariable int id) throws SQLException {
        absenceRepository.deleteAbsence(id);
    }
}
