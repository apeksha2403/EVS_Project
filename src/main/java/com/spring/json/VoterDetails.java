package com.spring.json;

public class VoterDetails {
      private int serialNo;
      private int electionId;
      private int candidateId;
      private int voterId;
      private int vote;
	public VoterDetails() {
		super();
	}
	public VoterDetails(int serialNo, int electionId, int candidateId, int voterId, int vote) {
		super();
		this.serialNo = serialNo;
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voterId = voterId;
		this.vote = vote;
	}
	public VoterDetails(int electionId, int candidateId, int voterId, int vote) {
		super();
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
