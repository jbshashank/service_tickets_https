package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.Cart;
import com.ayushya.spring.bean.OTP;

public interface OTPRepository extends MongoRepository<OTP, String> {
	Cart findBy_id(ObjectId _id);
}
