package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_voter_details")
public class VoterDetailsEntity {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column()
	private int serialNo;

	@Column()
	private int electionId;

	@Column()
	private int candidateId;

	@Column()
	private int voterId;

	@Column()
	private int vote;

	public VoterDetailsEntity() {
		super();
	}

	public VoterDetailsEntity(int electionId, int candidateId, int voterId, int vote) {
		super();
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voterId = voterId;
		this.vote = vote;
	}

	public VoterDetailsEntity(int serialNo, int electionId, int candidateId, int voterId, int vote) {
		super();
		this.serialNo = serialNo;
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voterId = voterId;
		this.vote = vote;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getElectionId() {
		return electionId;
	}

	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}
	
	
}
