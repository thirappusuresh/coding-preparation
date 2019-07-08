package com.iv;

public class E extends C{
	private static int sam = 2;
	private int sam2 = 3;
	public void print(E e) {
		int temp = sam;
		temp = sam2;
		System.out.println("E");
	}
	
	public void print1(E e) {
		int temp = sam;
		System.out.println("E");
	}
	
	public static void main(String [] args) {
		B b = new E();
		C c = new E();
		E e = new E();
		e.print1(e);
		b.print(b);
		c.print(e);
		
/*		B b2 = (B) new A();
		b2.read();        // From Base Class
		b2.read1();         // Compilation Error
*/		
		A b1 = new B();
		b1.read();        // From Base Class
		//b1.read1();         // Compilation Error since A class doesn't have read1 method
		b1.methodFour(1);
	}
}