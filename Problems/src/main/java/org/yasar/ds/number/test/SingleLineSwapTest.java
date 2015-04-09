package org.yasar.ds.number.test;

import org.junit.Test;
import org.yasar.ds.number.SingleLineSwaps;

public class SingleLineSwapTest
{
	//fails for int boundary conditions, since addtn values assigned to int once again.
	@Test
	public void singleLine2SwapTest()
	{
		SingleLineSwaps.singleLineSwap2Nos(50,  7);
	}
	
	@Test
	public void singleLine3SwapTest()
	{
		SingleLineSwaps.singleLineSwap3Nos(50,  7, 23);
	}

}
