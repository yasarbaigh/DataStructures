package org.yasar.ds.stack;

import java.util.Stack;

public class ReverseStack<T> {

	public void reverse(Stack<T> s) {
		if (s.isEmpty())
			return;
		T last = getLast(s);
		// reverse the remaining stack
		reverse(s);
		// put the last element on the top
		s.push(last);
	}

	// retrieve and remove the deepest element of the stack
	public T getLast(Stack<T> s) {
		T a = s.pop();
		if (s.isEmpty()) {
			return a;
		} else {
			T last = getLast(s);
			s.push(a);
			return last;
		}
	}

	public static void main(String[] args) {
		ReverseStack<Integer> rsbr = new ReverseStack<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);

		
		
		System.out.println(s);
		rsbr.reverse(s);
		System.out.println(s);
	}

}