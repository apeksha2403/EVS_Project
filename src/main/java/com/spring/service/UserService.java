package com.spring.service;

import com.spring.entity.UserEntity;
import com.spring.json.LoginResponse;
import com.spring.json.User;

public interface UserService {

	Object save(UserEntity userEntity,User user);
	
	Object updateUser(User user, int userId,String sessionId);

	Object deleteUser(int userId,String sessionId);

	Object getUserById(int userId,String sessionId);

	LoginResponse adminLogout(String sessionId);

	LoginResponse adminLogin(User user);

	

}
