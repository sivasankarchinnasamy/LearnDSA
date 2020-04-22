package com.learn.dsa.LearnDSA.binarysearchtree;

/* Problem: Java program to demonstrate insert operation in binary search tree
 * Reference: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 * 
Binary Search Tree, is a node-based binary tree data structure which has the following properties:
-> The left subtree of a node contains only nodes with keys lesser than the node’s key.
-> The right subtree of a node contains only nodes with keys greater than the node’s key.
-> The left and right subtree each must also be a binary tree.
-> There must be no duplicate nodes.
 * */ 

/* Class containing left and right child of current node and key value*/
class Node { 
	int key; 
	Node left, right; 

	public Node(int item) { 
		key = item; 
		left = right = null; 
	} 
}
public class BinarySearchTree {
	// Root of BST 
	Node root; 

	// Constructor 
	BinarySearchTree() { 
		root = null; 
	} 

	// This method mainly calls insertRec() 
	void insert(int key) { 
	root = insertRec(root, key); 
	} 
	
	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) { 

		/* If the tree is empty, return a new node */
		if (root == null) { 
			root = new Node(key); 
			return root; 
		} 

		/* Otherwise, recur down the tree */
		if (key < root.key) 
			root.left = insertRec(root.left, key); 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	} 

	// This method mainly calls InorderRec() 
	void inorder() { 
	inorderRec(root); 
	} 

	// A utility function to do inorder traversal of BST 
	void inorderRec(Node root) { 
		if (root != null) { 
			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
		} 
	} 

	// Driver Program to test above functions 
	public static void main(String[] args) { 
		BinarySearchTree tree = new BinarySearchTree(); 

/* Let us create following BST 
        50 
     /     \ 
    30      70 
   /  \    /  \ 
 20   40  60   80 */
		
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 

		// print inorder traversal of the BST 
		tree.inorder(); 
	} 
}