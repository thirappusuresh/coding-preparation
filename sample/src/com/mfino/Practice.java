package com.mfino;

public class Practice {
	static char [] chars = new char[8];
	public static void reverseString(int start, int end) {
		int j = ((end-start)/2);
		for(int i = 0; i <= j; i++) {
			System.out.println("s: "+(start+i)+" e:"+(end-i));
			char ch = chars[start+i];
			chars[start+i] = chars[end-i];
			chars[end-i] = ch;
		}
	}
	
	public static void main(String []args) {
		String str = "ia am god";
		int index = 0;
		chars = str.toCharArray();
		if(chars.length > 0) {
			reverseString(0, (chars.length-1));
			for(int i = 0; i < chars.length; i++) {
				System.out.print(chars[i]);
			}
			for(int i = 0; i < chars.length; i++) {
				char ch = chars[i];
				if(ch == ' ' || i == (chars.length-1)) {
					if(i == (chars.length-1)) i+=1;
					reverseString(index, (i-1));
					index = (i+1);
				}
			}
			for(int i = 0; i < chars.length; i++) {
				System.out.print(chars[i]);
			}
			
		} else {
			//empty string
		}
		
		String newstr = new String("      This is string  ");
		
		String t = "";
		String reverse = "";
		String s = "";
		for(int k = 0; k < newstr.length(); k++) {
			if(newstr.charAt(k) == ' ') {
				k++;
			} else {
				s = newstr.substring(k);
				break;
			}
		}
		System.out.println("@"+s+"@"+s.length());
		char[] myNameChars = s.toCharArray();
		for(int k = 0; k < (s.length()/2); k++) {
			char temp = s.charAt(k);
			myNameChars[k] = myNameChars[s.length() -1 - k];
			myNameChars[s.length()-1 - k] = temp;
		}
		
		for(int k = 0; k < myNameChars.length; k++) {
			System.out.print(myNameChars[k]);
		}
		s = String.valueOf(myNameChars);
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ' || i == (s.length() - 1)) {
				if(i == (s.length() - 1)) t = t+s.charAt(i);
				for(int j = (t.length() - 1); j >= 0; j--) {
					reverse = reverse + t.charAt(j);
					if(j == 0 && i != (s.length() - 1)) {
						reverse = reverse + ' ';
					}
				}
				t = "";
			} else {
				t = t + s.charAt(i);
			}
		}
		System.out.println("@"+reverse+"@");
	}
}
