package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.logs;

public interface logsRepository extends MongoRepository<logs, String> {
	logs findBy_id(ObjectId _id);
}
