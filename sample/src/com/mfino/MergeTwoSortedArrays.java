package com.mfino;

import java.util.Scanner;


class MergeTwoSortedArrays {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
		 */
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
		int a[] = new int[m];
		for(int i=0;i<m;i++)
		   {
		    a[i] = scanner.nextInt();
		   }
		int n = scanner.nextInt();
		int b[] = new int[n];
		for(int i=0;i<n;i++)
		   {
		    b[i] = scanner.nextInt();
		   }
		scanner.close();
		
		int c[] = new int[m+n];
		int k = 0, l = 0;
		int count = 0;
		while(k < m && l < n) {
			if(a[k] < b[l]) {
				c[count] = a[k];
				k++;
			} else {
				c[count] = b[l];
				l++;
			}
			count++;
		}
		
		if(k == (m-1)) {
			while(l < n) {
				c[count] = b[l];
				l++;
				count++;
			}
		} else {
			while(k < m) {
				c[count] = a[k];
				k++;
				count++;
			}
		}
		for(int s=0;s<m+n;s++)
		   {
		    System.out.print(c[s]+" ");
		   }
    }
}