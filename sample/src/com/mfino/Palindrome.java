package com.mfino;

public class Palindrome {
	public static boolean isPalindrome(String str) {
		boolean status = true;
		System.out.println("*" + str + "*");
		for (int i = 0; i <= (str.length() / 2); i++) {
			if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
			} else {
				status = false;
				break;
			}
		}
		/*
		 * if(status) { System.out.println("palindrome"); } else {
		 * System.out.println("not palindrome"); }
		 */
		return status;
	}

	public static void main(String[] args) {
		String str = "vikaakiv";
		String front = "";
		boolean status = true;
		for (int i = 0; i < str.length(); i++) {
			if (i == 0 && isPalindrome(str)) {
				status = true;
				break;
			}
			front = front + str.charAt(i);
			if (isPalindrome(str.substring(i + 1) + front)) {
				status = true;
				break;
			} else {
				status = false;
			}
		}
		if (status) {
			System.out.println("palindrome");
		} else {
			System.out.println("not palindrome");
		}
	}
}
