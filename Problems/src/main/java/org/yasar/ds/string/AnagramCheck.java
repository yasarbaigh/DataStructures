package org.yasar.ds.string;

public class AnagramCheck
{
	/**
	 * Method 1 (Use Sorting)
		1) Sort both strings (ie. sort both strings using quicksort or any sorting algm)
		2) Compare the sorted strings
	 * 
	 * @return
	 */
	public boolean checkAnagramM1()
	{
		return false;
	}
	
	
	/**
	 *
	 * 1) Create count arrays of size 256 for both strings. Initialize all values in count arrays as 0.
2) Iterate through every character of both strings and increment the count of character in the corresponding count arrays.
3) Compare count arrays. If both count arrays are same, then return true.
	 * @return
	 */
	public static boolean checkAnagramM2(String anag1, String anag2)
	{	
		if(isStringNull(anag1) || isStringNull( anag2))
		{
			return false;
		}
		
		if(anag1.length() != anag2.length())
		{
			return false;
		}
		
		int checkArray[] = new int[256];
		
		for(int i = 0; i< anag1.length(); i++)
		{
			checkArray[(int)anag1.charAt(i)]++;
			checkArray[(int)anag2.charAt(i)]--;
		}
		
		for(int i=0;i< 256; i++)
		{
			if(checkArray[i] != 0)
			{
				return false;
			}
		}
		return true;
	}
	
	private static boolean isStringNull(String str)
	{
		if(str == null || str.length() == 0)
		{
			return true;
		}		
		return false;
	}
}
