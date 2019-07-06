package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.Cart;

public interface CartRepository extends MongoRepository<Cart, String> {
	Cart findBy_id(ObjectId _id);
}
