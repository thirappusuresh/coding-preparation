package com.mfino;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class Wordify {
	private static final String[] bigs = {""," thousand"," million"," billion"," trillion"," quadrillion"," quintillion"};
 	private static final String[] tens = {" ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy"," eighty"," ninety"};
 	private static final String[] digits = {" one"," two"," three"," four"," five"," six"," seven"," eight"," nine"," ten",};
 	private static final String[] teens = {" eleven"," twelve"," thirteen"," fourteen"," fifteen"," sixteen"," seventeen"," eighteen"," nineteen"};
 		
 	public String numToString(int num) {
 		if(num == 0) {
 			return "zero";
 		} else if(num < 0) {
 			return "negative"+numToString(-1 * num);
 		}
 		int count = 0;
 		String str = "";
 		while(num > 0) {
 			if(num % 1000 != 0) {
 				str = numToString100(num % 1000) + bigs[count]+str; 
 			}
 			num /= 1000;
 			count++;
 		} 
 		return str.trim();
 	}
 	
 	public String numToString100(int num) {
 		String str = "";
 		if(num >= 100) {
 			str += digits[num / 100 - 1] + " hundred and";
 			num %= 100;
 		}
 		if(num >= 11 && num <= 19) {
 			return str + teens[num - 11];
 		} else if(num == 10 || num >= 20) {
 			str += tens[num / 10 -1];
 			num %= 10;
 		}
 		
 		if(num >= 1 && num <= 9) {
 			str += digits[num - 1];
 		}
 		return str;
 	}
 		
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
 		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        Wordify test = new Wordify();
        System.out.println(test.numToString(N));
    }
}