package com.ayushya.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.TechFeedback;
import com.ayushya.spring.repository.TechnicianFeedbackRepository;

@RestController
@RequestMapping("/feedback/customer")
public class TechFeedbackController {
	
	@Autowired
	private TechnicianFeedbackRepository repository;
	
	@PostMapping(value = "/{ticket_number}")
	public TechFeedback saveTechFeedBack(@PathVariable String ticket_number, @Valid @RequestBody TechFeedback techFeedback, HttpServletRequest httpServletRequest) {
		System.out.println(" HEADER IN FEEDBACK <<USERFEEDBACK>>"+httpServletRequest.getParameter("x-userid")+":::"+httpServletRequest.getParameter("x-ticketnumber")+"::::"+httpServletRequest.getParameter("x-accountid"));
		return repository.save(techFeedback);
	}

}
