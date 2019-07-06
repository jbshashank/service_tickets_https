package com.ayushya.spring.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ayushya.spring.bean.*;



@Service
public class NextSequenceService {
    @Autowired private MongoOperations mongo;

    public String getNextSequence(String seqName,String date){
    	String updateDate = date;
    	int sequence=1;   	
    	CustomSequences counter = mongo.findOne(query(where("_id").is(seqName)), CustomSequences.class);
    	if(counter!=null && date.equalsIgnoreCase(counter.getDate())) {sequence = counter.getSeq()+1;}
    	CustomSequences counter1 = mongo.findAndModify(
            query(where("_id").is(seqName)),
            new Update().set("seq",sequence).set("date",updateDate),
            options().returnNew(true).upsert(true),
            CustomSequences.class);

		String numberAsString = String.format("%03d", counter1.getSeq());
		String ticketNumber = "ATAS"+ updateDate + numberAsString;
		
        return ticketNumber;
    }
    
    public String getNextSequence(String seqName){
    	int sequence=1;   	
    	CustomSequences counter = mongo.findOne(query(where("_id").is(seqName)), CustomSequences.class);
    	if(counter!=null ) {sequence = counter.getSeq()+1;}
    	CustomSequences counter1 = mongo.findAndModify(
            query(where("_id").is(seqName)),
            new Update().set("seq",sequence),
            options().returnNew(true).upsert(true),
            CustomSequences.class);

		String numberAsString = String.format("%06d", counter1.getSeq());
		String ticketNumber = "ATASPART" + numberAsString;
		
        return ticketNumber;
    }
}