package com.learn.dsa.LearnDSA.array.problems;

import java.util.*;

/*
 Problem : Maximum Subarray Sum
 Reference: https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
--------------------------------------------------------------------------------------
 You are given a one dimensional array that may contain both positive and negative integers, 
 find the sum of contiguous subarray of numbers which has the largest sum. For example, if the 
 given array is {-2, -5, 6, -2, -3, 1, 5, -6}, then the maximum subarray sum is 7.
 
 * Solution: Divide & Conquer Algorithm
--------------------------------------------------------------------------------------
1) Divide the given array in two halves
2) Return the maximum of following three
….a) Maximum subarray sum in left half (Make a recursive call)
….b) Maximum subarray sum in right half (Make a recursive call)
….c) Maximum subarray sum such that the subarray crosses the midpoint

The lines 2.a and 2.b are simple recursive calls. How to find maximum subarray sum such that the subarray crosses the midpoint? 
We can easily find the crossing sum in linear time. The idea is simple, find the maximum sum starting from mid point and ending at 
some point on left of mid, then find the maximum sum starting from mid + 1 and ending with sum point on right of mid + 1. 
Finally, combine the two and return.

Using Divide and Conquer approach, we can find the maximum subarray sum in O(nLogn) time
 * */

class MaxSubarraySum {

	// Find the maximum possible sum in arr[] such that arr[m] is part of it
	static int maxCrossingSum(int arr[], int l, int m, int h) {
		// Include elements on left of mid.
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		for (int i = m; i >= l; i--) {
			sum = sum + arr[i];
			if (sum > left_sum)
				left_sum = sum;
		}

		// Include elements on right of mid
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for (int i = m + 1; i <= h; i++) {
			sum = sum + arr[i];
			if (sum > right_sum)
				right_sum = sum;
		}

		// Return sum of elements on left
		// and right of mid
		return left_sum + right_sum;
	}

	// Returns sum of maxium sum subarray
	// in aa[l..h]
	static int maxSubArraySum(int arr[], int l, int h) {
		// Base Case: Only one element
		if (l == h)
			return arr[l];

		// Find middle point
		int m = (l + h) / 2;

		/*
		 * Return maximum of following three possible cases: a) Maximum subarray sum in
		 * left half b) Maximum subarray sum in right half c) Maximum subarray sum such
		 * that the subarray crosses the midpoint
		 */
		return Math.max(Math.max(maxSubArraySum(arr, l, m), maxSubArraySum(arr, m + 1, h)),
				maxCrossingSum(arr, l, m, h));
	}

	/* Driver program to test maxSubArraySum */
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 5, 7 };
		int n = arr.length;
		int max_sum = maxSubArraySum(arr, 0, n - 1);

		System.out.println("Maximum contiguous sum is " + max_sum);
	}
}
