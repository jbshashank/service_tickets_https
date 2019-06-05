package com.ayushya.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.logs;
import com.ayushya.spring.repository.logsRepository;

@RestController
@RequestMapping("/logs")
public class logsController {
	
	@Autowired
	private logsRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public logs createLog(@Valid @RequestBody logs log) {
		log.setDateAndTime(new SimpleDateFormat("dd-MM-yy hh:mm:ss").format(new Date()));
		repository.save(log);
		return log;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<logs> getLogs(@PathVariable String _id){
		return repository.findAll();
	}
	
}
