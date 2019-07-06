package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.RequestNewItem;

public interface RequestNewItemRepository extends MongoRepository<RequestNewItem, String>{
	RequestNewItem findBy_id(ObjectId _id);
}
