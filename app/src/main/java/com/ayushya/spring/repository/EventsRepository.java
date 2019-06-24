package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.Events;
import com.ayushya.spring.bean.feedback;

public interface EventsRepository extends MongoRepository<Events, String>{
}