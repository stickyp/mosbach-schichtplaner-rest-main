package mosbach.dhbw.de.schichtplaner.controller;

import mosbach.dhbw.de.schichtplaner.data.api.UserManager;
import mosbach.dhbw.de.schichtplaner.data.api.EventManager;
import mosbach.dhbw.de.schichtplaner.data.api.AbsenceManager;
import mosbach.dhbw.de.schichtplaner.model.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class MappingController {

    private final UserManager userManager;
    private final EventManager eventManager;
    private final AbsenceManager absenceManager;

    public MappingController(UserManager userManager, EventManager eventManager, AbsenceManager absenceManager) {
        this.userManager = userManager;
        this.eventManager = eventManager;
        this.absenceManager = absenceManager;
    }

    @GetMapping("/auth")
    public String getAuthServerAlive() {
        return "The Schichtplaner Server is alive.";
    }

    // USER ENDPOINTS
    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        User user = new User(request.getName(), request.getPassword(), request.getRole(), null);
        userManager.createUser(user);
        return new CreateUserResponse("User created successfully", user.getId());
    }

    @PutMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UpdateUserResponse updateUser(@PathVariable int id, @RequestBody UpdateUserRequest request) {
        User user = userManager.getUserById(id);
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        userManager.updateUser(user);
        return new UpdateUserResponse("User updated successfully");
    }

    @DeleteMapping("/users/{id}")
    public DeleteUserRequest deleteUser(@PathVariable int id) {
        userManager.deleteUser(id);
        return new DeleteUserRequest("User deleted successfully");
    }

    @GetMapping("/users")
    public List<GetAllUserResponse> getAllUsers() {
        return userManager.getAllUsers().stream()
                .map(user -> new GetAllUserResponse(user.getId(), user.getName(), user.getLastLogin(), user.getAbsences()))
                .toList();
    }

    // EVENT ENDPOINTS
    @PostMapping(path = "/events", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateEventResponse createEvent(@RequestBody CreateEventRequest request) {
        Event event = new Event(request.getTitle(), request.getStartDateTime(), request.getEndDateTime(),
                request.getLocation(), request.getDescription(), request.getAssignedUserId());
        eventManager.addEvent(event);
        return new CreateEventResponse("Event created successfully", event.getId());
    }

    @PutMapping(path = "/events/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UpdateEventResponse updateEvent(@PathVariable int id, @RequestBody UpdateEventRequest request) {
        Event event = eventManager.getEventById(id);
        event.setTitle(request.getTitle());
        event.setStartDateTime(request.getStartDateTime());
        event.setEndDateTime(request.getEndDateTime());
        event.setLocation(request.getLocation());
        event.setDescription(request.getDescription());
        eventManager.updateEvent(event);
        return new UpdateEventResponse("Event updated successfully");
    }

    @DeleteMapping("/events/{id}")
    public DeleteEventResponse deleteEvent(@PathVariable int id) {
        eventManager.deleteEvent(id);
        return new DeleteEventResponse("Event deleted successfully");
    }

    @GetMapping("/events")
    public List<GetAllEventResponse> getAllEvents() {
        return eventManager.getAllEvents().stream()
                .map(event -> new GetAllEventResponse(event.getId(), event.getTitle(), event.getStartDateTime(),
                        event.getEndDateTime(), event.getAssignedUser(), event.getLocation(), event.getDescription()))
                .toList();
    }

    // ABSENCE ENDPOINTS
    @PostMapping(path = "/absences", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateAbsenceResponse createAbsence(@RequestBody CreateAbsenceRequest request) {
        Absence absence = new Absence(request.getUserId(), request.getStartDateTime(), request.getEndDateTime(), request.getReason());
        absenceManager.addAbsence(absence);
        return new CreateAbsenceResponse("Absence created successfully", absence.getId());
    }

    @PutMapping(path = "/absences/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UpdateAbsenceResponse updateAbsence(@PathVariable int id, @RequestBody UpdateAbsenceRequest request) {
        Absence absence = absenceManager.getAbsencesByUserId(id).stream().findFirst().orElse(null);
        if (absence != null) {
            absence.setStartDateTime(request.getStartDateTime());
            absence.setEndDateTime(request.getEndDateTime());
            absence.setReason(request.getReason());
            absenceManager.updateAbsence(absence);
            return new UpdateAbsenceResponse("Absence updated successfully");
        }
        return new UpdateAbsenceResponse("Absence not found");
    }

    @DeleteMapping("/absences/{id}")
    public DeleteAbsenceResponse deleteAbsence(@PathVariable int id) {
        absenceManager.deleteAbsence(id);
        return new DeleteAbsenceResponse("Absence deleted successfully");
    }

    // LOGIN ENDPOINT
    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse loginUser(@RequestBody LoginRequest request) {
        // Assuming we have a method to authenticate and generate a JWT token
        // This would be more complex in a real-world scenario.
        User user = userManager.getUserByNameAndPassword(request.getName(), request.getPassword());
        String token = "JWT-TOKEN-HERE"; // Generate JWT based on the authenticated user.
        return new LoginResponse(token, 3600, user);
    }
}
