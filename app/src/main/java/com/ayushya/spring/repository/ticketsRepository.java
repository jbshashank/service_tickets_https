package com.ayushya.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.tickets;
import org.bson.types.ObjectId;


public interface ticketsRepository extends MongoRepository<tickets, String>{
	tickets findBy_id(ObjectId _id);
	Page<tickets> findByCity(String city,Pageable p);
	@Query("{'visit_date': ?0}")
	Page<tickets> findTicketsByVisit_date(String visit_Date,Pageable p);
}



