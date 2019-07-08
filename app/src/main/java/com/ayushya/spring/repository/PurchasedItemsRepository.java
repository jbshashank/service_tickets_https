package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.Invoice;
import com.ayushya.spring.bean.PurchasedItems;

public interface PurchasedItemsRepository extends MongoRepository<PurchasedItems, String>{
	JSONArray findBy_id(String _id);
}
