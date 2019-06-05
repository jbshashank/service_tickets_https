package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.cart;

public interface cartRepository extends MongoRepository<cart, String> {
	cart findBy_id(ObjectId _id);
}
