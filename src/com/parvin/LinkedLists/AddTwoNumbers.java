package com.parvin.LinkedLists;

import java.util.LinkedList;

import com.parvin.LinkedLists.LinkedList.Node;

public class AddTwoNumbers {
	static Node head1, head2; 
	  
    static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
    
	public static void main(String[] args) {
		//34 + 46
		AddTwoNumbers llist1 = new AddTwoNumbers();
		llist1.head1 = new Node(3);
		llist1.head1.next = new Node(4);
		
		AddTwoNumbers llist2 = new AddTwoNumbers();
		llist2.head2 = new Node(4);
		llist2.head2.next = new Node(6);
		
		AddTwoNumbers result = addTwoNumbers(llist1, llist2);
		System.out.println(result);
	}

	 public static AddTwoNumbers addTwoNumbers(AddTwoNumbers l1, AddTwoNumbers l2) {
		 AddTwoNumbers result = new AddTwoNumbers();
	        int carry = 0;
	        addNumbers(l1,l2,carry,result);
	        return result;
	    }
	    
	    private static AddTwoNumbers addNumbers(AddTwoNumbers l1, AddTwoNumbers l2, int carry, AddTwoNumbers result){
	        if(l1 == null && l2 == null){
	            if(carry > 0){
	                result.next = new LinkedListNode(carry);
	            }
	            return result;
	        }
	        int d1 = l1 == null ? 0 : l1.data;
	        int d2 = l2 == null ? 0 : l2.data;
	        int s = d1 + d2 + carry;
	        LinkedListNode sum = new LinkedListNode(s%10);
	        if(result == null){
	            result = sum;
	        }else{
	            result.next = sum;
	        }
	        return addTwoNumbers(l1.next, l2.next, s/10, result);
	    }
}
