package com.mfino;

import java.util.Stack;

public class Expression {
	public static void main(String [] args) {
		String str = "}{({}[([)])}";
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '{' || ch == '(' || ch == '[') {
				stack.push(ch);
			} else if(ch == '}' || ch == ')' || ch == ']') {
				if(stack.isEmpty()) {
					System.out.println("Not valid at "+i);
					break;
				} else {
					char pop = stack.pop();
					if((ch == '}' && pop != '{') || (ch == ']' && pop != '[') || (ch == ')' && pop != '(')) {
						System.out.println("Not valid at "+i);
						break;
					}
				}
 			}
		}
		if(stack.isEmpty()) {
			System.out.println("Valid");
		} else {
			System.out.println("Not Valid");
		}
	}
}
