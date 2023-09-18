
package org.yasar.hackerRank.string_problems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
public class FindAnagramCombinationCount {

	public static void main(String[] args) {

		System.out.println(sherlockAndAnagrams("cdcd"));
		System.out.println(sherlockAndAnagrams("abcd"));
	}
	/*
	 * Complete the 'sherlockAndAnagrams' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts STRING s
	 * as parameter.
	 */

	public static int sherlockAndAnagrams(String s) {
		// Write your code here
		int counter = 0;
		for (int i = s.length() - 1; i > 0; i--) {
			counter += checkCombos(s, i);
		}

		return counter;

	}

	public static int checkCombos(String s, int subj) {
		int counter = 0;
		for (int i = 0; (i + subj) < s.length(); i++) {

			String sub1 = s.substring(i, i + subj);

			for (int j = i + 1; (j + subj) <= s.length(); j++) {

				String sub2 = s.substring(j, j + subj);

				if (sub2.length() == 1 && sub2.equals(sub1)) {
					counter++;
				} else if (checkAnagaram(sub1, sub2)) {
					counter++;
				}
			}
		}
		return counter;
	}

	public static boolean checkAnagaram(String s1, String s2) {
		Map<Character, Integer> mp = new HashMap<>();
		
		if (s1 == null) {
			return false;
		}else 
			return true;
		
		
		
	}

}

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				String s = bufferedReader.readLine();

//                int result = Result.sherlockAndAnagrams(s);
				int result = 0;

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
