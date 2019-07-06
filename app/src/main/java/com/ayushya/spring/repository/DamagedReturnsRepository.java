package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.DamagedReturns;
import com.ayushya.spring.bean.InventoryAccessories;
import com.ayushya.spring.bean.InventoryParts;
import com.ayushya.spring.bean.TechFeedback;

public interface DamagedReturnsRepository extends MongoRepository<DamagedReturns, String>{
	DamagedReturns findBy_id(String _id);
	
}
