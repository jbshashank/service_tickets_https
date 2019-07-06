package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.Logs;

public interface logsRepository extends MongoRepository<Logs, String> {
	Logs findBy_id(ObjectId _id);
}
