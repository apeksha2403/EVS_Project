package com.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "evs_tbl_party")
public class PartyEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "party_id")
	@Id
	private int partyId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Leader")
	private String leader;
	
	@Column(name = "Symbol")
	private String symbol;
	
	@Column(name = "election_id")
	private int electionId;
    
	public PartyEntity() {
		super();
	}

	public PartyEntity(int partyid, String name, String leader, String symbol) {
		super();
		this.partyId = partyid;
		this.name = name;
		this.leader = leader;
		this.symbol = symbol;
		
	}

	public PartyEntity(String name, String leader, String symbol) {
		super();
		this.name = name;
		this.leader = leader;
		this.symbol = symbol;
		
	}

	public int getPartyid() {
		return partyId;
	}

	public void setPartyid(int partyid) {
		this.partyId = partyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeader() {
		return leader;
	}

	public int getElectionId() {
		return electionId;
	}

	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	

	@Override
	public String toString() {
		return "PartyEntity [partyid=" + partyId + ", name=" + name + ", leader=" + leader + ", symbol=" + symbol
				+ "]";
	}
	
    	
}
