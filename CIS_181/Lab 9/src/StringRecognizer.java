/* Dan Matheson
 * 4/10/17
 * This program will test to see if a string is in the w$w language. It will use a stack to push and pop elements of the stack to see if
 * the entry is part of the language.
 */
public class StringRecognizer {

	/**
	 * precondition: none
	 * @param s: input string for testing
	 * @return true is s is in the language L = {w$w': w is a possibly empty string of characters
	 * 			other than $, w' = reverse(w)}; otherwise return false.
	 */
	boolean recognizeString(String s){	
		boolean answer = false;
		int index = 0;
		StackArrayBased stack = new StackArrayBased();
		
		//Runs through the string up until the '$'
		while(index != s.length() && !stack.isFull() && s.charAt(index) != '$'){
			//Pushes a character to the stack at the index
			stack.push(s.charAt(index));
			index++;//Increment index
		}
		
		//This will advance the index if the '$' was found
		if(index < s.length() && s.charAt(index) == '$'){
			index++;//Increment index
		}
		
		//This will run through the rest of the string after the '$'
		while(index!=s.length()){
			
			//If the stack is empty or the next character does not equal the character that is popped it will return false
			if(stack.isEmpty() || s.charAt(index) != (char)stack.pop()){
				return answer;
			}
			index++;//Increment index
			
			//If it was able to run through the entire array, and the stack is empty, then it will set the answer to true
			if(index == s.length() && stack.isEmpty()){
				answer = true;
			}
		}
		
		//This will check if the user entered just a '$'
		if(s.length() == 1 && s.charAt(0) == '$')
			return true;
		
		//This will return the answer
		return answer;
	}
	
}
