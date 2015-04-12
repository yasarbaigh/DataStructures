package org.yasar.regex;

// http://www.geeksforgeeks.org/check-given-sentence-given-set-simple-grammer-rules/
/**
 * 

1. Sentence must start with a Uppercase character (e.g. Noun/ I/ We/ He etc.)
2. Then lowercase character follows.
3. There must be spaces between words.
4. Then the sentence must end with a full stop(.) after a word.
5. Two continuous spaces are not allowed.
6. Two continuous upper case characters are not allowed.
7. However the sentence can end after an upper case character.

Correct sentences -
   "My name is Ram."
   "The vertex is S."
   "I am single."
   "I love Geeksquiz and Geeksforgeeks."

Incorrect sentence - 
   "My name is KG."
   "I lovE cinema."
   "GeeksQuiz. is a quiz site."
   "  You are my friend."
   "I love cinema" 

 */
public class CheckSenetence {

	public static void main(String[] args) {
		/*input("small start char.");
		input("UPper start twice.");
		input("No-space-between-words.");
		input("Doest not have full-stop");
		input("Two   spaces.");
		input("Continuous upPEr case chars.");
		*/
		
		// positive
		
		/*input("My name is Ram.");
		input("The vertex is S.");
		input("I am single.");
		input("I love Geeksquiz and Geeksforgeeks.");
		*/
		//negative

		input("My name is KG.");
		input("I lovE cinema.");
		input("GeeksQuiz. is a quiz site.");
		input("  You are my friend.");
		input("I love cinema");
	}
	
	static void input(String str) {
		
		System.out.println("Input : " + str + " , Output :" + checkSentence(str));
	}
	
	public static String checkSentence(String str) {

		String flag = "All Rules Passed.";

		String rule1 = "^[A-Z]{1}.*$";

		String rule2 = "^[A-Z][^A-Z].*$";

		String rule3 = "^.*\\s.*$";		
		
		String rule4 = "^.*[\\.]$";
		
		//String rule5 = "(?=.*[\\s][\\s]).*$"; 
		String rule5 = "^.*\\s{2,}.*$";

		String rule6 = "(?=.*[A-Z]{2}).*$";

		if (!str.matches(rule1)) {

			return " Rule-1 Failed.";

		}

		if (!str.matches(rule2)) {

			return " Rule-2 Failed.";

		}
		
		if (!str.matches(rule3)) {

			return " Rule-3 Failed.";

		}
		
		if (!str.matches(rule4)) {

			return " Rule-4 Failed.";

		}
		
		if (str.matches(rule5)) {

			return " Rule-5 Failed.";

		}

		if (str.matches(rule6)) {

			return " Rule-6 Failed.";

		}
		return flag;
	}
}
