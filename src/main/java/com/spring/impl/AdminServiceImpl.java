package com.spring.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.CandidateEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.ResultEntity;
import com.spring.entity.UserEntity;
import com.spring.json.Application;
import com.spring.json.LoginResponse;
import com.spring.json.Party;
import com.spring.json.Result;
import com.spring.repository.ApplicationRepository;
import com.spring.repository.CandidateRepository;
import com.spring.repository.ElectionRepository;
import com.spring.repository.PartyRepository;
import com.spring.repository.ResultRepository;
import com.spring.repository.UserRepository;
import com.spring.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ElectionRepository electionRepository;

	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private ResultRepository resultRepository;
	
	@Override
	public Object addElection(ElectionEntity electionEntity, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			electionRepository.save(electionEntity);
			return electionEntity;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}
	}

	@Override
	public Object getElectionDetails(String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			Set<ElectionEntity> electionList = new HashSet<>();
			electionRepository.findAll().forEach(electionList::add);
			return electionList;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}
	}

	@Override
	public Object getUpcomingElectionDetails(String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			LocalDate date = LocalDate.now();
			List<ElectionEntity> electionEntity = electionRepository.findByElectionDateGreaterThan(date);
			return electionEntity;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}
	}

	@Override
	public Object addParty(PartyEntity party, String sessionId, int electionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		ElectionEntity electionEntity = electionRepository.findByElectionId(electionId);
		System.out.println(electionEntity);
		if (userEntity != null) {
			party.setElectionId(electionEntity.getElectionid());
			partyRepository.save(party);
			return party;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}
	}

	@Override
	public Object getPartyDetails(String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			List<PartyEntity> partyList = new ArrayList<>();
			partyRepository.findAll().forEach(partyList::add);
			return partyList;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}
	}

	@Override
	public Object addCandidate(CandidateEntity candidate, String sessionId, int electionId, int partyId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			ElectionEntity electionEntity = electionRepository.findByElectionId(electionId);
			PartyEntity partyEntity = partyRepository.findByPartyId(partyId);
			if (electionEntity != null && partyEntity != null) {
				candidateRepository.save(candidate);
				return candidate;
			} else {
				return "electionid doenst exist";
			}
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}

	}

	@Override
	public Object getCandidateDetails(String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			List<CandidateEntity> candidateList = new ArrayList<>();
			candidateRepository.findAll().forEach(candidateList::add);
			return candidateList;
		}
		return "No candidate available.";
	}

	@Override
	public Object updateRequest(Application application, int userId, String sessionId) {

		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			ApplicationEntity app = applicationRepository.findByUserId(userId);
			if (app != null) {
				app.setVoterId(0);
				app.setApprovedStatus(1);
				app.setPassedStatus(2);
				app.setConstituency(userEntity.getConstituency());
				app=applicationRepository.save(app);
				return app;
			} else
				return "{\"result\": \"failure\",\"message\": \"Wrong User Id\"}";
		} else {

			return "{\"result\": \"failure\",\"message\": \"Wrong Session Id\"}";
		}

	}


	@Override
	public Object getRequest(String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			List<ApplicationEntity> applicationEntityList = new ArrayList<ApplicationEntity>();
			applicationEntityList = applicationRepository.findByPassedStatus(1);
			if (applicationEntityList != null) {
				applicationRepository.findAll().forEach(applicationEntityList::add);
				return applicationEntityList;
			} else {
				return "No Pending Request";
			}
		}

		return "Session id invalid";
	}
	

	@Override
	public Object candidatesByParty(String partyName, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null ) {
			List<PartyEntity> partyEntity = partyRepository.findByName(partyName);
			PartyEntity party = partyEntity.get(0);
			int id = party.getPartyid();
			List<CandidateEntity> candidateList = candidateRepository.findByPartyId(id);
			return candidateList;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}

	}

	@Override
	public Object update(int candidateId, Result result, String sessionId) {
     UserEntity userEntity = userRepository.findBySessionId(sessionId);
     userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			ResultEntity resultEntity=resultRepository.findByCandidateId(candidateId);
			if (resultEntity != null) {
				resultEntity.setElectionId(result.getElectionId());
				resultEntity.setCandidateId(result.getCandidateId());
				resultEntity.setVoteCount(result.getVoteCount());
				resultEntity.setResultStatus(result.getResultStatus());
				resultRepository.save(resultEntity);
				return "{\"result\": \"success\",\"message\": \"Status updated successfully\"}";
			} else
				return "{\"result\": \"failure\",\"message\": \"Wrong candidate Id\"}";
		} else {
			return "{\"result\": \"failure\",\"message\": \"Wrong Session Id\"}";
		}
	}
	
	@Override
	public Object deletebyElectionId(int electionId, String sessionId) {

		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			ElectionEntity electionEntity = electionRepository.findByElectionId(electionId);
			electionRepository.delete(electionEntity);
			return "{Succesfully deleted}";
		} else {
			return "{Invalid session id}";
		}
	}

	@Override
	public Object deletebyCandidateId(int candidateId, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			CandidateEntity candidate = candidateRepository.findByCandidateId(candidateId);
			candidateRepository.delete(candidate);
			return "{Succesfully deleted}";
		} else {
			return "{invalid session id}";
		}
	}

	@Override
	public Object deletePartyById(int partyId, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("A");
		if (userEntity != null) {
			PartyEntity party = partyRepository.findByPartyId(partyId);
			partyRepository.delete(party);
			return "{Succesfully deleted}";
		} else {
			return "{invalid session id}";
		}
	}

}
