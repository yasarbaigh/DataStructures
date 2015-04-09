package org.yasar.ds.number;

import org.apache.log4j.Logger;
import org.yasar.logger.MyLogger;

public class SingleLineSwaps
{
	private static final Logger logger = MyLogger.getLog4jLogger(SingleLineSwaps.class);
	
	/**
	 * Swaps 2 elements in single line command, wo any temp variable
	 * 
	 * one more is there
	 * a = a+b;
	 * b = a - b;
	 * a = a - b;
	 * 
	 * @param a
	 * @param b
	 */
	public static void singleLineSwap2Nos(int a, int b)
	{
		logger.info("**** Before Swapping ****");
		logger.info("a = "+ a +", b = " + b);
		a = (a+b) - (b=a);
		logger.info("**** After Swapping ****");
		logger.info("a = "+ a +", b = " + b);
		logger.info(MyLogger.END_OF_MESSAGE);
	}
	
	
	/**
	 * 
	 * Swaps 3 elements in single line command, wo any temp variable
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	public static void singleLineSwap3Nos(int a, int b, int c)
	{
		logger.info("**** Before Swapping ****");
		logger.info("a = "+ a +", b = " + b + ", c = " + c);
		a = (a+b+c) - (b=c) - (c=a);
		logger.info("**** After Swapping ****");
		logger.info("a = "+ a +", b = " + b + ", c = " + c);
		logger.info(MyLogger.END_OF_MESSAGE);
	}


}
