package org.yasar.ds.matrix.subsquare;

//https://www.geeksforgeeks.org/given-n-x-n-square-matrix-find-sum-sub-squares-size-k-x-k/
public class SumofMaxSubSquare {
	
	// A simple function to find sum of all  
    //sub-squares of size k x k in a given  
    // square matrix of size n x n 
    static void printSumSimple(int mat[][], int k, int n) 
    { 
  
        // k must be smaller than or  
        // equal to n 
        if (k > n) return; 
          
        // row number of first cell in  
        // current sub-square of size k x k 
        for (int i = 0; i < n-k+1; i++) 
        { 
              
            // column of first cell in current  
            // sub-square of size k x k 
            for (int j = 0; j < n-k+1; j++) 
            { 
                  
                // Calculate and print sum of  
                // current sub-square 
                int sum = 0; 
                for (int p = i; p < k+i; p++) 
                    for (int q = j; q < k+j; q++) 
                        sum += mat[p][q]; 
  
                System.out.print(sum+ " "); 
            } 
          
            // Line separator for sub-squares  
            // starting with next row 
            System.out.println(); 
        } 
    } 
      
    // Driver Program to test above function 
    public static void main(String arg[]) 
    { 
    	int n =5;
        int mat[][] = {{1, 1, 1, 1, 1}, 
                       {2, 2, 2, 2, 2}, 
                       {3, 3, 3, 3, 3}, 
                       {4, 4, 4, 4, 4}, 
                       {5, 5, 5, 5, 5}}; 
        int k = 3; 
        printSumSimple(mat, k, n); 
    } 

}
