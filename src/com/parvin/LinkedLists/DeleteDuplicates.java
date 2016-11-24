package com.parvin.LinkedLists;
import java.util.HashSet;


public class DeleteDuplicates {

	private static void deleteDup(LinkedListNode n){
		//This code runs in O(1) space but O(N^2) time.
		if(n == null) return;
		LinkedListNode current = n;
		while (current != null){
			LinkedListNode runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	private static void deleteDupsSet(LinkedListNode n){
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while(n!=null){
			if(set.contains(n.data)){
				previous.next = n.next;
			}else{
				set.add(n.data);
				previous = n;
			}
			n= n.next;
		}
	}
}



