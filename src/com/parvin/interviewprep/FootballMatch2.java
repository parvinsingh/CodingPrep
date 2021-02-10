package com.parvin.interviewprep;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FootballMatch2{
	
	@JsonProperty("total")
	private int total;
	@JsonProperty("total_pages")
	private int total_pages;
	@JsonProperty("page")
	private String page;
	@JsonProperty("per_page")
	private String perPage;
	@JsonProperty("data")
	private MatchData2[] data;
	
	public FootballMatch2() {
		
	}
	
	public FootballMatch2(Long total, Long total_pages, String page) {
		total = total;
		total_pages = total_pages;
		page = page;
		//data = data;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public MatchData2[] getData() {
		return data;
	}
	public void setData(MatchData2[] data) {
		this.data = data;
	}
	
}
