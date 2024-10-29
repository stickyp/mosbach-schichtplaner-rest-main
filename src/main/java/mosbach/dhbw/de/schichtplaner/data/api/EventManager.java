package mosbach.dhbw.de.schichtplaner.data.api;

import java.util.List;

public interface EventManager {

    /**
     * Generates a unique ID for a new event.
     * @return int - a unique event ID.
     */
    int generateID();

    /**
     * Gets all events.
     * @return List<Event> - a list of all events.
     */
    List<Event> getAllEvents();

    /**
     * Gets an event by its ID.
     * @param eventId - the ID of the event.
     * @return Event - the event found with the specified ID.
     */
    Event getEventById(int eventId);

    /**
     * Adds a new event.
     * @param event - the event to be added.
     */
    void addEvent(Event event);

    /**
     * Updates an existing event.
     * @param event - the event with updated information.
     */
    void updateEvent(Event event);

    /**
     * Deletes an existing event.
     * @param eventId - the ID of the event to be deleted.
     */
    void deleteEvent(int eventId);
}
