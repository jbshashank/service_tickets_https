package com.ayushya.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ayushya.spring.bean.tickets;
import org.bson.types.ObjectId;


public interface ticketsRepository_pagination extends PagingAndSortingRepository<tickets, String>{
	tickets findBy_id(ObjectId _id);
}

