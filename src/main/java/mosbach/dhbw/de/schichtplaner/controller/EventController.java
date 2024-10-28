package mosbach.dhbw.de.schichtplaner.controller;

import mosbach.dhbw.de.schichtplaner.data.api.Event;
import mosbach.dhbw.de.schichtplaner.data.api.EventManager;
import mosbach.dhbw.de.schichtplaner.data.api.User;
import mosbach.dhbw.de.schichtplaner.data.api.UserManager;
import mosbach.dhbw.de.schichtplaner.data.impl.EventImpl;
import mosbach.dhbw.de.schichtplaner.data.impl.EventManagerImpl;
import mosbach.dhbw.de.schichtplaner.data.impl.UserManagerImpl;
import mosbach.dhbw.de.schichtplaner.model.CreateEventRequest;
import mosbach.dhbw.de.schichtplaner.model.CreateEventResponse;
import mosbach.dhbw.de.schichtplaner.model.DeleteEventResponse;
import mosbach.dhbw.de.schichtplaner.model.UpdateEventRequest;
import mosbach.dhbw.de.schichtplaner.model.UpdateEventResponse;
import mosbach.dhbw.de.schichtplaner.model.GetAllEventResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventManager eventManager = EventManagerImpl.getInstance();
    private final UserManager userManager = UserManagerImpl.getInstance(); // Assuming a UserManager instance
    private static final Logger logger = Logger.getLogger(EventController.class.getName());

    @PostMapping
    public ResponseEntity<CreateEventResponse> createEvent(@RequestBody CreateEventRequest request) {
        logger.log(Level.INFO, "Creating new event: " + request.getTitle());

        Event newEvent = new EventImpl(
                EventManagerImpl.createID(),  // Assuming there's a way to generate an ID
                request.getTitle(),
                request.getStartDateTime(),
                request.getEndDateTime(),
                request.getLocation(),
                request.getDescription(),
                request.getAssignedUserId()
        );

        eventManager.addEvent(newEvent);

        CreateEventResponse response = new CreateEventResponse("Event created successfully", newEvent.getId());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateEventResponse> updateEvent(@PathVariable int id, @RequestBody UpdateEventRequest request) {
        logger.log(Level.INFO, "Updating event ID: " + id);

        Event updatedEvent = new EventImpl(
                id,
                request.getTitle(),
                request.getStartDateTime(),
                request.getEndDateTime(),
                request.getLocation(),
                request.getDescription(),
                request.getAssignedUserId()
        );

        eventManager.updateEvent(updatedEvent);

        UpdateEventResponse response = new UpdateEventResponse("Event updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteEventResponse> deleteEvent(@PathVariable int id) {
        logger.log(Level.INFO, "Deleting event ID: " + id);

        eventManager.deleteEvent(id);

        DeleteEventResponse response = new DeleteEventResponse("Event deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<GetAllEventResponse>> getAllEvents() {
        logger.log(Level.INFO, "Fetching all events");

        List<GetAllEventResponse> events = eventManager.getAllEvents().stream()
                .map(event -> {
                    // Fetch assigned user details
                    User assignedUser = userManager.getUserById(event.getAssignedUserId());
                    GetAllEventResponse.AssignedUser userResponse = new GetAllEventResponse.AssignedUser(
                            assignedUser.getId(),
                            assignedUser.getName()
                    );

                    // Create and return event response
                    return new GetAllEventResponse(
                            event.getId(),
                            event.getTitle(),
                            event.getStartTime(),
                            event.getEndTime(),
                            userResponse,
                            new GetAllEventResponse.Location(event.getLocation(), 0.0, 0.0), // Assuming static location details for now
                            event.getDescription()
                    );
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAllEventResponse> getEventById(@PathVariable int id) {
        logger.log(Level.INFO, "Fetching event with ID: " + id);

        Event event = eventManager.getEventById(id);
        if (event == null) {
            return ResponseEntity.notFound().build();
        }

        // Fetch assigned user details
        User assignedUser = userManager.getUserById(event.getAssignedUserId());
        GetAllEventResponse.AssignedUser userResponse = new GetAllEventResponse.AssignedUser(
                assignedUser.getId(),
                assignedUser.getName()
        );

        // Create event response
        GetAllEventResponse response = new GetAllEventResponse(
                event.getId(),
                event.getTitle(),
                event.getStartTime(),
                event.getEndTime(),
                userResponse,
                new GetAllEventResponse.Location(event.getLocation(), 0.0, 0.0), // Assuming static location details for now
                event.getDescription()
        );

        return ResponseEntity.ok(response);
    }
}
