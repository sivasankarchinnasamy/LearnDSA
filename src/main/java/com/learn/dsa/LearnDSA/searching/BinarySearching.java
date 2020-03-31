package com.learn.dsa.LearnDSA.searching;

import java.util.Arrays;

public class BinarySearching {

	/*
	 * / Array needs to be sorted before searching. Array sorted using Arrays.sort()
	 */
	static int[] array = { 8, 7, 1, 42, 23, 55, 56, 88, 48, 35, 99, 45, 89, 22 };

	public static void main(String[] args) {
		BinarySearching search = new BinarySearching();
		int data = 1;
		Arrays.sort(array);
		System.out.print("Sorted array: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
		int position = search.binarysearch(array, array.length, data);
		System.out.println("Position of data is: " + position);
	}

	public int binarysearch(int[] arr, int n, int data) {
		int left = 0;
		int right = n - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] == data) {
				return mid;
			} else if (arr[mid] > data) {
				right = mid - 1;
			} else if (arr[mid] < data) {
				left = mid + 1;
			}
		}
		return -1;
	}
}
