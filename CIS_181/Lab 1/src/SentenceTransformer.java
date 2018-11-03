/* Dan Matheson
 * 1/31/17
 * This program will modify a phrase that is passed into the methods and return the modified phrase.
 */
public class SentenceTransformer {

	//This private constructor will prevent the user from creating an instance of the SentenceTransformer class
	private SentenceTransformer(){

	}
	// take 'thePhrase' and return only the first word
	static String firstWord (String thePhrase) {
		//This will split the phrase based on the '\"' characters and will return the first phrase it finds
		String[] phrase = thePhrase.split("\"");
		return phrase[0];
	}
	// take 'thePhrase' and return the entire phrase except the first word
	static String lastWords (String thePhrase) {
		//This will split the phrase based on the '\"' characters and will return the second phrase it finds
		String[] phrase = thePhrase.split("\"");
		return phrase[1];
	}
	/* take 'thePhrase' and return the number of times 'letter' occurs in it 
	 * example:    SentenceTransformer.countCharacter("This is one boring lab", 'o') 
	 * would return 2
	 */
	static int countCharacter(String thePhrase,char letter){

		//This for loop will cycle through all of the characters in the string and compare them to the letter that is passed in, then count the number of times that character occurred
		int counter = 0;
		for (int i = 0; i < thePhrase.length(); i++){
			if(thePhrase.charAt(i) == letter)
				counter++;
		}
		return counter;
	}
	/* take 'thePhrase' and remove '.' '!' and '?' characters
	 * from it and replace them with ' ' (spaces)
	 */
	static String depunctuate (String thePhrase){

		//This if statement will replace any '.' characters with a space
		if(thePhrase.contains(".")){
			thePhrase = thePhrase.replace(".", " ");
		}
		//This if statement will replace any '!' characters with a space
		if(thePhrase.contains("!")){
			thePhrase = thePhrase.replace("!", " ");
		}
		//This if statement will replace any '?' characters with a space
		if(thePhrase.contains("?")){
			thePhrase = thePhrase.replace("?", " ");
		}
		return thePhrase;
	}
}
