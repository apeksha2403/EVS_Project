package com.spring.impl;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.CandidateEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.ResultEntity;
import com.spring.entity.UserEntity;
import com.spring.entity.VoterDetailsEntity;
import com.spring.json.Application;
import com.spring.json.LoginResponse;
import com.spring.json.User;
import com.spring.json.VoterDetails;
import com.spring.repository.ApplicationRepository;
import com.spring.repository.CandidateRepository;
import com.spring.repository.ElectionRepository;
import com.spring.repository.ResultRepository;
import com.spring.repository.UserRepository;
import com.spring.repository.VoterDetailsRepository;
import com.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private ElectionRepository electionRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private VoterDetailsRepository voterDetailsRepository;

	@Autowired
	private ResultRepository resultRepository;

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

	@Override
	public Object sendRequest(Application application, int userId, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		userEntity = userRepository.findByUserId(userId);
		if (userEntity != null) {
			ApplicationEntity applicationEntity = new ApplicationEntity();
			applicationEntity.setUserId(userId);
			applicationEntity.setPassedStatus(1);
			applicationEntity.setApprovedStatus(0);
			applicationEntity.setConstituency(userEntity.getConstituency());
			applicationRepository.save(applicationEntity);
			return "Application request sent";
		}

		return "Session id invalid";
	}

	@Override
	public Object getStatus(int userId, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		if (userEntity != null) {

			ApplicationEntity status = applicationRepository.findByUserId(userId);
			status = applicationRepository.save(status);
			return status;
		}
		return "{\"result\": \"failure\",\"message\": \"Wrong Session Id\"}";
	}

	@Override
	public Object viewSchedule(String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		if (userEntity != null) {
			LocalDate date = LocalDate.now();
			List<ElectionEntity> electionEntity = electionRepository.findByElectionDateGreaterThan(date);
			if (electionEntity != null)
				return electionEntity;
			else
				return "No Upcoming election.";

		} else {
			return "Invalid SessionId.";
		}
	}

	@Override
	public Object candidatesByElection(int electionId, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		if (userEntity != null) {
			ElectionEntity electionEntity = electionRepository.findByElectionId(electionId);
			int id = electionEntity.getElectionid();
			List<CandidateEntity> candidateList = candidateRepository.findByElectionId(id);
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
	public Object castVote(VoterDetails voterDetails, int voterId, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);

		if (userEntity != null) {
			VoterDetailsEntity voterEntity = voterDetailsRepository.findByVoterId(voterId);
			voterEntity = voterDetailsRepository.findByVote(0);
			if (voterEntity != null) {
				voterEntity.setVote(1);
				voterDetailsRepository.save(voterEntity);
				int id = voterEntity.getCandidateId();
				ResultEntity resultEntity = resultRepository.findByCandidateId(id);
				int votes = (int) resultEntity.getVoteCount();
				resultEntity.setVoteCount(votes + 1);
				resultRepository.save(resultEntity);
				return "Successfully cast vote";
			} else {
				return " Vote casted already";
			}
		}
		return "Invalid SessionId";
	}

	@Override
	public Object viewResult(String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		if (userEntity != null) {
			List<ResultEntity> result = resultRepository.OrderByVoteCountDesc();
			return result;
		}
		return "Invalid SessionId";

	}

	@Override
	public Object changePassword(User user, String sessionId) {
		UserEntity userEntity = userRepository.findBySessionId(sessionId);
		if (userEntity != null) {
			String password = userEntity.getPassword();
			int id = userEntity.getUserId();
			userEntity.setPassword(user.getPassword());
			userRepository.save(userEntity);
			return "Password changed Successfully.";

		}
		return "Invalid SessionId";

	}

}
