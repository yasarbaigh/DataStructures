package oy.ds.arrays;
/**
 * http://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div
 * 
 * Given an array of numbers, nums, return an array of numbers products, where products[i] is the product of all nums[j], j != i.

	Input : [1, 2, 3, 4, 5]
	Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)]
      = [120, 60, 40, 30, 24]
	You must do this in O(N) without using division. 
 * @author jyasar
 *
 */
public class MutilplyElements
{
	int[] numbers;
	MutilplyElements(int[] array)
	{
		if(array == null || array.length == 0)
		{
			throw new RuntimeException("Empty Array");
		}
		numbers = array;
	}
	
	public int[] mutliplyElements()
	{	
		int[] productsAbove = new int[numbers.length];
		int[] productsBelow = new int[numbers.length];
		int[] productsArray = new int[numbers.length];
		int p = 1, i=0;
		
		for(; i<productsArray.length; i++)
		{
			productsBelow[i]  = p;
			p *= numbers[i];
		}
		
		for(i= numbers.length -1; i>=0; i--)
		{
			productsAbove[i]  = p;
			p *= numbers[i];
		}
		
		for(i=0; i<productsArray.length; i++)
		{
			productsArray[i] = productsBelow[i] * productsAbove[i];			
		}
		return productsArray;
		/*
		 * // Get the products below the curent index
p=1;
for(int i=0;i<N;++i)
{
  products[i]=p;
  p*=a[i];
}

// Get the products above the curent index
p=1;
for(int i=N-1;i>=0;--i)
{
  products[i]*=p;
  p*=a[i];
}
		 * 
		 * 
		 */
	}
}
