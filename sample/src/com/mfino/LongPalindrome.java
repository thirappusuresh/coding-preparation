package com.mfino;

public class LongPalindrome {
	static boolean ispalindrome(char[] str, int l, int h)
	{
	    while(h>l)
	    {
	        if(str[h--]!=str[l++])
	            return false;
	    }
	    return true;
	}

	static void lpalin(char[] str, int n)
	{
	    int i,j,max=0,maxi = 0;
	    for(i=0;i<n;i++)
	    {
	        for(j=i;j<n;j++)
	        {
	            if(ispalindrome(str,i,j))
	            {
	                int length=j-i+1;
	                if(max<length)
	                {
	                    max=length;
	                    maxi=i;
	                }

	            }
	        }
	    }
	    if(max>0)
	    {
	        char []answer=new char[max];
	        for(i=0;i<max;i++)
	            answer[i]=str[maxi++];
	       	System.out.println(answer);
	    }

	}

	public static void main(String [] args)
	{
	    //char str[]="forgeeksskeegfor";
		String s = "forgeeksskeegfor";
	    char str[]=s.toCharArray();
	    lpalin(str,str.length);
	}

}
