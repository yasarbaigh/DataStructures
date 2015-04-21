package org.yasar.ds.others;

//	http://ideone.com/TN11vq
// http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
public class CombinationOfParanthesis {

	public static void main(String[] args) {
		
		int n = 2;
		
		String parenthesis = "";

		//_printParenthesis(0, n, 0, 0, parenthesis);
		System.out.println(printParanthesis(2));
	}

	public static void _printParenthesis(int pos, int n, int open, int close,
			String parenthesis) {
		if (close == n) {
			print(parenthesis);
		} else {
			if (open > close) {

				_printParenthesis(pos + 1, n, open, close + 1, parenthesis
						+ "}");
			}
			if (open < n) {

				_printParenthesis(pos + 1, n, open + 1, close, parenthesis
						+ "{");
			}
		}
	}

	public static void print(String parenthesis) {
		int n = parenthesis.length();
		//for (int i = 0; i < n; i++)
//			System.out.print(parenthesis.charAt(i) + " ");

		System.out.print(parenthesis + ",");
	}
	
	
	public static String printParanthesis(int n) {

		String result = null;
		if (n < 1)
			result = "";
		if (n == 1)
			result = "{}";
		if (n > 1) {
			
			/*
			 * Find the way in which n-1 paranthesis can be formed. Now two ways
			 * 1) Append it with {} 2) Enclose it within {}
			 */
			
			String temp = printParanthesis(n - 1);
			// tokenize based on ;
			String[] tempArr = temp.split(";");
			for (String s : tempArr) {
				String newPattern = s + "{}" + ";" + "{" + s + "}";
				// if s+"{}" looks different than "{}"+s then add that as well
				if (!(s + "{}").equals("{}" + s))
					newPattern = newPattern + ";" + "{}" + s;

				if (result == null) {
					result = newPattern;
				} else {
					result = result + ";" + newPattern;
				}
			}

		}
		return result;
	}
}
