package com.example.demo.service.Imply;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Event;
import com.example.demo.models.User;
import com.example.demo.repository.EventRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.EventService;
@Service
public class EventServiceImply implements EventService {
    @Autowired
    EventRepo er;
    @Autowired
    UserRepo ur;
	@Override
	public List<Event> getAll() {
		
		return er.findAll();
	}
	@Override
	public Event addEvent(Event e) {
		User fullUser = ur.findById(e.getUser().getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));

          e.setUser(fullUser); // Set the full user object to the event
         return er.save(e);
	}

	@Override
	public Event getById(int event_id) {
		
		return er.findById(event_id).orElseThrow(()->new ResourceNotFoundException("there is no event with this id:" +event_id));
	}

	@Override
	public Event updateEvent(Event e, int event_id) {
		Event e1=getById(event_id);
		e1.setTitle(e.getTitle());
		e1.setAbout(e.getAbout());
		e1.setDate(e.getDate());
		e1.setLocation(e.getLocation());
		
		return er.save(e1);
	}

	@Override
	public String deleteEvent(int event_id) {
		Optional<Event> event=er.findById(event_id);

	    if (event.isPresent()) {
	        er.deleteById(event_id);
	        return "Event with ID " + event_id + " is deleted successfully";
	    } else {
	        return "Event with ID " + event_id + " not found. Deletion failed.";
	    }		
			}

}
