package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.Cart;
import com.mongodb.gridfs.GridFS;

public interface ImageRepository extends MongoRepository<GridFS, String> {
}
