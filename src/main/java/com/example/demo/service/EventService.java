package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Event;

public interface EventService {
	List<Event> getAll();
	Event addEvent(Event e);
	Event getById(int event_id);
	Event updateEvent(Event e,int event_id);
	String deleteEvent(int event_id);
	
	

}
