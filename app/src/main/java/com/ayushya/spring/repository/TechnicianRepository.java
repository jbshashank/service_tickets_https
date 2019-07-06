package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.Technician;

public interface TechnicianRepository extends MongoRepository<Technician, String>{
	Technician findBy_id(ObjectId _id);
}
