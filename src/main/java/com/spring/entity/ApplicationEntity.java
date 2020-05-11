package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_application")
public class ApplicationEntity {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn( name = "user_id")
    @Id
	private int userId;
	
	@Column( name = "Constituency", length= 20)
	private  String constituency;
	
	@Column( name = "passed_status", length= 2)
	private int passedStatus; 
	
	@Column( name = "approved_status", length= 2)
	private int approvedStatus;
	
	@Column( name = "voter_id", length= 8)
	private int voterid;
	
	public ApplicationEntity() {
		super();
	}
	
	public ApplicationEntity(String constituency, int approvedStatus, int voterId) {
		super();
		this.constituency = constituency;
		this.approvedStatus = approvedStatus;
		this.voterid = voterId;
	}

	public ApplicationEntity(int userId, String constituency, int passedStatus, int approvedStatus, int voterId) {
		super();
		this.userId = userId;
		this.constituency = constituency;
		this.passedStatus = passedStatus;
		this.approvedStatus = approvedStatus;
		this.voterid = voterId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
		return voterid;
	}
	public void setVoterId(int voterId) {
		this.voterid = voterId;
	}
	@Override
	public String toString() {
		return "Application [userId=" + userId + ", constituency=" + constituency + ", passedStatus=" + passedStatus
				+ ", approvedStatus=" + approvedStatus + ", voterId=" + voterid + "]";
	}
	
}

