package com.spring.json;

public class Party {
	private int partyId;
	private String name;
	private String leader;
	private String symbol;
	private Election election;
	public Party() {
		super();
	}
	public Party(int partyId, String name, String leader, String symbol) {
		super();
		this.partyId = partyId;
		this.name = name;
		this.leader = leader;
		this.symbol = symbol;
		
	}
	public Party(String name, String leader, String symbol) {
		super();
		this.name = name;
		this.leader = leader;
		this.symbol = symbol;
		
	}
	
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
	public Election getElection() {
		return election;
	}
	public void setElection(Election election) {
		this.election = election;
	}
	@Override
	public String toString() {
		return "Party [partyId=" + partyId + ", name=" + name + ", leader=" + leader + ", symbol=" + symbol
				+  "]";
	}
	
	

}
