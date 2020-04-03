package com.learn.dsa.LearnDSA.sorting;

public class MergeSort {

	//static int[] arr = { 8, 7, 1, 42, 23, 55 };
	static int[] arr = 	{7, 10, 4, 3, 20, 15, 6};
	static int[] b = new int[arr.length];

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();

		System.out.println("Array before sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");

		sort.mergesort(arr, 0, arr.length - 1);

		System.out.println("Array after sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public void mergesort(int[] arr, int lb, int ub) {
		if (lb < ub) {
			int mid = (lb + ub) / 2;
			mergesort(arr, lb, mid);
			mergesort(arr, mid + 1, ub);
			merge(arr, lb, mid, ub);
		}
	}

	public void merge(int[] arr, int lb, int mid, int ub) {
		int i = lb;
		int j = mid + 1;
		int k = lb;
		while (i <= mid && j <= ub) {
			if (arr[i] <= arr[j]) {
				b[k] = arr[i];
				k++;
				i++;
			} else {
				b[k] = arr[j];
				k++;
				j++;
			}
		}
		if (i > mid) {
			while (j <= ub) {
				b[k] = arr[j];
				j++;
				k++;
			}
		} else {
			while (i <= mid) {
				b[k] = arr[i];
				i++;
				k++;
			}
		}
		for (int p = lb; p <= ub; p++) {
			arr[p] = b[p];
		}
	}
}
