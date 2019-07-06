package com.ayushya.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.repository.TechnicianRepository;

@RestController
@RequestMapping("/tech")
public class TechnicianController {

	@Autowired
	private TechnicianRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Technician> getAlltechnicians() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Technician createATech(@Valid @RequestBody Technician tech) {
		return repository.save(tech);
	}
	
}
