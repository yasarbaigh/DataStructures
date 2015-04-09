package oy.ds.arrays;

public class DuplicateInArray
{
	//***************************
	// Find duplicates in O(n) time and O(1) extra spacez
	//Given an array of n elements which contains elements from 0 to n-1
	//***************
	
	// http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/

	static void printRepeating(int arr[])
	{
		int i;
		System.out.println("The repeating elements are: \n");
		for (i = 0; i < arr.length; i++) 
		{
			if(arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + ", ");
		}
	}

	// Method 1 : Bubble sort technique
	
	//Char array of [256]/[1,0] acts as a flage
	
	//HashSet
	
	
	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
		//this array set, printRepeating will fail, since condition elements values should be less than array.length
		//int arr[] = { 100, 200, 300, 100, 300, 600, 600 };
		
		
		printRepeating(arr);
	}

}
