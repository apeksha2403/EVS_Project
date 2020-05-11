package com.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;

public interface ElectionRepository extends JpaRepository<ElectionEntity, Long>  {

	ElectionEntity findByElectionId(int electionId);

	Object save(PartyEntity party);

	List<ElectionEntity> findByElectionDateGreaterThan(LocalDate date);

	Object save(List<ElectionEntity> electionEntity);

}
