package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.CandidateEntity;
import com.spring.entity.VoterDetailsEntity;


public interface VoterDetailsRepository extends JpaRepository<VoterDetailsEntity, Long> {

	VoterDetailsEntity findByCandidateId(int candidateId);

	VoterDetailsEntity findByVoterId(int voterId);

	VoterDetailsEntity findByVote(int i);

}
