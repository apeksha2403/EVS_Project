package com.spring.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.CandidateEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.ResultEntity;
import com.spring.json.Application;
import com.spring.json.Candidate;
import com.spring.json.Election;
import com.spring.json.Party;
import com.spring.json.Result;
import com.spring.service.AdminService;

@RestController
@RequestMapping("/evs")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService adminService;

	private String sessionId = null;

	@PostMapping(value = "/admin/election")
	public Object addElectionDetails(@RequestBody Election election, ElectionEntity electionEntity,
			@RequestHeader(name = "sessionId") String sessionId) {
		BeanUtils.copyProperties(election, electionEntity);
		return adminService.addElection(electionEntity, sessionId);
	}

	@GetMapping(value = "/user/election")
	public Object getElectionDetails(@RequestHeader(name = "sessionId") String sessionId) {
		return adminService.getElectionDetails(sessionId);
	}

	@PostMapping(value = "/admin/{electionId}/party")
	public Object addPartyDetails(@RequestBody Party party, PartyEntity partyEntity,
	@PathVariable (name="electionId") int electionId,	@RequestHeader(name = "sessionId") String sessionId) {
		BeanUtils.copyProperties(party, partyEntity);
		return adminService.addParty(partyEntity, sessionId,electionId);

	}

	@GetMapping(value = "/user/party")
	public Object getPartyDetails(@RequestHeader(name = "sessionId") String sessionId) {
		return adminService.getPartyDetails(sessionId);
	}

	@PostMapping(value="/admin/election/{electionId}/party/{partyId}/candidate")
	public Object addCandidateDetails(@RequestBody Candidate candidate, CandidateEntity candidateEntity, 
	@RequestHeader(name = "sessionId")
	String sessionId,@PathVariable (name="electionId") int electionId,@PathVariable (name="partyId") int partyId) {
		BeanUtils.copyProperties(candidate, candidateEntity);
		return adminService.addCandidate(candidateEntity,sessionId,electionId,partyId);
	}
	
	@GetMapping(value="/user/candidate")
	public Object getCandidateDetails(@RequestHeader(name = "sessionId") String sessionId
			) {
		return adminService.getCandidateDetails(sessionId);
	}
	
	@GetMapping(value="/user/upcomingElection")
	public Object getUpcomingElectionDetails(@RequestHeader(name = "sessionId") String sessionId
			) {
		return adminService.getUpcomingElectionDetails(sessionId);
	}
	
	@GetMapping(value="/user/request")
	public Object getRequestFromVoter(@RequestHeader(name = "sessionId") String sessionId
			) {
		return adminService.getRequest(sessionId);
	}
	
	@PutMapping(value="/admin/{userId}/request")
	public Object updateRequest(@RequestBody Application application,
	@PathVariable(value="userId") int userId,@RequestHeader(name = "sessionId") String sessionId
			) {
		return adminService.updateRequest(application,userId,sessionId);
	}
	
	@GetMapping(value="party/candidate/{name}")
	public Object detailsByParty(@PathVariable(name="name") String partyName,@RequestHeader(name="sessionId") String sessionId){
		return adminService.candidatesByParty(partyName,sessionId);	
	}
	
	@PutMapping(value="/admin/election/results/approval/{candidateId}",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object resultStatus(@PathVariable(value="candidateId") int candidateId,@RequestBody Result result,
			ResultEntity resultEntity,@RequestHeader(name="sessionId") String sessionId) {
        BeanUtils.copyProperties(result, resultEntity); 
		return adminService.update(candidateId,result,sessionId);
		
	}
	@DeleteMapping(value="/admin/election/delete/{electionid}")
	public Object deleteElectionById(@PathVariable(value="electionId")int electionId,@RequestHeader(name="sessionId") String sessionid) {
		return adminService.deletebyElectionId(electionId,sessionid);
		
	}
	
	@DeleteMapping(value="/admin/candidate/delete/{candidateId}")
	public Object deleteCandidateById(@PathVariable(value="candidateId") int candidateId,@RequestHeader(name="sessionId") String sessionid) {
		return adminService.deletebyCandidateId(candidateId,sessionid);
		
	}
	
	@DeleteMapping(value="/admin/party/delete/{partyId}")
	public Object deletePartyById(@PathVariable(value="partyId") int partyId,@RequestHeader(name="sessionId") String sessionid) {
		return adminService.deletePartyById(partyId,sessionid);
		
	}
}
