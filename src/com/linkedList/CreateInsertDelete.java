package com.linkedList;

public class CreateInsertDelete {
	public static void traverseList(Node head) {
		while (head != null) {
			System.out.println(head.data + " ");
			head = head.next;
		}
		System.out.println("<-------------->");
	}

	private static void insert(Node head, int data, int position) {
		Node toAdd = new Node(data);
		if (position == 0) {
			toAdd.next = head;
			head = toAdd;
			return;
		}
		Node prev = head;
		for (int i = 0; i < position - 2; i++) {
			prev = prev.next;
		}
//		System.out.println(prev.data);

		toAdd.next = prev.next;
		prev.next = toAdd;

		traverseList(head);
	}
	

	private static void delete(Node head, int position) {
		if(position==0) {
			head=head.next;
			return;
		}
		Node prev = head;
		for(int i=0;i<position-2;i++) {
			prev=prev.next;
		}
//		System.out.println(prev.data);
		prev.next=prev.next.next;
		
		traverseList(head);
	}
	
	private static void reverse(Node head) {
		Node current = head;
		Node prev = null;
		while(current!=null) {
			Node temp = current.next;
			current.next=prev;
			prev=current;
			current=temp;
		}
		traverseList(prev);
		
	}

	public static void main(String[] args) {
		// Create a hard-coded linked list:
		// 10 -> 20 -> 30 -> 40
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);

		// Example of traversing the node and printing
        traverseList(head); //Iterate over a list
		insert(head, 300, 3);
		delete(head,4);
		reverse(head);
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}
