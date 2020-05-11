package com.spring.service;

import com.spring.entity.UserEntity;
import com.spring.json.Application;
import com.spring.json.LoginResponse;
import com.spring.json.User;
import com.spring.json.VoterDetails;

public interface UserService {

	Object save(UserEntity userEntity,User user);
	
	Object updateUser(User user, int userId,String sessionId);

	Object deleteUser(int userId,String sessionId);

	Object getUserById(int userId,String sessionId);

	LoginResponse adminLogout(String sessionId);

	LoginResponse adminLogin(User user);

	Object sendRequest(Application application, int userId, String sessionId);

	Object getStatus(int userId, String sessionId);

	Object viewSchedule(String sessionid);

	Object candidatesByElection(int electionId, String sessionId);

	Object castVote(VoterDetails voterDetails, int voterId, String sessionId);

	Object viewResult(String sessionId);

	Object changePassword(User user, String sessionId);

}
