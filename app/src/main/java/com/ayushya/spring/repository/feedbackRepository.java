package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.feedback;

public interface feedbackRepository extends MongoRepository<feedback, String>{
	feedback findBy_id(ObjectId _id);
}
