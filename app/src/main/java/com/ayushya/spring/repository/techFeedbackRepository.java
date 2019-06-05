package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.techFeedback;

public interface techFeedbackRepository extends MongoRepository<techFeedback, String> {
	techFeedback findBy_id(ObjectId _id);
}
