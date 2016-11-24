package com.parvin.interviewprep;

import java.util.ArrayList;

public class OrgEmployee {

	private int id;
	private String name;
	
	public OrgEmployee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	private int getEmployeeId(){
		return id;
	}
	
	private String getEmployeeName(){
		return name;
	}
	
	private ArrayList getReports(){
		return null;
	}
}
