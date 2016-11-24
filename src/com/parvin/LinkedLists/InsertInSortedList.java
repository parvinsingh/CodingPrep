package com.parvin.LinkedLists;


public class InsertInSortedList {

//	1) If Linked list is empty then make the node as head and return it.
//			2) If value of the node to be inserted is smaller than value of head node
//			    then insert the node at start and make it head.
//			3) In a loop, find the appropriate node after which the input node (let 9) is
//			    to be inserted. To find the appropriate node start from head, keep moving 
//			    until you reach a node GN (10 in the below diagram) who's value is 
//			    greater than the input node. The node just before GN is the appropriate
//			    node (7).
//			4) Insert the node (9) after the appropriate node (7) found in step 3.
	
	private LinkedListNode insertNewNode(LinkedListNode head, int data){
		if(head==null || data <= head.data){
			LinkedListNode newHead = new LinkedListNode(data);
			newHead.next = head;
			return newHead;
		}else{
			LinkedListNode current = head;
			while(current.next!=null && current.next.data < data){ 
				current = current.next;
			}
			LinkedListNode newNode = new LinkedListNode(data);
			newNode.next = current.next;
			current.next = newNode;
			return head;
		}
	}

}
