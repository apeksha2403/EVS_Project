package com.spring.json;

import java.time.LocalDate;

public class Candidate {
	private int candidateId;
	private String name;
	private int electionId;
	private int partyId;
	private String district;
	private String constituency;
	private LocalDate dateOfBirth;
	private int mobileNo;
	private String address;
	private String emailId;
	public Candidate() {
		super();
	}
	public Candidate(int candidateId, String name, int electionId, int partyId, String district, String constituency,
			LocalDate dateOfBirth, int mobileNo, String address, String emailId) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		this.electionId = electionId;
		this.partyId = partyId;
		this.district = district;
		this.constituency = constituency;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.address = address;
		this.emailId = emailId;
	}
	public Candidate(String name, int electionId, int partyId, String district, String constituency,
			LocalDate dateOfBirth, int mobileNo, String address, String emailId) {
		super();
		this.name = name;
		this.electionId = electionId;
		this.partyId = partyId;
		this.district = district;
		this.constituency = constituency;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.address = address;
		this.emailId = emailId;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", name=" + name + ", electionId=" + electionId + ", partyId="
				+ partyId + ", district=" + district + ", constituency=" + constituency + ", dateOfBirth=" + dateOfBirth
				+ ", mobileNo=" + mobileNo + ", address=" + address + ", emailId=" + emailId + "]";
	}
	
	
}
