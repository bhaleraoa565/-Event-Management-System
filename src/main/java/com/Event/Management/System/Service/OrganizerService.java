package com.Event.Management.System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Event.Management.System.Exception.ResourceNotFoundException;
import com.Event.Management.System.Model.Organizer;
import com.Event.Management.System.Repository.OrganizerRepository;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organizer not found"));
    }

    public Organizer updateOrganizer(Long id, Organizer organizerDetails) {
        Organizer organizer = getOrganizerById(id);
        organizer.setName(organizerDetails.getName());
        organizer.setContactInfo(organizerDetails.getContactInfo());
        return organizerRepository.save(organizer);
    }

    public void deleteOrganizer(Long id) {
        Organizer organizer = getOrganizerById(id);
        organizerRepository.delete(organizer);
    }
}

