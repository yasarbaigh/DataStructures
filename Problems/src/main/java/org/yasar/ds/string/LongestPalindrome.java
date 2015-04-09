package oy.ds.string;

public class LongestPalindrome
{
	static int leftIndex = 0;
	static int rightIndex = 0;

	public static void calculatePalidromLength(int left, int right, String str)
	{
		int length = 0;
		while (left >= 0 && right < str.length())
		{
			if(str.charAt(left) == str.charAt(right))
			{
				length++;
				leftIndex = left;
				rightIndex = right;
				left--;
				right++;
			}
			else
			{
				break;
			}
		}
	}

	public static String getMaxPalidromSubString(String input)
	{
		int maxLengthSoFar = Integer.MIN_VALUE;
		String result = null;
		for (int i = 1; i < input.length() - 1; i++)
		{
			if(input.charAt(i - 1) == input.charAt(i + 1))
			{
				calculatePalidromLength(i - 1, i + 1, input);
				if((rightIndex - leftIndex) + 1 > maxLengthSoFar)
				{
					maxLengthSoFar = (rightIndex - leftIndex) + 1;
					result = input.substring(leftIndex, rightIndex);
				}
			}
			else if(input.charAt(i) == input.charAt(i + 1))
			{
				calculatePalidromLength(i, i + 1, input);
				if((rightIndex - leftIndex) + 1 > maxLengthSoFar)
				{
					maxLengthSoFar = (rightIndex - leftIndex) + 1;
					result = input.substring(leftIndex, rightIndex + 1);
				}
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		String result = getMaxPalidromSubString("forgeeksskeegfor");
		//String result = GetPalindromeString("HYTBCABADEFGHABCDEDCBAGHTFYW12345678987654321ZWETYGDE");
		System.out.println(result);
	}
}
