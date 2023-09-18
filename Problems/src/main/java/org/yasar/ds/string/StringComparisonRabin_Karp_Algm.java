package org.yasar.ds.string;

import java.util.ArrayList;
import java.util.List;

// https://www.codingninjas.com/studio/problems/stringmatch-rabincarp_1115738?leftPanelTab=0

// https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/
public class StringComparisonRabin_Karp_Algm {
	
	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };

	public static int primeNumber = 10007;
	public static int ascii = 256;

	public static void main(String[] args) {
		System.out.println(stringMatch("cxyzghxyzvjkxyz", "xyz"));

	}

	public static List<Integer> stringMatch(String text, String pattern) {

		List<Integer> op = new ArrayList<>();
		int q = primeNumber, d = ascii;
		String pat = pattern, txt = text;

		int M = pat.length();
		int N = txt.length();
		int i, j;
		int hashP = 0; // hash value for pattern
		int hastT = 0; // hash value for txt
		int mostSignificantHashPowered = 1;

		// The value of h would be "pow(d, M-1)%q"
		for (i = 0; i < M - 1; i++)
			mostSignificantHashPowered = (mostSignificantHashPowered * d) % q;

		// Calculate the hash value of pattern and first
		// window of text
		for (i = 0; i < M; i++) {
			// multiplying most-significant with base-ascii and Adding least-significant
			// char
			hashP = (ascii * hashP + pat.charAt(i)) % q;
			hastT = (ascii * hastT + txt.charAt(i)) % q;
		}

		// Slide the pattern over text one by one
		for (i = 0; i <= N - M; i++) {

			// Check the hash values of current window of
			// text and pattern. If the hash values match
			// then only check for characters one by one
			if (hashP == hastT) {
				/* Check for characters one by one */
				for (j = 0; j < M; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}

				// if p == t and pat[0...M-1] = txt[i, i+1,
				// ...i+M-1]
				if (j == M)
					op.add(i + 1);
			}

			// Calculate hash value for next window of text:
			// Remove leading digit, add trailing digit
			if (i < N - M) {
				hastT = (ascii * (hastT - txt.charAt(i) * mostSignificantHashPowered) + txt.charAt(i + M)) % q;

				// We might get negative value of t,
				// converting it to positive
				while (hastT < 0)
					hastT = (hastT + q);
			}
		}

		return op;
	}

}
