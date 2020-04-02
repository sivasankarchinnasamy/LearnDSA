package com.learn.dsa.LearnDSA.array.problems;

/*
 Problem : Longest Odd Even Subarray
   Reference:  https://www.geeksforgeeks.org/longest-increasing-odd-even-subsequence/
----------------------------------------------------------
Given an array of size n. The problem is to find the length of the subsequence in the given array such that all the elements of the subsequence are sorted in increasing order and also they are alternately odd and even.
Note that the subsequence could start either with the odd number or with the even number.

Examples:

Input : arr[] = {5, 6, 9, 4, 7, 8}
Output : 4
{5, 6, 7, 8} is the required longest increasing odd even subsequence.

Input : arr[] = {1, 12, 2, 22, 5, 30, 31, 14, 17, 11}
Output : 5

 * Solution
----------------------------------------------------------
Efficient Approach:
Let L(i) be the length of the LIOES (Longest Increasing Odd Even Subsequence) ending at index i such that arr[i] is the last element of the LIOES.
Then, L(i) can be recursively written as:
L(i) = 1 + max( L(j) ) where 0 < j < i and (arr[j] < arr[i]) and (arr[i]+arr[j])%2 != 0; or
L(i) = 1, if no such j exists.
To find the LIOES for a given array, we need to return max(L(i)) where 0 < i < n.
A dynamic programming approach has been implemented below for the above mentioned recursive relation.

 * */

import java.util.*;
import java.lang.*;

public class LongestOddEvenSubarray {

	// function to find the longest increasing odd even subsequence
	public static int longOddEvenIncSeq(int arr[], int n) {
		// lioes[i] stores longest increasing odd even subsequence ending at arr[i]
		int[] lioes = new int[n];

		// to store the length of longest increasing odd even subsequence
		int maxLen = 0;

		// Initialize LIOES values for all indexes
		for (int i = 0; i < n; i++)
			lioes[i] = 1;

		// Compute optimized LIOES values in bottom up manner
		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (arr[i] > arr[j] && (arr[i] + arr[j]) % 2 != 0 && lioes[i] < lioes[j] + 1)
					lioes[i] = lioes[j] + 1;

		// Pick maximum of all LIOES values
		for (int i = 0; i < n; i++)
			if (maxLen < lioes[i])
				maxLen = lioes[i];

		// required maximum length
		return maxLen;
	}

	// driver function
	public static void main(String argc[]) {
		int[] arr = new int[] { 1, 12, 2, 22, 5, 30, 31, 14, 17, 11 };
		int n = 10;
		System.out.println("Longest Increasing Odd" + " Even Subsequence: " + longOddEvenIncSeq(arr, n));
	}
}
