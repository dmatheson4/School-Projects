/* Dan Matheson
 * 10/27/16
 * This program will use a do-while loop to loop 50 times and print what iteration of the loop it is on.
 */
public class DoWhileConversion {

	public static void main(String[] args) {
		
		//Declare the looping variable
		int loopVariable = 0;
		
		//Beginning of the do-while loop
		do{
			//Print out what iteration of the loop that it is on
			System.out.println("Loop Iteration # " + loopVariable);
			loopVariable++;
		}while(loopVariable < 50);//Runs the loop while this statement is false
	}
}