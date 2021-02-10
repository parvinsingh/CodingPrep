package com.parvin.interviewprep;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchData2{
	@JsonProperty("team1")
	private String team1;
	@JsonProperty("team2")
	private String team2;
	@JsonProperty("competition")
	private String competition;
	@JsonProperty("year")
	private String year;
	@JsonProperty("round")
	private String round;
	@JsonProperty("team1goals")
	private String team1goals;
	@JsonProperty("team2goals")
	private String team2goals;
	
	public MatchData2() {
	}
	
	public MatchData2(String team1, String team2) {
		team1 = team1;
		team2 = team2;
	}
	
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
}
