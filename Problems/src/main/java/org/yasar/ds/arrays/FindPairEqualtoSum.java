package org.yasar.ds.arrays;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.yasar.logger.MyLogger;

/**
 * 
 * http://stackoverflow.com/questions/4720271/find-a-pair-of-elements-from-an-array-whose-sum-equals-a-given-number
 * 
 * avoid duplicates
 * @author jyasar
 *
 */
public class FindPairEqualtoSum
{
	static final Logger logger = MyLogger.getLog4jLogger(FindPairEqualtoSum.class);
	
	/**
	 * Using codaddict's algorithm
	 * 
	 * @param array
	 * @param sumValue
	 */
	public static void findPairsofSum(int[] array, int sumValue)
	{
		if(array == null || array.length == 1)
		{
			throw new RuntimeException("invalid inputs");
		}
		
		Map<Integer, Integer> numMaps = new HashMap<>();
		
		//fails for this set of pair, 7,2,3,4,7 with sum 10
		for(int i=0; i< array.length; i++)
		{
			if(numMaps.containsKey(array[i]))
			{
				logger.info("Pair : " + array[i] + ", "+ numMaps.get(array[i]));
			}
			else
			{
				numMaps.put(sumValue - array[i], array[i]);
			}
		}
	}
}
