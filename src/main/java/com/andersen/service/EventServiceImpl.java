package com.andersen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andersen.restspring.model.Event;
import com.andersen.restspring.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	private EventRepository eventRepository;

	@Autowired
	public void setObjectsRepository(EventRepository testObjectRepository) {
		this.eventRepository = testObjectRepository;
	}

	@Override
	public boolean contains(Integer id) {
		return eventRepository.exists(id);
	}

	@Override
	public List<Event> findAll() {
		List<Event> list = eventRepository.findAll();
		return list;

	}

	@Override
	public void save(Event event, Integer id) {
		if (id != 0) {
			event.setId(id);
		}
		eventRepository.saveAndFlush(event);		
	}

	@Override
	public void delete(Integer id) {
		eventRepository.delete(id);	
	}

	@Override
	public Event findOne(Integer id) {
		Event event = eventRepository.findOne(id);		
		return event;
	}

}
