package com.Event.Management.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Event.Management.System.Model.Event;
import com.Event.Management.System.Model.Organizer;
import com.Event.Management.System.Model.Venue;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	List<Event> findByVenue(Venue venue);
    List<Event> findByOrganizer(Organizer organizer);

}
