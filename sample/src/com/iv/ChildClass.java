package com.iv;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ChildClass extends SuperClass{
	public int doit(String str, Integer data) throws Exception {
		String signature = "(String, Integer[])";
		System.out.println("Overridden: "+str+" "+signature);
		return 0;
	}
	
	public static void show(Queue q) {
		q.add(new Integer(11));
		while(!q.isEmpty()) {
			System.out.print(q.poll()+" ");
		}
	}
	
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
        int count = 2;
        int input = in.nextInt();
		SuperClass sb = new ChildClass();
		try {
			sb.doit("hello", 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashSet mySet = new HashSet();
		String s1 = new String("das");
		String s2 = new String("das");


		NameBean s3 = new NameBean("abcdef");
		NameBean s4 = new NameBean("abcdef");
		mySet.add(s1);
		mySet.add(s2);
		mySet.add(s3);
		mySet.add(s4);
		System.out.println("mySet: "+mySet);
		
		Queue<String> q = new LinkedList<String>();
		q.add("some");
		q.add("text");
		show(q);
	}
}
