package oy.ds.number;

public class PowerofAB
{
	
	/**
	 * calculates power atO(n)
	 * 
	 * @param base
	 * @param power
	 * @return base^power
	 */
	public static double calculatePowerAtOrderN(double base, int power)
	{
		if(power == 0)
		{
			return 1;
		}
		else if(base == 0)
		{
			return 0; 
		}
		
		final boolean negativePower = power < 0? true: false;
		if(negativePower)
		{
			power = -power;
		}
		int count = 1;
		double poweredValue = base;
		while(count <power)
		{
			poweredValue *= base;
			count++;
		}
		return negativePower ? 1/poweredValue : poweredValue;
	}
	
	
	/**
	 * calculates power atO(logn)
	 * 
	 * @param base
	 * @param power
	 * @return base^power
	 */
	public static double calculatePowerAtOrderLogN(double base, int power)
	{
		if(power == 0)
		{
			return 1;
		}
		else if(base == 0)
		{
			return 0; 
		}
		
		final boolean negativePower = power < 0? true: false;
		if(negativePower)
		{
			power = -power;
		}
		
		final double poweredValue = recursivePowerCalculateLogN(base, power);		
		return negativePower ? 1/poweredValue : poweredValue;
	}
	
	private static double recursivePowerCalculateLogN(double poweredValue, int power)
	{
		
		if(power == 1)
		{
			return poweredValue;
		}
		else if(power%2 == 1)
		{
			return recursivePowerCalculateLogN(poweredValue*poweredValue, power/2) * poweredValue;
		}
		else
		{
			return recursivePowerCalculateLogN(poweredValue*poweredValue, power/2);			
		}
	}
	
	/**
	 * calculates power atO(logn) non-Recursive
	 * 
	 * @param base
	 * @param power
	 * @return base^power
	 */
	public static double nonRecurPowerAtOrderLogN(double base, int power)
	{
		if(power == 0)
		{
			return 1;
		}
		else if(base == 0)
		{
			return 0; 
		}
		
		final boolean negativePower = power < 0? true: false;
		
		if(negativePower)
		{
			power = -power;
		}
		
		double poweredValue = base;
		boolean isOddPower = false;
		double factor = 1;
		while(power > 0)
		{	
			if(power%2 !=0)
			{
				isOddPower = true;
				factor *= base;
			}
			poweredValue *= poweredValue;
			power /= 2;
		}
		poweredValue = isOddPower ? poweredValue * factor : poweredValue;
		return negativePower ? 1/poweredValue : poweredValue;
	}
	
	public static int powFast(int x, int n) {
		// Holds next power
	    // Will be used if next bit is set (odd)
		int intermediateProduct = x;
	    // Final result
		int result = 1;


	    // Repeat this till we iterate all the set bits
	    while(n > 0)
	    {
	        // Effectively equvalent to n%2
	        //if (n & 1)
	    	if (n %2 ==1)
	        {
	            // If n is odd
	            // power(a, b) = a * power(a, b/2) * power(a, b/2)
	            // Note that next two terms are picked in the down statement
	            result = intermediateProduct * result;
	        }



	        // Make up next bit
	        n >>= 1;



	        // Make the multiplication for next bit
	        // Contributes for multiplication when n is even
	        // power(a, b) = power(a, b/2) * power(a, b/2)
	        intermediateProduct = intermediateProduct * intermediateProduct;
	    }



	    // Done! Return.
	    return result;
	}
}
