package com.ayushya.spring.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.ayushya.spring.bean.DamagedReturns;
import com.ayushya.spring.bean.DamagedReturnsItems;
import com.ayushya.spring.bean.EventAttributes;
import com.ayushya.spring.bean.InventoryAccessories;
import com.ayushya.spring.bean.InventoryParts;
import com.ayushya.spring.bean.TechFeedback;
import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.bean.Tickets;
import com.ayushya.spring.repository.DamagedReturnsRepository;
import com.ayushya.spring.repository.ImageRepository;
import com.ayushya.spring.repository.InventoryPartsRepository;
import com.ayushya.spring.repository.TechnicianRepository;
import com.ayushya.spring.repository.TicketsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.mongodb.gridfs.GridFSInputFile;

@Service
@Transactional
public class DamagedServiceReturnServiceImpl implements DamagedReturnService {

	@Autowired
	DamagedReturnsRepository damagedReturnsRepository;

	@Autowired
	ImageRepository imageRepository;

	private final GridFsTemplate gridFsTemplate;

	@Autowired
	public DamagedServiceReturnServiceImpl(GridFsTemplate gridFsTemplate) {
		this.gridFsTemplate = gridFsTemplate;
	}



	@Override
	public DamagedReturns addDamagedPartReturn(String ticket_number, DamagedReturns damagedReturns) {

		DamagedReturns damagedReturnsPresentitem = damagedReturnsRepository.findBy_id(ticket_number);
		damagedReturns.set_id(ticket_number);
		if(damagedReturnsPresentitem==null)return damagedReturnsRepository.save(damagedReturns);
		else
		{
			damagedReturnsPresentitem.set_id(ticket_number);
			damagedReturnsPresentitem.damagedReturnsItems.addAll(damagedReturns.getDamagedReturnsItems());
			return damagedReturnsRepository.save(damagedReturnsPresentitem);
		}

	}

	@Override
	public DamagedReturns deleteDamagedPartReturn(String ticket_number, DamagedReturns damagedReturns) {
		DamagedReturns damagedReturnsPresentitems = damagedReturnsRepository.findBy_id(ticket_number);
		if(damagedReturnsPresentitems==null)return null;
		else {
			DamagedReturns damagedReturnsNewitems  = new DamagedReturns();
			List<DamagedReturnsItems> damagedReturnsItems = new ArrayList<>();

			damagedReturnsNewitems.setDamagedReturnsItems(damagedReturnsItems);
			//damagedReturnsNewitems.damagedReturnsItems = (List<DamagedReturnsItems>) new DamagedReturnsItems();
			damagedReturnsNewitems.set_id(ticket_number);
			for (DamagedReturnsItems damagedReturnsItem : damagedReturnsPresentitems.damagedReturnsItems) {
				if(!damagedReturnsItem.partname.equals(damagedReturns.getDamagedReturnsItems().get(0).getPartname())){
					damagedReturnsNewitems.damagedReturnsItems.add(damagedReturnsItem);
				}
			}
			return damagedReturnsRepository.save(damagedReturnsNewitems);
		}
	}




	@Override
	public ResponseEntity<byte[]> addDamagedPartReturnImage(String ticket_number, DamagedReturns damagedReturns,
			MultipartFile uploadfile) throws IOException {
		DamagedReturns damagedReturnsPresentitem = damagedReturnsRepository.findBy_id(ticket_number);
		String name = uploadfile.getOriginalFilename();
		Optional<GridFSDBFile> existing = maybeLoadFile(name);
		GridFSFile gridFSFile= gridFsTemplate.store(uploadfile.getInputStream(), name, uploadfile.getContentType());	  

		damagedReturns.damagedReturnsItems.get(0).setGridDBFile(gridFSFile);

//		if (existing.isPresent()) {
//			gridFsTemplate.delete(getFilenameQuery(name));
//		}
//		gridFsTemplate.store(uploadfile.getInputStream(), name, uploadfile.getContentType()).save();	  
		damagedReturns.set_id(ticket_number);
		
		if(damagedReturnsPresentitem==null) {
			DamagedReturns damagedReturnssaved= damagedReturnsRepository.save(damagedReturns);
			byte[] response = serialize(gridFSFile);

			return new ResponseEntity<byte[]>(response, HttpStatus.OK); }
		else
		{
			damagedReturnsPresentitem.set_id(ticket_number);
			damagedReturnsPresentitem.damagedReturnsItems.addAll(damagedReturns.getDamagedReturnsItems());
			DamagedReturns damagedReturnssaved= damagedReturnsRepository.save(damagedReturnsPresentitem);
			byte[] response = serialize(damagedReturnssaved);
			return new ResponseEntity<byte[]>(response, HttpStatus.OK);
		}
	}
	private Optional<GridFSDBFile> maybeLoadFile(String name) {
		GridFSDBFile file = gridFsTemplate.findOne(getFilenameQuery(name));
		return Optional.ofNullable(file);
	}
	private static Query getFilenameQuery(String name) {
		return Query.query(GridFsCriteria.whereFilename().is(name));
	}
	
	  private static byte[] serialize(Object obj) throws IOException {
		    ByteArrayOutputStream os = new ByteArrayOutputStream();
		    ObjectMapper mapper = new ObjectMapper();
		    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		    mapper.enable(SerializationFeature.INDENT_OUTPUT);
		    mapper.writeValue(os, obj);
		    return os.toByteArray();
		}
}
