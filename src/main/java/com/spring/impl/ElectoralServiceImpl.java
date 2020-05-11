package com.spring.impl;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.UserEntity;

import com.spring.json.Application;
import com.spring.repository.ApplicationRepository;

import com.spring.repository.UserRepository;
import com.spring.service.ElectoralServices;

@Service
public class ElectoralServiceImpl implements ElectoralServices {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public Object getApprovedUser(String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);	
		userEntity=userRepository.findByUserType("E");
		if (userEntity != null) {

			List<ApplicationEntity> pendingList = applicationRepository.findByPassedStatus(2);
			if (pendingList != null) {
				return pendingList;
			}
			else {
				return "{\"result\": \"failure\",\"message\": \"No Pending request available.\"}";
			}
		}
		return "{\"result\": \"failure\",\"message\": \"Wrong Session Id\"}";

	}
	
	private final Random random = new SecureRandom();
	private final String ALPHABET = "0123456789";

	public String generateUserId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder stringBuilder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			stringBuilder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
		}
		return stringBuilder.toString();
	}
	

	@Override
	public Object generateVoterId(Application application,int userId,String sessionId) {
		UserEntity userEntity=userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("E");	
		if(userEntity!=null) {
		ApplicationEntity appEntity = applicationRepository.findByUserId(userId);
			Random random=new Random();
			if(appEntity != null) {
				int voterId = random.nextInt();
				appEntity.setVoterId(voterId);
				appEntity.setApprovedStatus(2);
				appEntity.setPassedStatus(3);
				applicationRepository.save(appEntity);
				return appEntity;
			}
			else {
			return "wrong userid";
			}
		}
		return "Wrong sessionId";
		}
	@Override
	public Object deleteByVoterRequest(int userId, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity=userRepository.findByUserType("E");
		if (userEntity != null) {
			ApplicationEntity application = applicationRepository.findByUserId(userId);
			application.setPassedStatus(3);
			application.setVoterId(0);
			applicationRepository.save(application);
			return "{Succesfully  deleted}";
		} else {
			return "{invalid sessionid}";
		}
	}
	

	}
	
	
	
	
	
	
	
