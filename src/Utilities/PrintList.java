package Utilities;

import java.util.ArrayList;

public class PrintList {

	public static <T extends Iterable<E>, E> void print(T list){
		String result = "";
        for (Object element : list){
        	result = result + (element + ",");
        }
        System.out.print("{");
		System.out.print(result.substring(0, result.length()-1));
		System.out.println("}");
    }
	
//	public static void main(String[] args) {
//        ArrayList<Integer> l = new ArrayList<>();
//        l.add(1);
//        l.add(5);
//        l.add(3);
//        l.add(2);
//        print(l);
//        ArrayList<String> s = new ArrayList<>();
//        s.add("Parvin");
//        s.add("Sohila");
//        s.add("Jaspreet");
//        print(s);
//    }
}
