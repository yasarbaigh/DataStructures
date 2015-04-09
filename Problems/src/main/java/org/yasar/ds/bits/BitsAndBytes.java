package org.yasar.ds.bits;

import org.apache.log4j.Logger;
import org.yasar.logger.MyLogger;

/**
 * http://www.cs.arizona.edu/classes/cs335/spring11/AssignmentsS11/bit-manipulation-tutorial.pdf
 * 
 * 
 */
public class BitsAndBytes
{
	static final Logger logger = MyLogger.getLog4jLogger(BitsAndBytes.class);	
	
	/**
	 * Gives the binary value of integer
	 * 
	 * 
	 * @param number
	 * @return
	 */
	public static String getBinaryValue(int number)
	{	
		StringBuilder builder = new StringBuilder();
		
		logger.info("**** Binary String of " + number + " ****");
		//JAVA Api leaves, intial zeroes
		logger.info("via Java API : " + Integer.toBinaryString(number));
		for(int i=31;i>=0; i--)
		{
			//check whether given bit vlaue 0|1, 0 for 0 
			if( (number & (1 << i)) != 0)
			{
				builder.append("1");
			}
			else
			{
				builder.append("0");
			}			
		}
		logger.info("via Baig API : " + builder.toString());
		logger.info(MyLogger.END_OF_MESSAGE);
		return builder.toString();
	}
	
	/**
	 * Sets a bit value 1 to for any position index 0<=index<=31
	 *  
	 * @param integerNumber
	 * @param positionIndex
	 * 
	 * @return BinaryString of integerNumber after setting index postion.
	 */
	public static void setBitAtNPositon(int number, int positionIndex)
	{
		if(positionIndex < 0 || positionIndex>32)
		{
			logger.error("Position Index shoudl be 0<= index<=31");
			return;
		}	
		
		logger.info("**** Setting a Bit at index " + positionIndex + " for " + number + " ****");
		logger.info("Before Setting : " + getMyBinaryString(number));
		
		number |= (1 << positionIndex);
		logger.info("After Setting  : " + getMyBinaryString(number));
		logger.info(MyLogger.END_OF_MESSAGE);
	}
	
	
	/**
	 * condition (number & (1 << i)) check for bit is set to 0|1
	 * 
	 * 
	 * @param number
	 * @return No. of set bits of a given number
	 */
	public static int getNoOfSetBits(int number)
	{
		int count = 0;
		logger.info("**** Number of bits set in " + number + " ****");
		logger.info("via Java API : " + Integer.bitCount(number));
		for(int i=31;i>=0; i--)
		{
			if( (number & (1 << i)) != 0)
			{
				count++;
			}			
		}
		logger.info("via Baig API : " + count);
		logger.info(MyLogger.END_OF_MESSAGE);
		return count;
	}
	
	private static String getMyBinaryString(int number)
	{
		StringBuilder builder = new StringBuilder();
		for(int i=31;i>=0; i--)
		{
			if( (number & (1 << i)) != 0)
			{
				builder.append("1");
			}
			else
			{
				builder.append("0");
			}			
		}
		return builder.toString();
	}

}
