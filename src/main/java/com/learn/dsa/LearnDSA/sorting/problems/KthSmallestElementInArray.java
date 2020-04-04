package com.learn.dsa.LearnDSA.sorting.problems;

/*
Problem: Find kth Smallest element
Reference: 
-----------------------------------------------------------------------------------------------------------------------------
Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. 
It is given that ll array elements are distinct.
Examples:

Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 4
Output: 10

Solution:
-----------------------------------------------------------------------------------------------------------------------------
Sort the array first and then find element at relevant position.
 * */

public class KthSmallestElementInArray {
	static int[] arr = {7, 10, 4, 3, 20, 15, 6, 76, 35, 1,34,5,67,0,2,123,78};

	public void quicksort(int[] arr, int lb, int ub) {
		if (lb < ub) {
			int loc = partition(arr, lb, ub);
			quicksort(arr, lb, loc - 1);
			quicksort(arr, loc + 1, ub);
		}
	}

	public int partition(int[] arr, int lb, int ub) {
		int pivot = arr[ub];
		int start = lb;
		int end = ub;
		while (start < end) {
			while (arr[start] <= pivot && start<ub) {
				start++;
			}
			while (arr[end] > pivot && end>=lb) {
				end--;
			}
			if (start < end) {
				swap(start, end);
			}
		}
		swap(lb, end); // swap pivot with end
		return end;
	}

	public void swap(int start, int end) {
		int temp = arr[end];
		arr[end] = arr[start];
		arr[start] = temp;
	}

	public static void main(String[] args) {
		KthSmallestElementInArray element = new KthSmallestElementInArray();
		element.quicksort(arr, 0, arr.length - 1);
		System.out.println("Array after sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("Second smallest element: " + arr[1]);
	}
}
