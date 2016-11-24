package com.parvin.LinkedLists;
/**
 * Rotate a Linked List
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes. 
 * Where k is a given positive integer. For example, if the given linked list is 
 * 10->20->30->40->50->60 and k is 4, the list should be modified to 50->60->10->20->30->40. 
 * Assume that k is smaller than the count of nodes in linked list.
 */
public class LinkedListRotation {
//Find the (k-1)th node
//Make the Kth Node as new head node
//Continue to Iterate to the end of the list, and point the tail node to original head. 
//Make the (k-1)th node as new tail node
	
	private static LinkedListNode rotateList(LinkedListNode head, int k){
		if(head==null){
			return head;
		}
		LinkedListNode current = head;
		LinkedListNode kthNode;
		LinkedListNode newHead;
		while(k>1 && current.next!=null){
			current = current.next;
			k--;
		}
		if(current == null) return head;
		
		kthNode = current; // in the above example, current points to 40.
		newHead = kthNode.next;//K+1th node
		kthNode.next = null;//making it the tail node
		
		while(current.next!=null){
			current = current.next;
		}
		current.next = head;//attach the original head to the original tailNode
		return newHead;
		}
}
