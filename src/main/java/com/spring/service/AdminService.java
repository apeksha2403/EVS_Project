package com.spring.service;

import java.util.List;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.CandidateEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.json.Application;
import com.spring.json.Result;

public interface AdminService {

	Object addElection(ElectionEntity electionEntity, String sessionId);

	Object getElectionDetails(String sessionId);

	Object getPartyDetails(String sessionId);

	Object addParty(PartyEntity party, String sessionId, int electionId);

	Object addCandidate(CandidateEntity candidate, String sessionId, int electionId, int partyId);

	Object getCandidateDetails(String sessionId);

	Object getUpcomingElectionDetails(String sessionId);

	Object getRequest(String sessionId);

	Object updateRequest(Application application, int userId, String sessionId);

	Object candidatesByParty(String partyName, String sessionId);

	Object update(int candidateId, Result result, String sessionId);

	Object deletebyElectionId(int electionId, String sessionId);

	Object deletebyCandidateId(int candidateId, String sessionId);

	Object deletePartyById(int partyId, String sessionid);


}
