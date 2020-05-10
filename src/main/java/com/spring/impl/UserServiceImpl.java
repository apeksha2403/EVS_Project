package com.spring.impl;

import java.security.SecureRandom;
import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.entity.UserEntity;
import com.spring.json.LoginResponse;
import com.spring.json.User;
import com.spring.repository.UserRepository;
import com.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	private final Random random = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

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
	public LoginResponse adminLogin(User user) {
		System.out.println(user);
		User newUser = new User();
		LoginResponse response = new LoginResponse();

		if (userRepository.findByUserId(user.getUserId()) != null) {
			UserEntity userEntity = userRepository.findByUserId(user.getUserId());
			BeanUtils.copyProperties(userEntity, newUser);
			String sessionId = null;
			if (newUser.getUserId() == (user.getUserId()) && newUser.getPassword().equals(user.getPassword())
					&& user.getUserType().equals("A") && newUser.getUserType().equals("A")) {
				sessionId = generateRandomString(6);
				userEntity.setSessionId(sessionId);
				userEntity.setLoginStatus(1);
				userRepository.save(userEntity);
				response.setMessage("Login Successful-admin");
				response.setResult("Success");
				response.setSessionId(sessionId);

			} else if (newUser.getUserId() == (user.getUserId()) && newUser.getPassword().equals(user.getPassword())
					&& user.getUserType().equals("E") && newUser.getUserType().equals("E")) {
				sessionId = generateRandomString(6);
				userEntity.setSessionId(sessionId);
				userEntity.setLoginStatus(1);
				userRepository.save(userEntity);
				response.setMessage("Login Successful-electoral");
				response.setResult("Success");
				response.setSessionId(sessionId);

			} else if (newUser.getUserId() == (user.getUserId()) && newUser.getPassword().equals(user.getPassword())
					&& user.getUserType().equals("V") && newUser.getUserType().equals("V")) {
				sessionId = generateRandomString(6);
				userEntity.setSessionId(sessionId);
				userEntity.setLoginStatus(1);
				userRepository.save(userEntity);
				response.setMessage("Login Successful-voter");
				response.setResult("Success");
				response.setSessionId(sessionId);

			}
		} else {
			response.setMessage("Login UnSuccessful");
			response.setResult("Failure");
			response.setSessionId(null);
		}
		return response;
	}

	@Override
	public LoginResponse adminLogout(String sessionId) {
		LoginResponse response = new LoginResponse();
		if (sessionId == null) {
			response.setMessage("INVALID SESSIONID");
		} else {
			UserEntity userEntity = userRepository.findBySessionId(sessionId);
			userEntity.setSessionId(null);
			userEntity.setLoginStatus(0);

			userRepository.save(userEntity);
			response.setMessage("LOGGED OUT SUCCESFULLY");
		}
		return response;
	}

	@Override
	public Object save(UserEntity userEntity, User user) {
		BeanUtils.copyProperties(user, userEntity);
		userEntity.setLoginStatus(0);
		userEntity = userRepository.save(userEntity);
		return userEntity;
	}

	@Override
	public Object getUserById(int userId, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		if (userEntity != null) {
			userEntity = userRepository.findByUserId(userId);
			if (userEntity != null) {
				return userEntity;
			} else {
				return "No User present with thid userId.";
			}
		} else {
			return "Session Id is invalid";
		}

	}

	@Override
	public Object updateUser(User user, int userId, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		if (userEntity != null) {
			userEntity = userRepository.findByUserId(userId);
			if (userEntity != null) {
				userEntity.setFirstName(user.getFirstName());
				userEntity.setLastName(user.getLastName());
				userEntity.setCity(user.getCity());
				userEntity.setConstituency(user.getConstituency());
				userEntity.setDateOfBirth(user.getDateOfBirth());
				userEntity.setEmailId(user.getEmailId());
				userEntity.setGender(user.getGender());
				userEntity.setMobileNo(user.getMobileNo());
				userEntity.setStreet(user.getStreet());
				userEntity.setState(user.getState());
				userEntity.setPincode(user.getPincode());
				userEntity = userRepository.save(userEntity);
				return userEntity;
			} else {
				return "UserID doens't exist";
			}
		}
		return "SessionId doesn't exist";
	}

	@Override
	public Object deleteUser(int userId, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		if (userEntity != null) {
			if (userRepository.findByUserId(userId) != null) {
				userRepository.deleteByUserId(userId);
				return "User deleted successfully.";
			} else {
				return "User Id doesn't exist.";
			}
		} else {
			return "Invalid SessionId";
		}

	}

}
