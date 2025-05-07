package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Event;
import com.example.demo.service.EventService;

@RequestMapping("events/api/v1")
@RestController
public class EventController {
   @Autowired
   EventService es;
   @PostMapping("/addEvent")
   public Event addEvent(@RequestBody Event e) {
	   return es.addEvent(e);
   }
   @GetMapping("/getAllEvents")
   public List<Event> getAll(){
	   return es.getAll();
   }
   @GetMapping("/getById/{event_id}")
   public Event getById(@PathVariable int event_id) {
	   return es.getById(event_id);
   }
   @PutMapping("/updateEvent/{event_id}")
   public Event updateEvent(@RequestBody Event e,@PathVariable int event_id) {
	   return es.updateEvent(e, event_id);
   }  
   @DeleteMapping("/deleteById/{event_id}")
   public String deleteById(@PathVariable int event_id) {
	   return es.deleteEvent(event_id);
   }
}
