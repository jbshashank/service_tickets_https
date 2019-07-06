package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.InventoryAccessories;
import com.ayushya.spring.bean.InventoryParts;

public interface InventoryAccessoryRepository extends MongoRepository<InventoryAccessories, String>{
	InventoryAccessories findBy_id(ObjectId _id);
	@Query("{brand : ?0 , category: ?1 , subCategory: ?2, model:?3 }")
	Iterable<InventoryAccessories> fetchMatchingAccessories(String brand,String category,String sub_category,String model);
	@Query("{brand : ?0 , category: ?1 , model:?2 }")
	Iterable<InventoryAccessories> fetchMatchingAccessoriesWithoutSubCategory(String brand,String category,String model);
	
}
