package com.spring.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.PartyEntity;
import com.spring.json.Party;

@Repository
public interface PartyRepository extends JpaRepository<PartyEntity, Long> {
	List<PartyEntity> findByName(String name);

	void save(Set<PartyEntity> partyList);

	PartyEntity findByPartyId(int partyId);

}
