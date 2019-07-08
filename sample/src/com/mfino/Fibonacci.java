package com.mfino;

public class Fibonacci {
	public static int fibonacci(int n) {
		int fib1 = 1, fib2 = 1;
		if(n == 1 || n == 2) {
			return 1;
		} else {
			int fib = 1;
			for(int i = 3; i <= n; i++) {
				fib = fib1 + fib2;
				fib1 = fib2;
				fib2 = fib;
			}
			return fib;
		}
	}
	
	public static void main(String args[]) {
		String s = "fsd/fsda/fasd/f";
		System.out.println(s.substring(0, s.lastIndexOf("/")));
		System.out.println(Fibonacci.fibonacci(6));
	}
}
