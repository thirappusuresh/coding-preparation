package com.mfino;

public class IntPalindrome {
	public static boolean isPalindrome(int n) {
		if(n == revInt(n)) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}
	
	static int weight = 1;
	
	public static int revInt(int n) {
		if(n/10 == 0) {
			return n;
		} else {
			int remainder = n % 10;
			n = revInt(n/10);
			weight *= 10;
			return (weight*remainder)+n;
		}
	}
	
	public static void main(String args[]) {
		isPalindrome(12321);
	}
}
