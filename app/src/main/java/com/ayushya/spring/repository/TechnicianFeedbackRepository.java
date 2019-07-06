package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.TechFeedback;

public interface TechnicianFeedbackRepository extends MongoRepository<TechFeedback, String> {
	TechFeedback findBy_id(ObjectId _id);
}
