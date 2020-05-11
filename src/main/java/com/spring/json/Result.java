package com.spring.json;

public class Result {
	private int serialNo;
	private int electionId;
	private int candidateId;
	private int voteCount;
	private int resultStatus;
	public int getSerialno() {
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
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public int getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}
	public Result() {
		super();
	}
	public Result(int serialno, int electionId, int candidateId, int voteCount, int resultStatus) {
		super();
		this.serialNo = serialno;
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}
	public Result(int electionId, int candidateId, int voteCount, int resultStatus) {
		super();
		this.electionId = electionId;
		this.candidateId = candidateId;
		this.voteCount = voteCount;
		this.resultStatus = resultStatus;
	}
	@Override
	public String toString() {
		return "Result [serialno=" + serialNo + ", electionId=" + electionId + ", candidateId=" + candidateId
				+ ", voteCount=" + voteCount + ", resultStatus=" + resultStatus + "]";
	}

}
