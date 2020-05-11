package com.spring.json;

public class Application {
	private int userid;
	private  String constituency;
	private int passedStatus; 
	private int approvedStatus;
	private int voterId;
	
	public Application() {
		super();
	}
	
	public Application(String constituency, int passedStatus, int approvedStatus, int voterId) {
		super();
		this.constituency = constituency;
		this.passedStatus = passedStatus;
		this.approvedStatus = approvedStatus;
		this.voterId = voterId;
	}

	public Application(int userId, String constituency, int passedStatus, int approvedStatus, int voterId) {
		super();
		this.userid = userId;
		this.constituency = constituency;
		this.passedStatus = passedStatus;
		this.approvedStatus = approvedStatus;
		this.voterId = voterId;
	}
	public int getUserId() {
		return userid;
	}
	public void setUserId(int userId) {
		this.userid = userId;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public int getPassedStatus() {
		return passedStatus;
	}
	public void setPassedStatus(int passedStatus) {
		this.passedStatus = passedStatus;
	}
	public int getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	public int getVoterId() {
		return voterId;
	}
	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}
	@Override
	public String toString() {
		return "Application [userId=" + userid + ", constituency=" + constituency + ", passedStatus=" + passedStatus
				+ ", approvedStatus=" + approvedStatus + ", voterId=" + voterId + "]";
	}
	
}
