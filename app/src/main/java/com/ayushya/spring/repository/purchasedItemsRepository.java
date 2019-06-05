package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.purchasedItems;

public interface purchasedItemsRepository extends MongoRepository<purchasedItems, String>{
	purchasedItems findBy_id(ObjectId _id);
}
