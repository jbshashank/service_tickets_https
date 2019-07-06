package com.ayushya.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ayushya.spring.bean.DamagedReturns;
import com.ayushya.spring.bean.InventoryAccessories;
import com.ayushya.spring.bean.InventoryParts;
import com.ayushya.spring.bean.TechFeedback;
import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.bean.Tickets;


public interface DamagedReturnService {

	public DamagedReturns addDamagedPartReturn(String ticket_number, DamagedReturns damagedReturns);

	public DamagedReturns deleteDamagedPartReturn(String ticket_number, DamagedReturns damagedReturns);

	public ResponseEntity<byte[]> addDamagedPartReturnImage(String ticket_number, DamagedReturns damagedReturns,
			MultipartFile uploadfile) throws IOException;


}
