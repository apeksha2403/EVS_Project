package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_result")
public class ResultEntity {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "serial_no")
	private int serialNo;
	
	@Column(name = "election_id")
	private int  electionId;
	
	@Column(name = "candidate_id")
	private int candidateId;
	
	@Column(name = "vote_count")
	private int voteCount;
	
	@Column(name = "result_status")
	private int resultStatus;
	
	public long getSerialno() {
		return serialNo;
	}
	public void setSerialno(int serialno) {
		this.serialNo = serialno;
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
	public long getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public long getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}
	public ResultEntity() {
		super();
	}
	public ResultEntity(int serialno, int electionId,int  candidateId, int voteCount, int resultStatus) {
		super();
		this.serialNo = serialno;
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}
	public ResultEntity(int electionId, int candidateId, int voteCount, int resultStatus) {
		super();
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}
	@Override
	public String toString() {
		return "ResultEntity [serialno=" + serialNo + ", electionId=" + electionId + ", candidateId=" + candidateId
				+ ", voteCount=" + voteCount + ", resultStatus=" + resultStatus + "]";
	}


}
