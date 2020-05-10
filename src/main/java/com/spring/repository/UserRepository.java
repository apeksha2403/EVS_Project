package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

	UserEntity findByUserId(int userId);

	void deleteByUserId(int userId);

	UserEntity findBySessionId(String sessionId);
    
}
