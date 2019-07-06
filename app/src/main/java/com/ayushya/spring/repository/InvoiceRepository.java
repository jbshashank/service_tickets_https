package com.ayushya.spring.repository;

import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.Invoice;
import com.ayushya.spring.bean.PurchasedItems;

public interface InvoiceRepository extends MongoRepository<Invoice, String>{
}
