package org.yasar.other;
//	http://www.quickprogrammingtips.com/java/program-to-print-pascal-triangle-in-java.html

/*
Note the formatting commands used above to create a nicely formatted triangle.
%4d instructs the formatter to print the number within 4 spaces.
We choose 4 since we know the maximum number of digits in the largest number of 
a Pascal triangle with 10 rows is 3 digits

*/
public class PascalTriangle {

	
	public static void main(String[] args) {

		int rows = 4;

		for (int i = 0; i < rows; i++) {

			int number = 1;

			System.out.format("%" + (rows - i) * 2 + "s", "");

			for (int j = 0; j <= i; j++) {

				System.out.format("%4d", number);

				number = number * (i - j) / (j + 1);

			}

			System.out.println();

		}

	}

}