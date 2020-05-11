package com.spring.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_election")
public class ElectionEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "election_id")
	@Id
	private int electionId;

	@Column(name = "Name")
	private String name;

	@Column(name = "election_date")
	private LocalDate electionDate;

	@Column(name = "District")
	private String district;

	@Column(name = "Constituency")
	private String constituency;

	@Column(name = "counting_date")
	private LocalDate countingDate;

	//@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity=PartyEntity.class)
	//private Set<PartyEntity> partyEntityList;

//	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "election_id")
	//private Set<CandidateEntity> candidateEntityList;
	
	public int getElectionid() {
		return electionId;
	}

	public void setElectionid(int electionid) {
		this.electionId = electionid;
	}

	public int getElectionId() {
		return electionId;
	}

	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}

	public LocalDate getElectiondate() {
		return electionDate;
	}

	public void setElectiondate(LocalDate electiondate) {
		this.electionDate = electiondate;
	}

	public LocalDate getCountingdate() {
		return countingDate;
	}

	public void setCountingdate(LocalDate countingdate) {
		this.countingDate = countingdate;
	}

	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getElectionDate() {
		return electionDate;
	}

	public void setElectionDate(LocalDate electionDate) {
		this.electionDate = electionDate;
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

	public LocalDate getCountingDate() {
		return countingDate;
	}

	public void setCountingDate(LocalDate countingDate) {
		this.countingDate = countingDate;
	}

	public ElectionEntity(int electionid, String name, LocalDate electionDate, String district, String constituency,
			LocalDate countingDate) {
		super();
		this.electionId = electionid;
		this.name = name;
		this.electionDate = electionDate;
		this.district = district;
		this.constituency = constituency;
		this.countingDate = countingDate;
	}

	public ElectionEntity(String name, LocalDate electionDate, String district, String constituency,
			LocalDate countingDate) {
		super();
		this.name = name;
		this.electionDate = electionDate;
		this.district = district;
		this.constituency = constituency;
		this.countingDate = countingDate;
	}

	public ElectionEntity() {
		super();
	}

	@Override
	public String toString() {
		return "ElectionEntity [electionid=" + electionId + ", name=" + name + ", electiondate=" + electionDate
				+ ", district=" + district + ", constituency=" + constituency + ", countingdate=" + countingDate + "]";
	}

}
