package org.yasar.ds.string;

public class LargestCmnString
{

	char[] A, B;
	int[][] memoizingL;

	int lcs_length(String AA, String BB)
	{
		A = AA.toCharArray();
		B = BB.toCharArray();
		memoizingL = new int[A.length + 1][B.length + 1];

		for (int i = 0; i <= A.length; i++)
			for (int j = 0; j <= B.length; j++)
				memoizingL[i][j] = -1;

		return subproblem(0, 0);
	}

	int subproblem(int i, int j)
	{
		if(memoizingL[i][j] < 0)
		{
			if(i == A.length || j == B.length)
				memoizingL[i][j] = 0;

			else if(A[i] == B[j])
				memoizingL[i][j] = 1 + subproblem(i + 1, j + 1);
			else
				memoizingL[i][j] = Math.max(subproblem(i + 1, j),
						subproblem(i, j + 1));
		}
		return memoizingL[i][j];
	}
	
	public static void main(String[] args)
	{
		LargestCmnString objt = new LargestCmnString();
		System.out.println(objt.lcs_length("ABCD", "AseerBkCertDjljlC"));
	}
	
}
