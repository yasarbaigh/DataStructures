package oy.regex.test;

import org.junit.Test;

import oy.regex.PassworValidation;

public class PasswordValidationTest
{
	@Test
	public void lengthMatch()
	{
		String regex = "";

		//this look ahead, search for begin 8-31 chars, even its more than 32 it passess.
		regex = "^(?=.{8,31}).*$";
		
		//so to strict length to length to 31, $ is added after length group
		//.* required to pass other chars, this will fail - ^(?=.{8,31}$)$ - for not considering chars
		
		//regex = "^(?=.{8,31}$).*$";
		
		// this is valid
		//regex = "^(.){8,31}$";
				
		String[] passwords = new String[5];

		passwords[0] = "abcdefg";		
		passwords[1] = "abcdefghijklmnopqrstuvwxyz123456789";
		passwords[2] = "abcdefghijkl";
		passwords[3] = "123456789";
		passwords[4] = "          "; //10spaces
				
		System.out.println("Length Match");
		PassworValidation.checkValidPassword(regex, passwords);
	}
	
	@Test
	public void atleast1Number1LCase1UCaseMatch()
	{
		String regex = "";
		
		//if one group, like (?=.*[a-z]) is removed, then invalid passwords will succeed
		regex = "^(?=.{8,31}$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$";
		
		
		String[] passwords = new String[10];

		passwords[0] = "abcdefghi9";	//no UC
		passwords[1] = "ABCDEFGH9";		//no LC
		passwords[2] = "ABCDEFGHi";		//no Num
		passwords[3] = "abcdefghij";	//no UC, NUM
		passwords[4] = "ABCDEFGHIJ";	//no LC, NUM
		passwords[5] = "123456789";		//no lc, uc,
		passwords[6] = "        ";		//no lc, uc, num
		passwords[7] = "Ab34567";		//length failed
		passwords[8] = "Ab#45678901234567890123456789012";		//32length -failed
		
		passwords[9] = "Ab34567@";		//passed	
		
				
		System.out.println("Atleast 1-Number, 1-eLCase, 1-OneUCase Match");
		PassworValidation.checkValidPassword(regex, passwords);
	}
	
	@Test
	public void atleast1SpecialCharacterMatch()
	{
		//SpecialChar
		//!@#$%^&*()+-*/\'?:.{}[]_~
		String regex = "";
		
		//if one group, like (?=.*[a-z]) is removed, then invalid passwords will succeed
		regex = "^(?=.{8,31}$)(?=.*[!@#$%^&\\[\\*\\]])(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$";
		
		
		String[] passwords = new String[14];

		passwords[0] = "abcdefghi9";	//no UC
		passwords[1] = "ABCDEFGH9";		//no LC
		passwords[2] = "ABCDEFGHi";		//no Num
		passwords[3] = "abcdefghij";	//no UC, NUM
		passwords[4] = "ABCDEFGHIJ";	//no LC, NUM
		passwords[5] = "123456789";		//no lc, uc,
		passwords[6] = "        ";		//no lc, uc, num
		passwords[7] = "Ab34567";		//length failed
		passwords[8] = "Ab#45678901234567890123456789012";		//32length -failed
		
		passwords[9] = "Ab34567*";		//Failed
		passwords[10] = "Ab3456&@";		//passed	
		passwords[11] = "Ab3456]8";		//passed
		
		passwords[12] = "Ab345*78";		//passed		
		passwords[13] = "Ab3456[8";		//passed
				
		System.out.println("Atleast 1-Number, 1-eLCase, 1-OneUCase Match");
		PassworValidation.checkValidPassword(regex, passwords);
	}



}
