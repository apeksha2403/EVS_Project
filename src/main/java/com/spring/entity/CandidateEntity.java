package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_candidate")
public class CandidateEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidate_id", length = 6)
	@Id
	private int candidateId;

	@Column(name = "Name")
	private String name;

	@Column(name = "election_id")
	private int electionId;

	@Column(name = "party_id")
	private int partyId;

	@Column(name = "District")
	private String district;

	@Column(name = "Constituency")
	private String constituency;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "mobile_no")
	private int mobileNo;

	@Column(name = "Address")
	private String address;

	@Column(name = "email_id")
	private String emailId;

	
	public CandidateEntity() {
		super();
	}

	public CandidateEntity(int candidateId, String name, int electionId, int partyId, String district,
			String constituency, LocalDate dateOfBirth, int mobileNo, String address, String emailId) {
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

	public CandidateEntity(String name, int electionId, int partyId, String district, String constituency,
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
		return "CandidateEntity [candidateId=" + candidateId + ", name=" + name + ", electionId=" + electionId
				+ ", partyId=" + partyId + ", district=" + district + ", constituency=" + constituency
				+ ", dateOfBirth=" + dateOfBirth + ", mobileNo=" + mobileNo + ", address=" + address + ", emailId="
				+ emailId + "]";
	}
	
	
}
