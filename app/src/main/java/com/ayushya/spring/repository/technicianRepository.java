package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.technician;

public interface technicianRepository extends MongoRepository<technician, String>{
	technician findBy_id(ObjectId _id);
}
