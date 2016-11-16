package com.andersen.restspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andersen.restspring.model.Event;
import com.andersen.service.EventService;

@Service
@RestController
@RequestMapping("/")
public class EventController {
	
	private EventService eventService;

	@Autowired
	public void setTeventService(EventService EventService) {
		this.eventService = EventService;
	}

	@RequestMapping(path = { "event", "event/{id}" }, method = { RequestMethod.POST, RequestMethod.PUT })
	private ResponseEntity<Event> create(@PathVariable(required = false) Integer id,
			@RequestBody Event Event) {
		if (!eventService.contains(id)) {

			throw new EventNotFoundException();
		}
		eventService.save(Event, Optional.ofNullable(id).orElse(new Integer(0)));
		return new ResponseEntity<>(Event, HttpStatus.OK);
	}

	@RequestMapping(path = "events", method = RequestMethod.GET)
	public List<Event> getAllEvents() {
		return eventService.findAll();
	}

	@RequestMapping(path = "event/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteEvent(@PathVariable("id") Integer id) {
		if (!eventService.contains(id)) {
			throw new EventNotFoundException();
		}
		eventService.delete(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@RequestMapping(path = "event/{id}", method = RequestMethod.GET)
	public ResponseEntity<Event> getEvent(@PathVariable("id") Integer id) {
		if (!eventService.contains(id)) {
			throw new EventNotFoundException();
		}
		Event Event = eventService.findOne(id);
		return new ResponseEntity<>(Event, HttpStatus.OK);
	}

}
