package com.ayushya.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.Tickets;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.bson.types.ObjectId;


public interface TicketsRepository extends MongoRepository<Tickets, String>{
	Tickets findBy_id(ObjectId _id);
	Page<Tickets> findByCity(String city,Pageable p);
//	@Query("{'visit_date': {$gte: ISODate('?0') }}")
	//@Query("{'visit_date': {'date': ?0 }}")
	//@Query("{ 'visit_date' : {'$gte': ?0 } }")
	@Query("{visit_date : {$lte : ?0 }}")
	Page<Tickets> findTicketsByVisit_date(Date visit_Date,Pageable p);
	
	@Query("{email_id : ?0 , ticket_status: { $nin: [\"closed\"] }}")
	Page<Tickets> findTicketsByUser(String user,Pageable p);
	@Query("{email_id : ?0 , ticket_status : ?1}")
	Page<Tickets> findTicketsByUserAndTicketStatus(String user,String Status,Pageable p);
}



