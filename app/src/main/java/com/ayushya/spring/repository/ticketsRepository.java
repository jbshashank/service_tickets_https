package com.ayushya.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.tickets;
import org.bson.types.ObjectId;


public interface ticketsRepository extends MongoRepository<tickets, String>{
	tickets findBy_id(ObjectId _id);
}



