package org.yasar.ds.string;

import java.util.ArrayList;

public class ParanthesisSequence
{

	public static void GetSequence(int N, int nClose)
	{
		if(N == 0) {
			sequences.add(a_sequence);
			return;
		}
		if(nClose == 0) {
			// We don't have to close any paranthesis since there are no open
			// ones
			a_sequence = a_sequence + "(";
			GetSequence(N - 1, 1);
		}
		if(nClose > 0) {
			if(N >= nClose + 2) {
				// We could still open paranthesis
				String temp = a_sequence;
				a_sequence = a_sequence + "(";
				GetSequence(N - 1, nClose + 1);
				a_sequence = temp;
			}
			a_sequence = a_sequence + ")";
			GetSequence(N - 1, nClose - 1);
		}
	}

	private static String a_sequence = "";
	public static ArrayList<String> sequences =  new ArrayList<>();
	
	public static void main(String[] args)
	{
		GetSequence(6, 0); //3 layers of brackets
		for(String str : sequences)
		{
			System.out.println(str);
		}
	}
}
