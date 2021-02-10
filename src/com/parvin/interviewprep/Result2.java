package com.parvin.interviewprep;

import java.util.Scanner;

//HackerRank API test Quesiton-2

public class Result2 {

	public static void main(String args[]) {
		long startTime = System.nanoTime();
		int result = getNumDraws(2011);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		System.out.println(result);
	}
	
    /*
     * Complete the 'getNumDraws' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER year as parameter.
     */
    public static int getNumDraws(int year){
        String param = "team1goals=%d&team2goals=%d"; //this param filter makes the api call faster
        int draws = 0;
        for(int i=0; i<=10; i++){
            draws += getNumDrawsWithGoalsParam(year, String.format(param, i, i));
        }
        return draws;
    }
    
    public static int getNumDrawsWithGoalsParam(int year, String param)
    {
        String baseUrl = "https://jsonmock.hackerrank.com/api/football_matches?year=%d&%s&page=%d";
        int pageNum = 1;
        int totalDraws = 0;
        long totalPages = 0;
        int drawMatches = 0;
        try{
            do{
                String testUrl = String.format(baseUrl, year, param, pageNum);
                String response = makeApiCall(testUrl);
                
                Object parse = org.json.simple.JSONValue.parse(response);
                org.json.simple.JSONObject obj = (org.json.simple.JSONObject)parse;
                
                org.json.simple.JSONArray matchData = (org.json.simple.JSONArray) obj.get("data");
                totalPages = (Long) obj.get("total_pages"); // total number of pages
                
                long perPage = (Long) obj.get("per_page");
                long totalMatches = (Long) obj.get("total");
                
                
                //System.out.println("perPage="+perPage+"totalMatches="+totalMatches+"totalPages="+totalPages);
                drawMatches += findTotalDrawsOnPage(matchData);
                
                pageNum++;
            }while(pageNum <= totalPages);
            
            return drawMatches;    
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return drawMatches;
    }
    
    private static int findTotalDrawsOnPage(org.json.simple.JSONArray matchData){
        int draws = 0;
        for(int i=0; i<matchData.size(); i++){
            org.json.simple.JSONObject data = (org.json.simple.JSONObject) matchData.get(i);
            String t1Goals = (String) data.get("team1goals");
            String t2Goals = (String) data.get("team2goals");
            
            if(Integer.valueOf(t1Goals) == Integer.valueOf(t2Goals)){
                draws++;
            }
        }
        return draws;
    }
    
    private static String makeApiCall(String url) throws java.net.MalformedURLException, java.io.IOException{
        java.net.URL apiUrl = new java.net.URL(url);
        
        java.net.HttpURLConnection connection = (java.net.HttpURLConnection) apiUrl.openConnection();
        
        connection.setRequestProperty("accept", "application/json");
        String response = "";
        if(connection.getResponseCode() == 200){
            Scanner scanner = new Scanner (connection.getInputStream());
            while(scanner.hasNextLine()){
                response += scanner.next();
                response += "\n";
            }
            scanner.close();
        }
        return response;
    }

}
