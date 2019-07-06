package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.Feedback;

public interface FeedbackRepository extends MongoRepository<Feedback, String>{
	Feedback findBy_id(ObjectId _id);
}
