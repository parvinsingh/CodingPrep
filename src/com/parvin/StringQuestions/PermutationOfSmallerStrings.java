package com.parvin.StringQuestions;

/**
 * Given a list of words, and a bigger string, how can we find
 * whether the string is a permutation of the smaller strings
 * dictionary = { acting, good, bad, actor, }
 * badactorgoodact : notconstructible
 * badactorgoodacting : constructible (bad actor good acting)
 * badactorbadacting : notconstructible
 * @author ppanesar
 *
 */
public class PermutationOfSmallerStrings {

	public static void main(String args[]){
		String[] input = {"good","acting","bad","actor","actress"};
		String bigString = "badactorgoodacting";
		checkPermutation(input, bigString);
	}
	
	private static void checkPermutation(String[] words, String bigString){
		boolean isPermutation = true;
		for(String word: words){
			bigString = checkIfExistsAndMove(word, bigString);
			if(bigString !="" && bigString.equals("NotExist")){
				isPermutation = false;
			}
		}
		System.out.println(isPermutation);
	}

	private static String checkIfExistsAndMove(String word, String bigString) {
		if(bigString!=null && bigString.contains(word)){
			return bigString.replaceFirst(word, "");
		}
		return "NotExist";
	}
}
