package Utilities;

public class PrintArrays {

	public static void printArray(int[] array) {
		String result = "";
		for(int i: array) {
			result = result + i + ", ";
		}
		System.out.print("{");
		System.out.print(result.substring(0, result.length()-1));
		System.out.println("}");
	}
	
	public static void printArray(char[] array) {
		String result = "";
		for(char i: array) {
			result = result + i + ", ";
		}
		System.out.print("{");
		System.out.print(result.substring(0, result.length()-1));
		System.out.println("}");
	}
	
	public static void printArray(String[] array) {
		String result = "";
		for(String i: array) {
			result = result + i + ", ";
		}
		System.out.print("{");
		System.out.print(result.substring(0, result.length()-1));
		System.out.println("}");
	}
	
	public static void printArray(boolean[] array) {
		String result = "";
		for(boolean i: array) {
			result = result + i + ", ";
		}
		System.out.print("{");
		System.out.print(result.substring(0, result.length()-1));
		System.out.println("}");
	}
}
