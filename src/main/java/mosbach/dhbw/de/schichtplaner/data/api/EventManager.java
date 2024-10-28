package mosbach.dhbw.de.schichtplaner.data.api;

import mosbach.dhbw.de.schichtplaner.data.api.Event;
import java.util.List;

public interface EventManager {
    List<Event> getAllEvents();
    Event getEventById(int eventId);
    void addEvent(Event event);
    void updateEvent(Event event);
    void deleteEvent(int eventId);
}
