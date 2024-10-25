package schichtplanerbackend.controller;

import org.springframework.web.bind.annotation.*;
import schichtplanerbackend.entities.Event;
import schichtplanerbackend.repository.EventRepository;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventRepository eventRepository = new EventRepository();

    @GetMapping
    public List<Event> getAllEvents() throws SQLException {
        return eventRepository.findAllEvents();
    }

    @PostMapping
    public void createEvent(@RequestBody Event event) throws SQLException {
        eventRepository.saveEvent(event);
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable int id) throws SQLException {
        return eventRepository.findEventById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable int id) throws SQLException {
        eventRepository.deleteEvent(id);
    }
}
