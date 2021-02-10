package HackerRank2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// given a list of products with cost and score, return a sorted list

public class ProductComparator2 implements Comparable<Object>{

	private String name;
	private long cost;
	private int popularityScore;
	
	public ProductComparator2(String name, long cost, int score) {
		this.name = name;
		this.cost = cost;
		this.popularityScore = score;
	}
	
	@Override
	public int compareTo(Object o) {
		ProductComparator2 pc = (ProductComparator2) o;
		if(this.name == pc.name) {
			if(pc.popularityScore == pc.popularityScore) {
				return (pc.cost < this.cost) ? -1 : 1;
			}else {
				return (pc.popularityScore < pc.popularityScore) ? -1 : 1;
			}
		}else {
			return pc.name.compareToIgnoreCase(this.name);
		}
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
	    int testCases = 5; //Integer.parseInt(in.nextLine());
	    
	    List<ProductComparator2> productList = new ArrayList<ProductComparator2>();
	    
    	productList.add(new ProductComparator2("ab", 20, 1));
    	productList.add(new ProductComparator2("op", 10, 4));
    	productList.add(new ProductComparator2("op", 17, 4));
    	productList.add(new ProductComparator2("xy", 5, 3));
    	productList.add(new ProductComparator2("ab", 35, 2));
//	    while(testCases > 0) {
//	    	String name = in.next();
//	    	long cost = in.nextLong();
//	    	int score = in.nextInt();
//	    	
//	    	ProductComparator2 product = new ProductComparator2(name, cost, score);
//	    	productList.add(product);
//	    	
//	    	testCases--;
//	    }
	    
	    Collections.sort(productList);
	    for(ProductComparator2 p : productList) {
	    	System.out.println(p.name);
	    }
	    
	}

}
