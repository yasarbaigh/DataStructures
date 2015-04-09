package oy.ds.string;

public class WildCardMatcher
{
	
	public static void main(String[] args)
	{
		System.out.println(wildCardMatching("2004yasABCarDEF.doc", "*yasar*.doc"));
	}
	public static boolean wildCardMatching(String matcher, String pattern)
	{
		if(pattern == null || matcher == null || pattern.length() == 0
				|| matcher.length() == 0) {
			return false;
		}

		char[] patternArray = pattern.toCharArray(), testArray = matcher.toCharArray();
		int i = 0, j = 0, len = patternArray.length, len2 = matcher.length();

		int prevStar = -1;
		while (i < len && j < len2) {
			if(patternArray[i] == '?' || patternArray[i] == testArray[j]) {
				i++;
				j++;
			}
			else if(patternArray[i] == '*') {
				prevStar = i-1;
				i++;
				
			}
			else if(patternArray[i] != testArray[j]) {
				j++;
				i = prevStar;
			}

		}

		if(j < len2) {
			if(i == len) {
				if(patternArray[i - 1] != '*')
					return false;
			}
			else {
				return false;
			}
		}

		if(i < len) {
			return false;
		}

		return true;
	}
}
