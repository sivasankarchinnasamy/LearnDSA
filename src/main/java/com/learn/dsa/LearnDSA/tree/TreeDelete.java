package com.learn.dsa.LearnDSA.tree;

import com.learn.dsa.LearnDSA.tree.BinaryTree;

/* Problem: Java program to delete a tree
 * Reference: https://www.geeksforgeeks.org/write-a-c-program-to-delete-a-tree/?ref=rp
 * */ 

class TreeDelete 
{ 

	static Node root; 

	/* This function is same as deleteTree() in the previous program */
	void deleteTree(Node node) 
	{ 
		// In Java automatic garbage collection 
		// happens, so we can simply make root 
		// null to delete the tree 
		root = null; 
	} 
	
	/* Wrapper function that deletes the tree and sets root node as null */
	void deleteTreeRef(Node nodeRef) 
	{ 
		deleteTree(nodeRef); 
		nodeRef=null; 
	} 

	/* Driver program to test deleteTree function */
	public static void main(String[] args) 
	{ 

		TreeDelete tree = new TreeDelete(); 

		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		/* Note that we pass root node here */
		tree.deleteTreeRef(root); 
		System.out.println("Tree deleted"); 

	} 
} 

//This code has been contributed by Mayank Jaiswal(mayank_24) 
