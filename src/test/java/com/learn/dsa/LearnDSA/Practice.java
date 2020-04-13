package com.learn.dsa.LearnDSA;


public class Practice {
	
	static Node head = null;
	
	static class Node{
		int data;	
		Node next;
		public Node(int d) {
			data=d;
		}
	}
	
	public void pushNode(int d) {
		if(head==null) {
			Node node = new Node(d);
			head=node;
			node.next=null;
		}else {
			Node node=head;
			while(node.next!=null) {
				node=node.next;
			}
			Node newNode = new Node(d);
			node.next= newNode;
			newNode.next=null;
		}
	}
	
	public void pushHead(int d) {
		if(head==null) {
			head= new Node(d);
			head.next=null;
		}
		Node node = new Node(d);
		node.next=head;
		head=node;		
	}
	
	public void print(Node head) {
		Node node=head;
		while(node.next!=null) {
			System.out.print(node.data+ "->");
			node=node.next;
			if(node.next==null) {
				System.out.print(node.data);
			}
		}
	}
	
	public int lenght(Node head) {
		Node node = head; 
		int count=0;
		while(node.next!=null) {
			count++;
			node=node.next;
			if(node.next==null) {
				count++;
			}
		}
		return count;
	}
	
	public static void main (String[] args) { 
		Practice practice = new Practice();
		practice.pushNode(1);
		practice.pushNode(2);
		practice.pushNode(3);
		practice.print(head);
		practice.pushNode(4);
		practice.pushNode(5);
		practice.pushNode(6);
		System.out.println("");
		practice.print(head);
		System.out.println("");
		System.out.println("Length of linked list is: "+ practice.lenght(head));
		practice.pushHead(11);
		practice.print(head);
		System.out.println("");
		System.out.println("Length of linked list is: "+ practice.lenght(head));
	}
	
}