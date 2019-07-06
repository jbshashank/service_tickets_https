package com.ayushya.spring.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ayushya.spring.bean.DamagedReturns;
import com.ayushya.spring.bean.TechFeedback;
import com.ayushya.spring.repository.DamagedReturnsRepository;
import com.ayushya.spring.repository.TechnicianFeedbackRepository;
import com.ayushya.spring.service.DamagedReturnService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/returns")
public class DamagedReturnsController {
	
	
	@Autowired
	private DamagedReturnsRepository repository;
	
	@Autowired
	private DamagedReturnService damagedReturnService;
	
	@GetMapping(value = "/{ticket_number}")
	public DamagedReturns getDamagedReturnsList(@PathVariable String ticket_number) {
		return repository.findBy_id(ticket_number);
	}
	
	@PostMapping(value = "/{ticket_number}")
	public DamagedReturns addDamagedPartReturn(@PathVariable String ticket_number, @Valid @RequestBody DamagedReturns damagedReturns) {
		return damagedReturnService.addDamagedPartReturn(ticket_number,damagedReturns);
	}
	
	@PostMapping(value = "/damage/{ticket_number}")
	public ResponseEntity<byte[]> addDamagedPartReturn(@PathVariable String ticket_number,@RequestParam("DamagedReturns") String damagedReturns_json, @RequestParam("file") MultipartFile uploadfile) throws IOException {
		DamagedReturns damagedReturns  = new ObjectMapper().readValue(damagedReturns_json, DamagedReturns.class);	
		return damagedReturnService.addDamagedPartReturnImage(ticket_number,damagedReturns,uploadfile);
	}
	
	@DeleteMapping(value = "/{ticket_number}")
	public DamagedReturns RemoveDamagedPartReturn(@PathVariable String ticket_number, @Valid @RequestBody DamagedReturns damagedReturns) {
		return damagedReturnService.deleteDamagedPartReturn(ticket_number,damagedReturns);
	}
}


