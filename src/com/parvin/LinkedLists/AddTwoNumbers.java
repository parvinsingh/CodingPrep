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
		// 234 + 846 -> 432  648
		Node head1 = new Node(4);
		head1.next = new Node(3);
		head1.next.next = new Node(2);

		Node head2 = new Node(6);
		head2.next = new Node(4);
		head2.next.next = new Node(8);

		Node result = addTwoLists(head1, head2);
		StringBuffer buff = new StringBuffer();
		while(result!=null) {
			buff.append(result.data);
			result=result.next;
		}
		System.out.println(buff.reverse().toString());
		
		Node result2 = addTwoLists(head1, head2);
		StringBuffer buff2 = new StringBuffer();
		while(result2!=null) {
			buff2.append(result2.data);
			result2=result2.next;
		}
		System.out.println(buff2.reverse().toString());
	}

	public static Node addTwoNumbers(Node l1, Node l2) {
		int carry = 0;
		return addNumbers(l1, l2, carry, null, null, null);
	}
	
	//432  648
	private static Node addNumbers(Node l1, Node l2, int carry, Node temp, Node prev, Node result) {
		while(l1 != null || l2 != null) {
			int d1 = l1 == null ? 0 : l1.data;
			int d2 = l2 == null ? 0 : l2.data;
			int sum = d1 + d2 + carry;
			carry = (sum >= 10) ? 1 : 0;
			sum = sum%10;
			temp = new Node(sum);
			
			if (result == null) {
				result = temp;//0
			} else {
				prev.next = temp;
			}
			prev = temp;
			
			if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
		}
		
		if(carry > 0) {
			temp.next = new Node(carry);
		}
		
		return result;
	}
	
	private static Node addTwoLists(Node first, Node second)
    {
        // res is head node of the resultant list
        Node res = null;
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;
 
        // while both lists exist
        while (first != null || second != null) {
           
            sum = carry + (first != null ? first.data : 0)
                  + (second != null ? second.data : 0);
 
            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;
 
            // update sum if it is greater than 10
            sum = sum % 10;
 
            // Create a new node with sum as data
            temp = new Node(sum);
 
            // if this is the first node then set
            // it as head of the resultant list
            if (res == null) {
                res = temp;
            }
 
            // If this is not the first
            // node then connect it to the rest.
            else {
                prev.next = temp;
            }
 
            // Set prev for next insertion
            prev = temp;
 
            // Move first and second pointers
            // to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
 
        if (carry > 0) {
            temp.next = new Node(carry);
        }
 
        // return head of the resultant list
        return res;
    }
	
	private static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }
}
