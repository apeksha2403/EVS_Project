package com.spring.controller;


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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.entity.UserEntity;
import com.spring.json.LoginResponse;
import com.spring.json.User;
import com.spring.service.UserService;


@RestController
@RequestMapping("/evs")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
    
	@Autowired
	private  UserService userService;
	
	
	String sessionId=null;
	
	@PostMapping("/user/login")
	public LoginResponse loginAdmin(@RequestBody User user,
			UserEntity userEntity) {
		LoginResponse res = userService.adminLogin(user);
		sessionId = res.getSessionId();
		return res;
	}

	@GetMapping("/user/logout")
	public LoginResponse logoutAdmin() {
		return userService.adminLogout(sessionId);
	}
	
	@PostMapping(value="/user", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object registerUser(@RequestBody User user,UserEntity userEntity) {
		BeanUtils.copyProperties(user, userEntity);
		return userService.save(userEntity, user);
	}
	
	@GetMapping("/user/{userId}")
	public Object getUserById(@PathVariable(value="userId") int userId,@RequestHeader(name = "session_id") String sessionId) {
		return userService.getUserById(userId,sessionId);
	}
	
	@PutMapping(value="/user/{userId}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object updateUser(@RequestBody User user, @PathVariable(value="userId") 
	int userId, @RequestHeader(name = "session_id") String sessionId) {
		return userService.updateUser(user, userId,sessionId);
	}

	@DeleteMapping(value="/user/{userId}")
	public Object deleteUser(@PathVariable(value="userId") int userId, @RequestHeader(name = "session_id") String sessionId) {
		return userService.deleteUser(userId,sessionId);
	}

}
