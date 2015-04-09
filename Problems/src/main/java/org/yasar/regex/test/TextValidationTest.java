package oy.regex.test;

import org.junit.Test;

import oy.regex.PassworValidation;

public class TextValidationTest
{
	@Test
	public void lengthMatch()
	{
		String regex = "";

		//to find url begins with http:// or https://
		regex = "^((http://)|(https://)).*$";	
		
				
		String[] passwords = new String[5];

		passwords[0] = "http";		
		passwords[1] = "https";
		passwords[2] = "https://asdas";
		passwords[3] = "http://asdas";
		passwords[4] = "http:///sdfs"; //10spaces
				
		System.out.println("Length Match");
		PassworValidation.checkValidPassword(regex, passwords);
	}

}
