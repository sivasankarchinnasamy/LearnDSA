package com.learn.dsa.LearnDSA.tree.problems;
import java.util.*;

/* Problem: Java program to construct a tree using inorder and preorder traversal
 * Reference: https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * */ 
 class TreeNode { 
	int val; 
	TreeNode left; 
	TreeNode right; 
	TreeNode(int x) { val = x; } 
} 

 public class TreeFromInorderPreorder { 
	static Set<TreeNode> set = new HashSet<TreeNode>(); 
	static Stack<TreeNode> stack = new Stack<TreeNode>(); 

	// Function to build tree using given traversal 
	public TreeNode buildTree(int[] preorder, int[] inorder) 
	{ 

		TreeNode root = null; 
		for (int pre = 0, in = 0; pre < preorder.length;) { 

			TreeNode node = null; 
			do { 
				node = new TreeNode(preorder[pre]); 
				if (root == null) { 
					root = node; 
				} 
				if (!stack.isEmpty()) { 
					if (set.contains(stack.peek())) { 
						set.remove(stack.peek()); 
						stack.pop().right = node; 
					} 
					else { 
						stack.peek().left = node; 
					} 
				} 
				stack.push(node); 
			} while (preorder[pre++] != inorder[in] && pre < preorder.length); 

			node = null; 
			while (!stack.isEmpty() && in < inorder.length && 
					stack.peek().val == inorder[in]) { 
				node = stack.pop(); 
				in++; 
			} 

			if (node != null) { 
				set.add(node); 
				stack.push(node); 
			} 
		} 

		return root; 
	} 

	// Function to print tree in Inorder 
	void printInorder(TreeNode node) 
	{ 
		if (node == null) 
			return; 

		/* first recur on left child */
		printInorder(node.left); 

		/* then print the data of node */
		System.out.print(node.val + " "); 

		/* now recur on right child */
		printInorder(node.right); 
	} 

	// driver program to test above functions 
	public static void main(String args[]) 
	{ 
		TreeFromInorderPreorder tree = new TreeFromInorderPreorder(); 

		int in[] = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 }; 
		int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 }; 
		int len = in.length; 

		TreeNode root = tree.buildTree(pre, in); 

		tree.printInorder(root); 
	} 
} 
