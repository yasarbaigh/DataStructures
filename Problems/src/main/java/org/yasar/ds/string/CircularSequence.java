package org.yasar.ds.string;

import org.yasar.ds.string.points.Point;

// http://www.geeksforgeeks.org/check-if-a-given-sequence-of-moves-for-a-robot-is-circular-or-not/
public class CircularSequence {

	public final static int N = 0;
	public final static int E = 1;
	public final static int S = 2;
	public final static int W = 3;

	public static void main(String[] args) {

		checkCircular("GLGLGLG");  // circular
		checkCircular("GRGLGLGLGLG");	//its a loop,
		//to check we need put all points in a set, and if new-point contains true, then loop, return it
	}

	public static void checkCircular(String input) {

		Point point = new Point();

		int xDir = 0, yDir = 0;

		int i = 0;
		int currentDirection = N;
		char currentChar;

		while (i < input.length()) {

			currentChar = input.charAt(i);
			if (currentChar == 'L') {
				currentDirection = (currentDirection + 1) % 4;
			} else if (currentChar == 'R') {
				if (currentDirection == 0)
					currentDirection = 3;
				else
					currentDirection = currentDirection - 1;
			} else { // if (move == 'G')

				switch (currentDirection) {
				case N: {
					yDir++;
					break;
				}
				case E: {
					xDir++;
					break;
				}
				case S: {
					yDir--;
					break;
				}
				case W: {
					xDir--;
					break;
				}

				}
				point.x = xDir;
				point.y = yDir;

			}
			i++;

		}
		if (point.x == 0 && point.y == 0)
			System.out.println("Input  :" + input + ", Circular");
		else
			System.out.println("Output :" + input + ", Not-Circular");
	}
}
