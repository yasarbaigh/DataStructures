package org.yasar.huge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//	http://www.quora.com/Given-a-file-containing-4-30-billion-32-bit-integers-how-can-we-find-a-number-which-has-appeared-at-least-twice

public class DuplicateNumberOfHuge {
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(findDuplicate());
		
	}
	public static int findDuplicate() throws FileNotFoundException{
		//byte[] byteArray = new byte[0x7fffffff / 8];
		byte[] byteArray = new byte[24 / 8];
		Scanner in = new Scanner(new FileReader("src/main/resources/huge/Numbers.txt"));
		int rst = 0;
		
		while(in.hasNext()){
			int n = in.nextInt();
			if((byteArray[n / 8] >> (n % 8) & 1) == 1){
				rst = n;
				break;
			}
			byteArray[n / 8] |= (1 << n % 8);
		}
		return rst;
	}

}
