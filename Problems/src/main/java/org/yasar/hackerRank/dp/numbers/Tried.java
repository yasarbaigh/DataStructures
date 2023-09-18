package org.yasar.hackerRank.dp.numbers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Tried {

	// get-minimum-squares
	// https://practice.geeksforgeeks.org/problems/get-minimum-squares0538/1
	// https://www.youtube.com/watch?v=aJTCcyPrPOA&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=11
	
	// Holiday Tour cost problem
	//https://www.codingninjas.com/studio/problems/minimum-coins_2180776?leftPanelTab=0
	// https://www.youtube.com/watch?v=oZ_xAIGCXw4&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=13
	//https://www.youtube.com/watch?v=U5f__4we_Jc&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=12
	
	
	// Find Largest in Matrix
	// https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1
	// https://www.youtube.com/watch?v=MMr19RE7KYY&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=14
	
	
	// Mimum Triangulation socre in polygon
	// https://www.youtube.com/watch?v=Eo4G_LPCgX8&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=15
	// https://leetcode.com/problems/minimum-score-triangulation-of-polygon/submissions/
	

}




class Solution {

	public static int minimumCoins(int n, int[] days, int[] cost) {
	
		//Write your code here	
		//return solveRecursion(n, days, cost, 0);
		int [] dp = new int[n+1];
		Arrays.fill(dp, -1);
		//return solveMemoiztn(n, days, cost, 0, dp);	

		//return solveTabltn(n, days, cost, 0, dp);	

		return solveSO(n, days, cost);				
	}

	public static int solveSO(int n,  int[] days, int[] cost ) {
		int ans =0;
		
		ArrayList<Integer[]> arrayList = new ArrayList<Integer[]>();
		
		
		ArrayList<int[]> intArrays=new ArrayList<>();
		
		
		Queue<int[]> weekly_q = new ArrayDeque<>();
		
		
		
		Queue<int[]> montly_q = (Queue<int[]>) new ArrayList<int[]>();
		for(int i=0; i<days.length;i++) {
			

			while( !weekly_q.isEmpty() && weekly_q.peek()[0] +7 <= days[i]) {
				weekly_q.poll();
			}

			while( !montly_q.isEmpty() && montly_q.peek()[0] + 30 <= days[i]) {
				montly_q.poll();
			}

			int [] tw = {days[i], ans+cost[i]};
			weekly_q.add( tw);

			
			int [] tm = {days[i], ans+cost[i]};
			montly_q.add( tm);


			ans = Math.min(ans, Math.min(weekly_q.peek()[1], montly_q.peek()[1]));


		}
		return ans;
	}


	public static int solveTabltn(int n,  int[] days, int[] cost, int idx, int[] dp) {	
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		// since base-case is for N, then Bottom-up approach
		dp[n] = 0;
		
		for(int k=n-1; k>=0; k--) {

			// 1 day pass
			int c1 = cost[0] + dp[k+1] ;

			// 7 day pass
			int i= k;
			for( ; i<n && days[i] < days[k] +7; i++) {

			}
			int c7 = cost[1] + dp[i];

			// 30 day pass
			int j= k;
			for( ; j<n && days[j] < days[k] +30; j++) {

			}
			int c30 = cost[2] + dp[j] ;

			dp[k] = Math.min(c1, Math.min(c7, c30));

		}

		//since bottom-up approach
		return dp[0];
		
	}

	public static int solveMemoiztn(int n,  int[] days, int[] cost, int idx, int[] dp) {

		if(idx>=n){
			return 0;
	
		} 

		if(dp[idx] != -1) {
			return dp[idx];
		}

		// 1 day pass
		int c1 = cost[0] + solveMemoiztn(n, days, cost, idx+1, dp);

		// 7 day pass
		int i= idx;
		for( ; i<n && days[i] < days[idx] +7; i++) {

		}
		int c7 = cost[1] + solveMemoiztn(n, days, cost, i, dp);

		// 30 day pass
		int j= idx;
		for( ; j<n && days[j] < days[idx] +30; j++) {

		}
		int c30 = cost[2] + solveMemoiztn(n, days, cost, j, dp);

		return dp[idx] = Math.min(c1, Math.min(c7, c30));
	}

	public static int solveRecursion(int n,  int[] days, int[] cost, int idx) {

		if(idx>=n){
			return 0;
	
		} 

		// 1 day pass
		int c1 = cost[0] + solveRecursion(n, days, cost, idx+1);

		// 7 day pass
		int i= idx;
		for( ; i<n && days[i] < days[idx] +7; i++) {

		}
		int c7 = cost[1] + solveRecursion(n, days, cost, i);

		// 30 day pass
		int j= idx;
		for( ; j<n && days[j] < days[idx] +30; j++) {

		}
		int c30 = cost[2] + solveRecursion(n, days, cost, j);

		return Math.min(c1, Math.min(c7, c30));
	}

}
