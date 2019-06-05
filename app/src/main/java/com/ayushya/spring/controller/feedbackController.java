package com.ayushya.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.feedback;
import com.ayushya.spring.repository.feedbackRepository;

@RestController
@RequestMapping("/feedback")
public class feedbackController {

	@Autowired
	private feedbackRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public feedback createFeedback(@Valid @RequestBody feedback feedback) {
		return repository.save(feedback);
	}
	
}
