package HackerRank2;

import java.util.HashMap;

public class CountDomains {

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
		HashMap<String, Integer> dCount = new HashMap<>();
		
		for(String d : domainCounts) {
			String[] temp = d.split(",");
			
			int count = Integer.valueOf(temp[0]);
			String domain = temp[1];
			
			putInMap(domain, count, dCount);
			while(domain.indexOf(".") != -1) {
				domain = domain.substring(domain.indexOf(".")+1, domain.length());
				putInMap(domain, count, dCount);
			}
		}
		return dCount;
	}
	
	private static void putInMap(String str, int count, HashMap<String, Integer> dCount) {
		str = str.trim();
		if(dCount.containsKey(str)) {
			int c = dCount.get(str);
			count  = c + count;
		}
		dCount.put(str, count);
	}
}
