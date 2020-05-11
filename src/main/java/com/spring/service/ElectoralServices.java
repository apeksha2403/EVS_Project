package com.spring.service;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.UserEntity;
import com.spring.json.Application;

public interface ElectoralServices {

	Object getApprovedUser(String sessionId);

	Object generateVoterId(Application application, int userId, String sessionId);

	Object deleteByVoterRequest(int userId, String sessionId);

	

}
