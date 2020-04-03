package com.learn.dsa.LearnDSA.sorting;

public class InsertionSort {

	//static int[] arr = { 8, 7, 1, 42, 23, 55 };
	static int[] arr = 	{7, 10, 4, 3, 20, 15, 6};

	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();

		System.out.println("Array before sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");

		sort.insertionsort(arr);

		System.out.println("Array after sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public void insertionsort(int[] arr) {
		for (int i = 1; i < arr.length - 1; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

}
