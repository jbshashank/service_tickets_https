package com.ayushya.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ayushya.spring.bean.Tickets;
import org.bson.types.ObjectId;


public interface TicketsRepository_pagination extends PagingAndSortingRepository<Tickets, String>{
	Tickets findBy_id(ObjectId _id);
}

