package org.yasar.ds.string;

// https://www.youtube.com/watch?v=5e63aHK6Q-E
public class StringRotaionCheck_KMP_Algm_P {

	public boolean isS2Rotated_Of_S1(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}

		// concat s1 twice, so obvious, tat if its rotated, sub-string might exist
		String s3 = s1 + s1;

		if (s1.contains(s2)) {
			return true;
		}

		return false;

	}
}
