package com.learn.dsa.LearnDSA.queue;

/* Problem: Java program to reverse a Queue
 * Reference: https://www.geeksforgeeks.org/reversing-a-queue/
 * */ 
import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Stack; 

public class QueueReverse { 
	
	static Queue<Integer> queue; 

	// Utility function to print the queue 
	static void Print() 
	{ 
		while (!queue.isEmpty()) { 
			System.out.print( queue.peek() + ", "); 
			queue.remove(); 
		} 
	} 

	// Function to reverse the queue 
	static void reversequeue() 
	{ 
		Stack<Integer> stack = new Stack<Integer>(); 
		while (!queue.isEmpty()) { 
			stack.add(queue.peek()); 
			queue.remove(); 
		} 
		while (!stack.isEmpty()) { 
			queue.add(stack.peek()); 
			stack.pop(); 
		} 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		queue = new LinkedList<Integer>(); 
		queue.add(10); 
		queue.add(20); 
		queue.add(30); 
		queue.add(40); 
		queue.add(50); 
		queue.add(60); 
		queue.add(70); 
		queue.add(80); 
		queue.add(90); 
		queue.add(100); 

		reversequeue(); 
		Print(); 
	} 
}