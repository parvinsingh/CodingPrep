package com.parvin.interviewprep;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import org.json.JSONPropertyName;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;

//import org.json.JSONObject;
import org.json.simple.*; //library used in Hackerrank


public class Result {

    /*
     * Complete the 'getTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING team
     *  2. INTEGER year
     */
	
	public static void main(String args[]) {
		int result = getTotalGoals("Barcelona", 2011);
		System.out.println(result);
	}
	
	public static int getTotalGoals(String team, int year) {
		String team1 = "team1="+team;
    	String team2 = "team2="+team;
    	
    	return callApiAndGetTotalGoals(team1, year) + callApiAndGetTotalGoals(team2, year); 
	}
	
    public static int callApiAndGetTotalGoals(String team, int year) {
    	
        String baseUrl = "https://jsonmock.hackerrank.com/api/football_matches?year=%d&%s&page=%d";
        
        int currPage = 1;
        int totalGoals = 0;
        long totalPages = 0;
        Result r = new Result();
        try{
            do {
            	String testUrl = String.format(baseUrl, year, team, currPage);
            	System.out.println(testUrl);
            	
            	String response = makeApiCall(testUrl);
                
            	//JSON reading using fasterXML
            	ObjectMapper mapper = new ObjectMapper();
            	Soccer soccer = mapper.readValue(response, Soccer.class);
                
            	System.out.println(soccer.getTotal_pages());
            	
            	System.out.println("array length = " + soccer.getData().length);
            	
            	for(MatchData d : soccer.getData()) {
            		System.out.println("Team1 = " + d.getTeam1());
            	}
            	//JSON reading using fasterXML
            	
            	
            	Object parse = org.json.simple.JSONValue.parse(response);
                org.json.simple.JSONObject obj = (org.json.simple.JSONObject)parse; // entire response as object
                
        		Long total = (Long) obj.get("total"); //total items in array
        		org.json.simple.JSONArray matchData = (org.json.simple.JSONArray) obj.get("data"); //actual data
        		
        		String currPageNum = (String) obj.get("page"); //current page - not needed to be read
        		totalPages = (Long) obj.get("total_pages"); // total number of pages
        		int pageNum = Integer.parseInt(currPageNum);
        		System.out.println(String.format("currPage = %d, and pageNum = %d", currPage, pageNum));
        		    
                totalGoals = totalGoals + FindTotalGoals(matchData, team, total);
                currPage++;
                
            }while(currPage <= totalPages);
            
        }catch(JsonMappingException e){
            e.printStackTrace();
        }catch(JsonParseException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return totalGoals;
    }

	private static String makeApiCall(String testUrl) throws MalformedURLException, IOException {
		// Create a neat value object to hold the URL
		java.net.URL url = new java.net.URL(testUrl);

		// Open a connection(?) on the URL(??) and cast the response(???)
		java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();

		// Now it's "open", we can set the request method, headers etc.
		connection.setRequestProperty("accept", "application/json");
		
		String response = "";
		if(connection.getResponseCode() == 200){
		    Scanner scanner = new Scanner(connection.getInputStream());
		    while(scanner.hasNextLine()){
		        response += scanner.nextLine();
		        response += "\n";
		    }
		    scanner.close();
		}
		return response;
	}
    
// "page":"1","per_page":10,"total":6,"total_pages":1,"data"
	private static int FindTotalGoals(JSONArray matchData, String team, Long total) {
		int goals = 0;
		for(int i=0; i<total; i++) {
			goals = goals + retrieveAndAddGoals((JSONObject)matchData.get(i), team);
		}
		return goals;
	}

	private static int retrieveAndAddGoals(JSONObject object, String team) {
	
		String t1 = (String) object.get("team1");
		String t2 = (String) object.get("team2");
		
		String g1 = (String) object.get("team1goals");
		String g2 = (String) object.get("team1goals");
		
		if(team.contains(t1)) {
			return Integer.valueOf(g1);
		}else if(team.contains(t2)) {
			return Integer.valueOf(g2);
		}
	
		return 0;
	}
	
	static class Soccer{
		@JsonProperty("total")
		private int total;
		@JsonProperty("total_pages")
		private int total_pages;
		@JsonProperty("page")
		private String page;
		@JsonProperty("per_page")
		private String perPage;
		@JsonProperty("data")
		private MatchData[] data;
		
		public Soccer() {
			
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
		public MatchData[] getData() {
			return data;
		}
		public void setData(MatchData[] data) {
			this.data = data;
		}
	}
	
	static class MatchData{
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
		
		public MatchData() {
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
}