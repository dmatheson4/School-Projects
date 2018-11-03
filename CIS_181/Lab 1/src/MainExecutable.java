/* Dan Matheson
 * 1/31/17
 * This program will use the SentenceTransformer and WordTransformer classes to modify a sentence and word, then print those results to a file
 */
import java.io.File;
import java.io.PrintWriter;

public class MainExecutable {

	public static void main(String[] args) {

		//This try-catch will catch if the program has a problem with writing to the file, and catch the exception
		try{
			
			//Declare new file and instance of PrintWriter
			File file = new File("Output.txt");
			PrintWriter outFile = new PrintWriter(file);

			//Print all of the information to the file
			String s = new String("Dr.Nick: \"Hello everybody!\"");
			outFile.println("firstWord: " + SentenceTransformer.firstWord(s));
			outFile.println("lastWords: " + SentenceTransformer.lastWords(s));
			outFile.println("countCharacter: " +SentenceTransformer.countCharacter(s, 'e')+" - e characters");
			outFile.println("depunctuate: " + SentenceTransformer.depunctuate(s));

			s = "philanthropist"; 
			String encrypted = WordTransformer.ezEncrypt(s);
			outFile.println("ezEncrpt: "+encrypted);
			outFile.println("ezDecrypt: " + WordTransformer.ezDecrypt(encrypted));
			outFile.println("lowerCaser: " + WordTransformer.lowerCaser(s));
			outFile.println("lowerCase: " + WordTransformer.lowerCase(s));
			outFile.println("upperCaser: " + WordTransformer.upperCaser(s));
			outFile.println("makeCapital: " + WordTransformer.makeCapital(s));
			outFile.close();
		}
		//This will catch any exception that occurs with the File and Printwriter
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}
