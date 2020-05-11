package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.UserEntity;


public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

	 Object save(UserEntity userEntity);

	ApplicationEntity findByUserId(int userId);

	List<ApplicationEntity> findByPassedStatus(int i);
       
		
}
