package org.yasar.ds.stack;

// https://www.codingninjas.com/studio/problems/n-stacks-in-an-array_1164271?leftPanelTab=1

// https://www.javatpoint.com/implement-two-stacks-in-an-array

// https://www.youtube.com/watch?v=lrSXKLmnMV8

public class N_Stacks_InArray_Advanced_OS_Process {

	public static void main(String[] args) {

		N_Stacks_InArray_Advanced_OS_Process o1 = new N_Stacks_InArray_Advanced_OS_Process();
		o1.NStack(3, 6);
		System.out.println(o1.push(11, 1));
		System.out.println(o1.push(21, 2));
		System.out.println(o1.push(22, 2));

		System.out.println(o1.push(12, 1));
		System.out.println(o1.push(31, 3));
		System.out.println(o1.push(32, 3));

		System.out.println(o1.pop(2));
		System.out.println(o1.pop(1));
		System.out.println(o1.pop(3));

	}

	// Initialize your data structure.

	int freeSpace = 0;
	int[] next;
	int[] arr;
	int[] top;

	public void NStack(int N, int S) {
		// Write your code here.

		top = new int[N]; // N-Stacks
		next = new int[S];
		arr = new int[S];

		for (int i = 0; i < S - 1; i++) {
			// next of current-i, is free;
			next[i] = i + 1;
		}
		next[S - 1] = -1;

		for (int i = 0; i < N; i++) {
			// intializing all top-stacks to -1
			top[i] = -1;
		}

		freeSpace = 0;

	}

	// Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack,
	// and false otherwise.
	public boolean push(int x, int m) {
		// Write your code here.
		if (freeSpace == -1) {
			// arrary full;
			return false;
		}
		int pos = freeSpace;

		arr[pos] = x;

		freeSpace = next[pos];

		next[pos] = top[m - 1];

		top[m - 1] = pos;

		return true;
	}

	// Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise
	// returns the popped element.
	public int pop(int m) {

		if (top[m - 1] == -1) {
			// no item in stack
			return -1;
		}

		int pos = top[m - 1];
		top[m - 1] = next[pos];

		next[pos] = freeSpace;

		freeSpace = pos;

		return arr[pos];

	}
}
