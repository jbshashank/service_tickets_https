package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.requestNewItem;

public interface requestNewItemRepository extends MongoRepository<requestNewItem, String>{
	requestNewItem findBy_id(ObjectId _id);
}
