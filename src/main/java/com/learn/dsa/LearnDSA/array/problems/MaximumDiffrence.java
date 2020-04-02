package com.learn.dsa.LearnDSA.array.problems;

/*
 Problem: Maximum difference b/w 2 elements
 Reference: https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 --------------------------------------------------------------------------------------------------
 Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
Examples :

Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.

Solution: Refer Geek4Geek link
*/

class MaximumDiffrence {
	/*
	 * The function assumes that there are at least two elements in array. The
	 * function returns a negative value if the array is sorted in decreasing order.
	 * Returns 0 if elements are equal
	 */
	int maxDiff(int arr[], int arr_size) {
		int max_diff = arr[1] - arr[0];
		int i, j;
		for (i = 0; i < arr_size; i++) {
			for (j = i + 1; j < arr_size; j++) {
				if (arr[j] - arr[i] > max_diff)
					max_diff = arr[j] - arr[i];
			}
		}
		return max_diff;
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		MaximumDiffrence maxdif = new MaximumDiffrence();
		int arr[] = { 1, 2, 90, 10, 110 };
		System.out.println("Maximum differnce is " + maxdif.maxDiff(arr, 5));
	}
}