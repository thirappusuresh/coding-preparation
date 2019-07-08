package com.iv;

public class NameBean {
	private String str;
	public int Value;
	
	NameBean(String str) {
		this.str = str;
	}
	
	public String toString() {
		return str;
	}
	
	public static void main(String [] args) {
		NameBean c = new NameBean("");
		c.Value = 100;
		//NameBean c1 = c;  // both c and c1 pointing to same location
		NameBean c1 = c;    // both c and c1 pointing to different location
		System.out.println(c1.Value);
		c1.Value = 50;
		c.Value = 25;
		
		System.out.println(c.Value);
		System.out.println(c1.Value);
		c1 = null;
		System.out.println(c.Value);
		System.out.println(c1.Value);
	}
}