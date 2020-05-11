package com.spring.json;

import java.time.LocalDate;

public class Election {
	private int electionId;
	private String name;
	private LocalDate electionDate;
	private String district;
	private String constituency;
	private LocalDate countingDate;

	public Election() {
		super();
	}

	public Election(int electionid, String name, LocalDate electionDate, String district, String constituency,
			LocalDate countingDate) {
		super();
		this.electionId = electionid;
		this.name = name;
		this.electionDate = electionDate;
		this.district = district;
		this.constituency = constituency;
		this.countingDate = countingDate;
	}

	public int getElectionid() {
		return electionId;
	}

	public void setElectionid(int electionid) {
		this.electionId = electionid;
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

	@Override
	public String toString() {
		return "Election [electionid=" + electionId + ", name=" + name + ", electiondate=" + electionDate
				+ ", district=" + district + ", constituency=" + constituency + ", countingdate=" + countingDate + "]";
	}

}
