/* Dan Matheson
 * 1/31/17
 * This program contains methods that will make changes to a word that is passed into them. 
 */
public class WordTransformer {

	//This private constructor will prevent the user from creating an instance of the WordTransformer class
	private WordTransformer(){

	}
	// return 'theWord' with the first letter capitalized 
	static String makeCapital (String theWord){
		String letter;
		//This will set the letter variable to the first letter
		letter = "" + theWord.charAt(0);
		//This will remove the first letter of the word and replace it with a blank space
		theWord = theWord.replaceFirst(letter, "");
		//This will change the first letter to an upper case letter
		letter = letter.toUpperCase();
		//This will add the upper case letter back into the word and return the word
		theWord = letter + theWord;
		return theWord;
	}
	// return 'theWord' with the first letter in lowercase 
	static String lowerCase (String theWord){

		String letter;
		//This will set the letter variable to the first letter
		letter = "" + theWord.charAt(0);
		//This will remove the first letter of the word and replace it with a blank space
		theWord = theWord.replaceFirst(letter, "");
		//This will change the first letter to a lower case letter
		letter = letter.toLowerCase();
		//This will add the lower case letter back into the word and return the word
		theWord = letter + theWord;
		return theWord;
	}
	// return 'theWord' in all uppercase 
	static String upperCaser (String theWord) {

		//This will change the word to all upper case letters and return it
		theWord = theWord.toUpperCase();
		return theWord;
	}
	// return 'theWord' in all lowerCase
	static String lowerCaser (String thePhrase) {

		//This will change the word to all lower case letters and return it
		thePhrase = thePhrase.toLowerCase();
		return thePhrase;
	}

	/* this method will take the every even/odd pair of letters and swaps them.
	 * In the case of an odd length word, the last letter will not move.
	 * Example theWord = "Super"
	 * returns "uSepr"
	 */
	static String ezEncrypt (String theWord) {

		int count = 0;
		String letter1;
		String letter2;
		String [] letters = new String[theWord.length()];
		String word = "";

		//This will set all of the letters in the letter array to the jumbled letters
		while(count< (theWord.length() - 1)){
			letter1 = "" + theWord.charAt(count);
			letter2 = "" + theWord.charAt(count + 1);
			letters[count + 1] = letter1;
			letters[count] = letter2;
			count+=2;
		}

		//This if statement will catch if the word length is odd and will add the last letter to the last spot in the letters array
		if (theWord.length() % 2 == 1)
			letters[theWord.length() - 1] = "" + theWord.charAt(theWord.length() - 1);

		//This for loop will put the letters back together and will make the word whole again
		for(int i = 0; i < theWord.length(); i++){
			word+=letters[i];
		}
		return word;
	}

	//This method is the same method as ezEncrypt and will return the word back to normal
	static String ezDecrypt (String theWord) {
		int count = 0;
		String letter1;
		String letter2;
		String [] letters = new String[theWord.length()];
		String word = "";

		while(count< (theWord.length() - 1)){
			letter1 = "" + theWord.charAt(count);
			letter2 = "" + theWord.charAt(count + 1);
			letters[count + 1] = letter1;
			letters[count] = letter2;
			count+=2;
		}
		if (theWord.length() % 2 == 1)
			letters[theWord.length() - 1] = "" + theWord.charAt(theWord.length() - 1);
		for(int i = 0; i < theWord.length(); i++){
			word+=letters[i];
		}
		return word;
	}
}
