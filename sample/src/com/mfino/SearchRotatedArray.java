package com.mfino;

/**
 * Searching an Element in a Rotated Sorted Array
 **/
public class SearchRotatedArray {
	public static int rotated_binary_search(int a[], int N, int key) {
		int left = 0;
		int right = N-1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if(a[mid] == key) return mid;
			if(a[left] < a[mid]) { // left subarray is sorted
				if(a[left] <= key && key < a[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else { // right subarray is sorted
				if(a[mid] < key && key <= a[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] {4,6,7,8,1,2,3};
		System.out.println("index: "+rotated_binary_search(arr, 7, 2));
	}
}
