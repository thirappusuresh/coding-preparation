package com.mfino;

public class ClassB extends ClassA {
	public final int test;
	public static int test1;
	ClassB(int test) {
		this.test = test;
	}
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("hi2");
	}
	
	public static void main(String []args) {
		ClassB b = new ClassB(1);
		ClassB.test1 =2;
		b.method2();
	}
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

}
