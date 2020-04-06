package com.learn.dsa.LearnDSA.sorting;

public class BubbleSort {

	//static int[] arr = { 8, 7, 1, 42, 23, 55 };
	//static int[] arr = 	{7, 10, 4, 3, 20, 15, 6};
	//static int[] arr = 	{7, 10, 4, 3, 20, 15, 6,45,56,23,78,23,89,99,1,2,4};
	static int[] arr = 	{99,98,95,90,89,87,80,75,73,69,63,60,59,53,50,49,43,30,25,20,10,5,1};

	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();

		System.out.println("Array before sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");

		sort.bubblesort(arr);

		System.out.println("Array after sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}

	public void bubblesort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int flag = 0;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(j,j+1);
					flag = 1;
				}
			}
			if (flag == 0) {
				break;
			}
		}
	}

	public void swap(int start, int end) {
		int temp = arr[end];
		arr[end] = arr[start];
		arr[start] = temp;
	}

}
