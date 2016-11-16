package com.andersen.restspring.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersen.restspring.model.Event;

@Repository
@Table(name = "objects")
public interface EventRepository extends JpaRepository<Event, Integer> {
	List<Event> findByDate(Date date);
}
