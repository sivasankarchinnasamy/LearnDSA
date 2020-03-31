package com.learn.dsa.LearnDSA.sorting;

public class QuickSort {

	static int[] arr = { 8, 7, 1, 42, 23, 55 };

	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		
		System.out.println("Array before sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
			System.out.println("");
			
		sort.quicksort(arr,0,arr.length-1);
		
		System.out.println("Array after sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");

	}

	public void quicksort(int[] arr, int lb, int ub) {
		if (lb < ub) {
			int loc = partition(arr, lb, ub);
			quicksort(arr, lb, loc - 1);
			quicksort(arr, loc + 1, ub);
		}
	}

	public int partition(int[] arr, int lb, int ub) {
		int pivot = arr[lb];
		int start = lb;
		int end = ub;
		while (start < end) {
			while (arr[start] <= pivot) {
				start++;
			}
			while (arr[end] > pivot) {
				end--;
			}
			if (start < end) {
				swap(start, end);
			}
		}
		swap(lb, end);
		return end;
	}

	public void swap(int start, int end) {
		int temp = arr[end];
		arr[end] = arr[start];
		arr[start] = temp;
	}

}
