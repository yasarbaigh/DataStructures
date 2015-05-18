package org.yasar.ds.string;

//	http://opensourceforgeeks.blogspot.in/2013/12/swapping-two-strings-without-using.html

public class StringSwapper {

	
	public static void main(String args[]){
		 
        String a="one";
        String b="two";
 
        a= a+b;
        b = a.substring(0,(a.length()-b.length()));
        a = a.substring(b.length(),(a.length()));
 
        System.out.println("a = "+a);
        System.out.println("b = "+b);
 
    }
}
