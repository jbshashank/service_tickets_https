package com.ayushya.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.technician;
import com.ayushya.spring.repository.technicianRepository;

@RestController
@RequestMapping("/tech")
public class technicianController {

	@Autowired
	private technicianRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<technician> getAlltechnicians() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public technician createATech(@Valid @RequestBody technician tech) {
		return repository.save(tech);
	}
	
}
