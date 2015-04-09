package org.yasar.ds.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AnagramPrint
{

	public static void main(String[] args)
	{
		//stringPermutation("TESTPERMUTATION");
		stringPermutation("ABC");
		permute("ABC");
	}

	public static void stringPermutation(String str)
	{
		if(str == null)
			return;
		doPermutation("", str);

	}

	public static void doPermutation(String prefix, String str)
	{
		if(str.length() == 1)
		{
			System.out.println(prefix + str);
			return;
		}
		for (int i = 0; i < str.length(); i++)
		{
			doPermutation(prefix + str.charAt(i), removeCharAt(str, i));
		}
	}

	public static String removeCharAt(String str, int index)
	{
		StringBuilder sb = new StringBuilder(str);
		sb.deleteCharAt(index);
		return sb.toString();
	}
	
	
	//===================================================
	
	/**
	 * Without Recursion
	 * 
	 * 
	 * @param s
	 */
	public static void permute(String s) {
	    if(null==s || s.isEmpty()) {
	        return;
	    }

	    // List containing words formed in each iteration 
	    List<String> strings = new LinkedList<String>();
	    strings.add(String.valueOf(s.charAt(0))); // add the first element to the list

	     // Temp list that holds the set of strings for 
	     //  appending the current character to all position in each word in the original list
	    List<String> tempList = new LinkedList<String>(); 

	    for(int i=1; i< s.length(); i++) {

	        for(int j=0; j<strings.size(); j++) {
	            tempList.addAll(merge(s.charAt(i), strings.get(j)));
	                        }
	        strings.removeAll(strings);
	        strings.addAll(tempList);

	        tempList.removeAll(tempList);

	    }

	    for(int i=0; i<strings.size(); i++) {
	        System.out.println(strings.get(i));
	    }
	}

	/**
	 * helper method that appends the given character at each position in the given string 
	 * and returns a set of such modified strings 
	 * - set removes duplicates if any(in case a character is repeated)
	 */
	private static Set<String> merge(Character c,  String s) {
	    if(s==null || s.isEmpty()) {
	        return null;
	    }

	    int len = s.length();
	    StringBuilder sb = new StringBuilder();
	    Set<String> list = new HashSet<String>();

	    for(int i=0; i<= len; i++) {
	        sb = new StringBuilder();
	        sb.append(s.substring(0, i) + c + s.substring(i, len));
	        list.add(sb.toString());
	    }

	    return list;
	}
}

