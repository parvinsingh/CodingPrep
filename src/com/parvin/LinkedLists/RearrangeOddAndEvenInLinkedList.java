package com.parvin.LinkedLists;

public class RearrangeOddAndEvenInLinkedList {

	private static Node rearrange(Node head2){
		Node odd = head2;
		Node even = head2.next;
		
		Node tempEven = even; //temp node to keep the first node of the even list
		//10>20>30>50>70
		//10>30>70>20>50
		//O=70 E=50
		while(true){
			odd.next = even.next;
			odd = even.next;
			
			if(odd.next==null || even.next==null){	
				odd.next = tempEven;
				even.next = null;
				break;
			}
			
			even.next = odd.next;
			even = odd.next;
		}
		return head2;
	}
	
	static Node head;  // head of list
	  
    /* Node Class */
    static class Node {
 
        int data;
        Node next;
 
        // Constructor to create a new node
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    void printlist(Node node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }
 
    Node reverselist(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        System.out.println("");
        printlist(node);
        return node;
    }
	
	public static void main(String[] args) {
		 
		RearrangeOddAndEvenInLinkedList list = new RearrangeOddAndEvenInLinkedList();
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = new Node(40);
        list.head.next.next.next.next = new Node(50);
 
        list.printlist(head); // print original list
        list.reverselist(head);
       // list.rearrange(head); // rearrange list as per ques
        System.out.println("");
       // list.printlist(head); // print modified list
 
    }
}
