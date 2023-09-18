package org.yasar.hackerRank.dp.numbers;

import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/number-of-ways_3755252
// https://www.youtube.com/watch?v=Wct0mN2SCRQ&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=10
public class NumberOfWaysElementsSelectedForTarget {

	

	    public static int findWays(int num[], int tar) {
	       //return solveRecursion(num,  tar);
	       int [] dp = new int[tar+1];
	       Arrays.fill(dp, -1);
	       //return solveMemoiztn(num,  tar, dp);

	       return solveTabltn(num, tar, dp);
	    }


	public static int solveTabltn(int num[],  int tar, int[] dp) {
	        // in dp-tabltn, fill with 0 values
	        Arrays.fill(dp, 0);
	        dp[0] = 1;

	       for(int i=1;i<= tar;i++) {
	            for(int j=0;j< num.length;j++) {

	                if (i - num[j] >= 0) {
	                     dp[i] += dp[i- num[j]];
	                }
	           
	            }
	           
	       }

	        return dp[tar];
	    }


	     public static int solveMemoiztn(int num[],  int tar, int[] dp) {
	        
	        if(tar<0) {
	            return 0;
	        }

	        if(tar==0) {
	            return 1;
	        }

	        if(dp[tar] != -1){
	            return dp[tar];
	        }

	        int cnt = 0;

	       for(int i=0;i< num.length;i++) {
	           cnt += solveMemoiztn(num, tar - num[i], dp);
	       }

	        return dp[tar] =  cnt;
	    }


	    public static int solveRecursion(int num[],  int tar) {
	        
	        if(tar<0) {
	            return 0;
	        }

	        if(tar==0) {
	            return 1;
	        }
	        int cnt = 0;

	       for(int i=0;i< num.length;i++) {
	           cnt += solveRecursion(num, tar - num[i]);
	       }

	        return cnt;
	    }

	   

	    
	}
