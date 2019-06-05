package com.ayushya.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.techFeedback;
import com.ayushya.spring.repository.techFeedbackRepository;

@RestController
@RequestMapping("/feedback/customer")
public class techFeedbackController {
	
	@Autowired
	private techFeedbackRepository repository;
	
	@PostMapping(value = "/{ticket_number}")
	public techFeedback saveTechFeedBack(@PathVariable String ticket_number, @Valid @RequestBody techFeedback techFeedback) {
		return repository.save(techFeedback);
	}

}
