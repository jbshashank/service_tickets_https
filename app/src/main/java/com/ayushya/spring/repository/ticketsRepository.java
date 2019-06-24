package com.ayushya.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.tickets;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.bson.types.ObjectId;


public interface ticketsRepository extends MongoRepository<tickets, String>{
	tickets findBy_id(ObjectId _id);
	Page<tickets> findByCity(String city,Pageable p);
//	@Query("{'visit_date': {$gte: ISODate('?0') }}")
	//@Query("{'visit_date': {'date': ?0 }}")
	//@Query("{ 'visit_date' : {'$gte': ?0 } }")
	@Query("{visit_date : {$lte : ?0 }}")
	Page<tickets> findTicketsByVisit_date(Date visit_Date,Pageable p);
}



