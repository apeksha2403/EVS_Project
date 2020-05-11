package com.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.ApplicationEntity;

import com.spring.json.Application;

import com.spring.service.ElectoralServices;

@RestController
@RequestMapping("/evs")
@CrossOrigin(origins="http://localhost:4200")
public class ElectrolOfficerController {

	
	@Autowired
	private ElectoralServices electoralService;
	
	
	
	private String sessionId = null;
	


	
	@GetMapping(value="/electoral/request")
	public Object getRequest(@RequestHeader(name = "sessionId") String sessionId){
		return electoralService.getApprovedUser(sessionId);
	}
	
	@PutMapping(value="/electoral/request/{userId}",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object updateRequest(@RequestBody Application application,
			@RequestHeader(name = "sessionId") String sessionId,
			@PathVariable(name="userId") int userId
			){
  
		return electoralService.generateVoterId(application,userId,sessionId);
	}
	
	@DeleteMapping(value= "/electoral/request/reject/{userId}")
	public Object rejectRequest(@PathVariable(name= "userId")int userId, @RequestHeader(name = "sessionId") String sessionId){
		return electoralService.deleteByVoterRequest(userId, sessionId);
	}

	

}
