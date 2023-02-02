package com.raphael.eventmanagementsystem_eventbrite.data.repository;

import com.raphael.eventmanagementsystem_eventbrite.data.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
}
