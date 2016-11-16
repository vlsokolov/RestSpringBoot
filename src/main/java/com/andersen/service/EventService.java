package com.andersen.service;

import java.util.List;

import com.andersen.restspring.model.Event;

public interface EventService {

	List<Event> findAll();

	void save(Event testObject, Integer id);

	boolean contains(Integer id);

	void delete(Integer id);

	Event findOne(Integer id);

}
