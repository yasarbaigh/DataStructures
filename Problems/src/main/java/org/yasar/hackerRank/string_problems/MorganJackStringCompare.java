package org.yasar.hackerRank.string_problems;

public class MorganJackStringCompare {

	public static String morganAndString(String a, String b) {
		// Write your code here

		StringBuilder op = new StringBuilder("");

		String a1 = a + "z", b1 = b + "z";
		while (a1.length() > 1 && b1.length() > 1) {

			if (a1.charAt(0) > b1.charAt(0)) {
				op.append(b1.charAt(0));
				b1 = b1.substring(1);

			} else {

				op.append(a1.charAt(0));
				a1 = a1.substring(1);

			}
		}

		if (1 == a1.length()) {
			op.append(b1.substring(0, b1.length() - 1));
		} else {
			op.append(a1.substring(0, a1.length() - 1));
		}

		return op.toString();

	}

	public static void main33(String[] args) {
		System.out.println(morganAndString("JACK", "DANIEL"));
		System.out.println(morganAndString("ABACABA", "ABACABA"));
	}

	
		
	

}
