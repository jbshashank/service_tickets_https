package com.ayushya.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.Feedback;
import com.ayushya.spring.repository.FeedbackRepository;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Feedback createFeedback(@Valid @RequestBody Feedback feedback, HttpServletRequest httpServletRequest) {
		System.out.println(" HEADER IN FEEDBACK <<USERFEEDBACK>>"+httpServletRequest.getParameter("x-userid")+":::"+httpServletRequest.getParameter("x-ticketnumber")+"::::"+httpServletRequest.getParameter("x-accountid"));
		return repository.save(feedback);
	}
	
}
