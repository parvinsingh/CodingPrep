package com.parvin.interviewprep;

import java.util.HashMap;

public class DomainCounts {

	public static void main(String[] args) {
		String[] domainCounts = {
				"250, discuss.leetcode.com",
				"900, yahoo.com",
				"600, google.com",
				"540, sports.yahoo.com",
				"420, yahoo.co.uk",
				"400, leetcode.com",
				"50, my.sports.yahoo.co.uk"};
		HashMap<String, Integer> dMap = calculateDomainCount(domainCounts);
		for(String str: dMap.keySet()) {
			System.out.println(str + "--" + dMap.get(str));
		}
	}

	private static HashMap<String, Integer> calculateDomainCount(String[] domainCounts) {
		HashMap<String, Integer> domainMap = new HashMap<String, Integer>();
		
		for(String str : domainCounts) {
			String[] domainsAndCounts = str.split(",");
			int count = Integer.valueOf(domainsAndCounts[0]);
			String originalDomain = domainsAndCounts[1].trim();
			
			if(domainMap.containsKey(originalDomain)) {
				int c = domainMap.get(originalDomain);
				domainMap.put(originalDomain, c+count);
			}else {
				domainMap.put(originalDomain, count);
			}
			
			while(originalDomain.indexOf(".") != -1) {
				String sd = originalDomain.substring(0, originalDomain.indexOf(".")+1);
				originalDomain = originalDomain.replace(sd, "");
				if(domainMap.containsKey(originalDomain)) {
					int c = domainMap.get(originalDomain);
					domainMap.put(originalDomain, c+count);
				}else {
					domainMap.put(originalDomain, count);
				}
				
			}
		}
		return domainMap;
	}
}
