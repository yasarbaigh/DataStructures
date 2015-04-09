package org.yasar.ds.bits.test;

import org.junit.Test;
import org.yasar.ds.bits.BitsAndBytes;

public class BitsTest
{
	@Test
	public void testBinaryValue()
	{		
		BitsAndBytes.getBinaryValue(Integer.MAX_VALUE);
		BitsAndBytes.getBinaryValue(128);
		BitsAndBytes.getBinaryValue(0);
		System.out.println("Negative Value");
		BitsAndBytes.getBinaryValue(Integer.MIN_VALUE);
	}
	
	@Test
	public void testNoOfBitsSet()
	{	
		BitsAndBytes.getNoOfSetBits(Integer.MAX_VALUE);
		BitsAndBytes.getNoOfSetBits(0);
		System.out.println("Negative Value");
		BitsAndBytes.getNoOfSetBits(Integer.MIN_VALUE);
	}
	
	@Test
	public void testBitSet()
	{
		BitsAndBytes.setBitAtNPositon(1024, 30);
		BitsAndBytes.setBitAtNPositon(0, 30);
		BitsAndBytes.setBitAtNPositon(0, 0);
	}
}
