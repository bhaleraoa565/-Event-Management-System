package com.Event.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Event.Management.System.Model.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {

}
