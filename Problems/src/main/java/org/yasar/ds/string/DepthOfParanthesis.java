package org.yasar.ds.string;

// http://www.geeksforgeeks.org/find-maximum-depth-nested-parenthesis-string/
public class DepthOfParanthesis {

	public static void main(String[] args) {
		
		checkParanthesis("( ((X)) (((Y))) )");
		checkParanthesis("))((()))"); 
		
				
		checkParanthesis("(((())");
		checkParanthesis("((()))((");
		checkParanthesis("((()())())");
		
		checkParanthesis("(()))");
	}
	
	private static void checkParanthesis(String str) {
		
		System.out.println("Input :" + str +" , output :" + getDepth(str));
		System.out.println("-----------------------");
		
	}

	public static int getDepth(String str) {
				
		int currDepth =0 , maxDepth = 0;
		char[] cr = str.toCharArray();
		int i = 0;
		
		for(i = 0; i< cr.length; i++) {
			
			if(cr[i] == '(' || cr[i] =='[' || cr[i] == '{') {
				currDepth++;
				
				if( currDepth > maxDepth) {
					maxDepth = currDepth;
					
				}
			} else if(cr[i] == ')' || cr[i] ==']' || cr[i] == '}') {
				
				if (currDepth>0)
					currDepth--;
				else
					return -1;
			}
		}
		
			
		return currDepth == 0 ? maxDepth : -1;
	}
}
