package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.inventoryItems;

public interface inventoryItemsRepository extends MongoRepository<inventoryItems, String>{
	inventoryItems findBy_id(ObjectId _id);
}
