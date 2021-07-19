package com.claim.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.Event;
import com.claim.entity.User;
import com.claim.repository.EventRepository;
import com.claim.repository.UserRepository;

@CrossOrigin
@RestController
public class EventController {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value = "/createEvent", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST
			)
	public void createEvent(@RequestBody Event event) {
		
		Optional<User> user = this.userRepository.findById(event.getCreatedBy().getEmail());
		event.setCreatedBy(user.get());
		
		this.eventRepository.save(event);
		
		System.out.println("Saved: " + event.getEventId() + " at " + event.getScheduledDate());
		
	}
	
	@RequestMapping(value = "/findEventByUser", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST
			)
	public ResponseEntity<List<Event>> findEventByUser(@RequestBody User user) {
		
		String email = user.getEmail();
		System.out.println(email);
		List<Event> events = this.eventRepository.findEventByEmail(email);
		
			System.out.println(events);
			return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
					
			}
	
	@RequestMapping(value = "/deleteEvent", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST
			)
	public void deleteEvent(@RequestBody Event event) {
		
		this.eventRepository.delete(event);
		System.out.println("Deleted: " + event );
					
			}
	
	
	
}
