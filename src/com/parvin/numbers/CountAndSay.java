package com.parvin.numbers;

public class CountAndSay {
	
//	public static String SayTheInput(long input) { //555422333 -> /10
//		long ip=0;
//		while(input > 0) {
//			ip = input;
//			input /= 10;
//		}
//	}
	
	public static void main(String args[]) {
		String result = SayTheInputNum("555422333");
		System.out.println(result);
	}
	
	static String[] wordArr = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	
	public static String SayTheInputNum(String input) {
		int c = 1;
		StringBuffer buff = new StringBuffer();
		String prev = null;
		for(String s : input.split("")) {
			if(prev == null) {
				prev = s;
				continue;
			}
			if(prev.equals(s)) {
				c += 1;
			}else {
				buff.append(String.valueOf(c)).append("-").append(prev).append("s,");
				prev=s;
				c = 1;
			}
		}
		buff.append(String.valueOf(c)).append("-").append(prev).append("s,");
		return buff.toString();
	}

}
/*564
 *ip= 564/10 -> 56/10 -> 5
 * 
 * 
 */
