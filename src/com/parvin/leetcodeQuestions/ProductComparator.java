package com.parvin.leetcodeQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductComparator implements Comparable<Object> {
	private String prodName;
	private String popularityScore;
	private int price;
	
	public ProductComparator(String name, String score, int price) {
		super();
		this.prodName = name;
		this.popularityScore = score;
		this.price = price;
	}

	@Override
	public int compareTo(Object o) {
		ProductComparator p = (ProductComparator) o;
		if(this.prodName == p.prodName) {
			if(this.popularityScore == p.popularityScore) {
				return (p.price < this.price) ? -1: 1;
			}else {
				return (Integer.valueOf(p.popularityScore) < Integer.valueOf(this.popularityScore)) ? -1:1 ;
			}
		}else {
			return this.prodName.compareToIgnoreCase(p.prodName);
		}
	}

	public String getProdName() {
		return prodName;
	}

	public String getPopularityScore() {
		return popularityScore;
	}

	public int getPrice() {
		return price;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args){
	      Scanner in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      
	      List<ProductComparator> productList = new ArrayList<ProductComparator>();
	      while(testCases>0){
	         String pname = in.next();
	         String score = in.next();
	         int price = in.nextInt();
	         
	         ProductComparator product = new ProductComparator(pname, score, price);
	         productList.add(product);
	         
	         testCases--;
	      }
	      	Collections.sort(productList);
	         for(ProductComparator prod: productList){
	         System.out.println(prod.getProdName());
	      }
	   }
}
