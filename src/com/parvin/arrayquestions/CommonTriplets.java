package com.parvin.arrayquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CommonTriplets {
	
	//Given a log file of user_id, timestamp & page visited find the n most common triplets,
	//where a triplet is an occurrence of 3 pages visited sequentially by 
	//the same user.
	//logFile is provided in the format-
	// Timestamp|UserID|Page
	public static void main(String args[]) {
		String[] input = {"1|30|/login",
		 "2|30|/orders",
		 "3|30|/rates", 
		 "4|22|/login", 
		 "5|22|/orders",
		 "6|22|/rates",
		 "7|22|/logout",
		 "8|30|/label",
		 "9|22|/login"};
		int n=10;
		String[][] result = findMostCommonTriplets(input, n);
		String[][] filtered = Arrays.stream(result).filter(r -> r[0]!= null).toArray(String[][] :: new);
		for(String[] s: filtered) {
			System.out.println(s[0] + "," + s[1]);
		}
	}
	
	private static String[][] findMostCommonTriplets(String[] log_lines, int n) {

	    HashMap<Integer, LinkedList<String>> freqMap = new HashMap<>();
	    //frequency Map
	    for(String s: log_lines){
	        //1|30|/login
	        String[] a = s.split("\\|");
	        LinkedList<String> pages = freqMap.getOrDefault(Integer.valueOf(a[1]), new LinkedList<String>());
	        pages.add(a[2]);
	        freqMap.put(Integer.valueOf(a[1]), pages);
	    } //O(N)
	    
	    // PriorityQueue<StringFreq> minHeap = 
	    //         new PriorityQueue<StringFreq>((a,b) -> a.freq - b.freq);
	    HashMap<String, Integer> pageFreq = new HashMap<>();
	    
	    for(Map.Entry<Integer, LinkedList<String>> entry :
	                        freqMap.entrySet()){
	        LinkedList<String> temp = entry.getValue();
	        StringBuffer buff = new StringBuffer();
	        //Login Orders Rates Logout Login
	        // string: login, orders, rates || string: orders, Rates, logout
	        
	        for(int i=0; i<=temp.size()-3; i++){ // i = 0
	        	int c = 1;
	            buff.append(temp.get(i));
	            for(int j=i+1; j<temp.size(); j++){
	                buff.append(temp.get(j));
	                c +=1;
	                if(c==3){
	                    String currString = buff.toString();
	                    pageFreq.put(currString, pageFreq.getOrDefault(currString, 0)+1);
	                    
	                    buff = new StringBuffer();
	                    break;
	                }
	            }
	        }//list.szie()=k  O(k-3)^2 ->  O(N.k^2)
	    }
	    
	    List<Map.Entry<String, Integer>> entries = new ArrayList<>(pageFreq.entrySet());
	    
	    Collections.sort(entries, (a, b) -> b.getValue() - a.getValue());//O(NlogN)    windw: W  O(NlogW)
	    String[][] result = new String[n][2];
	    int i = 0;
	    for(Map.Entry<String, Integer> e: entries){
	        result[i][0] = e.getKey();
	        result[i][1] = String.valueOf(e.getValue());
	        i++;
	        if(i==n){
	            break;
	        }
	    }
	    return result;
	}
}
/////

/*
 * ["1|30|/login",
"2|30|/orders",
"3|30|/rates", 
"4|22|/login", 
"5|22|/orders",
"6|22|/rates",
"7|22|/logout",
"8|30|/label",
"9|22|/login"]

[["/login/orders/rates","2"], 
 ["/rates/logout/login","1"], 
 ["/orders/rates/logout","1"], 
 ["/orders/rates/label","1"]]
 */

//O(NK^2) + O(NlogN) -> O(NK^2)


/*
["1|30|/login",
"2|30|/orders",
"3|30|/rates", 
"4|22|/login", 
"5|22|/orders",
"6|22|/rates",
"7|22|/logout",
"8|30|/label",
"9|22|/login"]

Map<Integer, LinkedList<String>>
user -> Login Orders Rates
30 - Login Orders Rates Label
22 - Login Orders Rates Logout Login
20 - Login Rates Logout Login

Login/Orders/Rates/Logout/Login
Login/Orders/Rates/Label
Login/Rates/Logout/Login


Login/Orders/Rates -2
Orders/Rates/Logout -1
Login/Rates/Logout -1


*/
