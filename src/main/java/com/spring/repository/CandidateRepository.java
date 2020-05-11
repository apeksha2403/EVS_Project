package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.CandidateEntity;


public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {
	List<CandidateEntity> findByPartyId(int partyId);

	CandidateEntity findByCandidateId(int candidateId);

	List<CandidateEntity> findByElectionId(int id);	
}
