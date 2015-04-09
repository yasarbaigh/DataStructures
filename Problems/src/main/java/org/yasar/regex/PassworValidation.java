package oy.regex;

import org.apache.log4j.Logger;

import oy.ds.bits.BitsAndBytes;
import oy.logger.MyLogger;

public class PassworValidation
{
	
	static final Logger logger = MyLogger.getLog4jLogger(BitsAndBytes.class);
	
	/**
	 * password, should be of length 8-31, and atleast of the following
	 * one special Character
	 * one number
	 * one smallCase
	 * one upperCase
	 * 
	 * @param passwords
	 */
	public static void checkValidPassword(String regex, String... passwords) 
	{	
		for (String pass : passwords)
		{
			if(pass.matches(regex))
			{
				logger.info("Passes :-" + pass + "-");
			}
			else
			{
				logger.error("Failed :-" + pass + "-");
			}			
		}
		logger.info(MyLogger.END_OF_MESSAGE);
	}
}
