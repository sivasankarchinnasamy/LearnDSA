package com.learn.dsa.LearnDSA.sorting;

public class SelectionSort {
	
	static int[] arr = { 8, 7, 1, 42, 23, 55 };
	
	public static void main(String[] args) {
		SelectionSort sort = new SelectionSort();

		System.out.println("Array before sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");

		sort.selectionsort(arr);

		System.out.println("Array after sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	
	public void selectionsort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int min = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			if(min!=i) {
				int temp= arr[i];
				arr[i]=arr[min];
				arr[min]=temp;
			}
		}
	}
}
