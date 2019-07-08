package com.mfino;

public class MaxSubSequenceOfArray {
	public static void main(String args[]) {
		int sum = 0;
		int maxSum = 0;
		int arr[] = new int[] {2, 3, -8, -1, 2, 4, -2, 3};
		//int arr[] = new int[] {-2, -4, -3};
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(i == 0) maxSum = arr[i];
			if(sum > 0 && maxSum < sum) maxSum = sum;
			else if(sum < 0) {
				if(maxSum < sum) maxSum = sum;
				sum = 0;
			}
		}
		System.out.println(maxSum);
		try {
			System.out.println("I am in try block");
			System.exit(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//System.exit(1);
			System.out.println("I am in finally block!!!");
		}
	}
}
