package com.Event.Management.System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Event.Management.System.Exception.ResourceNotFoundException;
import com.Event.Management.System.Model.Event;
import com.Event.Management.System.Model.Organizer;
import com.Event.Management.System.Model.Venue;
import com.Event.Management.System.Repository.EventRepository;

@Service
public class EventService {
	
    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        event.setEventName(eventDetails.getEventName());
        event.setEventDate(eventDetails.getEventDate());
        event.setDescription(eventDetails.getDescription());
        event.setOrganizer(eventDetails.getOrganizer());
        event.setVenue(eventDetails.getVenue());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }

    public List<Event> getEventsByVenue(Venue venue) {
        return eventRepository.findByVenue(venue);
    }

    public List<Event> getEventsByOrganizer(Organizer organizer) {
        return eventRepository.findByOrganizer(organizer);
    }
}

