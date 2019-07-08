package com.iv;

public class SuperClass {
	public int doit(String str, Integer data) throws ArrayIndexOutOfBoundsException, Exception {
		String signature = "(String, Integer[])";
		System.out.println(str+" "+signature);
		return 1;
	}
}
