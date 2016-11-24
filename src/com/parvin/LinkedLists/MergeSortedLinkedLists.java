package com.parvin.LinkedLists;



public class MergeSortedLinkedLists {

//Add two sorted lists into one	
	private LinkedListNode mergeSortedLists(LinkedListNode list1, LinkedListNode list2){
		LinkedListNode resultList = null;
		 if(list1==null && list2!=null){
			 return list2;
		 }
		 if(list2==null && list1!=null){
			 return list1;
		 }
		 if(list1==null && list2==null){
			 return resultList;
		 }
		 while(list1!=null || list2!=null){
			 if(list1.data > list2.data){
				 resultList = list1;
				 list1 = list1.next;
			 }else if(list1.data == list2.data){
				 resultList = list1;
				 list1 = list1.next;
				 list2 = list2.next;
			 }else{
				 resultList = list2;
				 list2 = list2.next;
			 }
			 resultList = resultList.next;
		 }
		 if(list1!=null){
			 resultList.next = list1;
		 }else{
			 resultList.next = list2;
		 }
		 return resultList;
	}
}
