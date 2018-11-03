/* Dan Matheson
 * 2/14/17
 * This program contains the acker function that will manipulate two integers recursively and keep track of the number of iterations and result.
 */

public class AckerFunction{
	private int spaces = 0;
	private int numberOfInvocations = 0;

	//getter for data field "numberOfInvocations"
	public int countOfInvocations(){
		return numberOfInvocations;
	}
	//Run the recursive Acker Function
	public int acker(int m, int n){
		int result = 0;
		//Print the number of spaces and enter method message.
		printSpaces();
		System.out.println("Enter method acker: m = " + m + ", n = " + n);
		numberOfInvocations++;//increment the number of invocations.

		//If m is zero then this if will return n + 1.
		if(m == 0){
			printSpaces();
			spaces--;//Decrement the number of spaces.
			result = n + 1;
			System.out.println("Leave method acker: acker(" + m + ", " + n + ") = " + result);
			return result;
		}
		//If n is zero then this if will run the method again with parameters (m-1,1).
		else if(n == 0){
			spaces++;//Increment the number of spaces.
			result = acker(m - 1, 1);
			printSpaces();
			System.out.println("Leave method acker: acker(" + m + ", " + n + ") = " + result);
			return result;
		}
		//If m or n are not zero then the program will run the method again with (m-1,acker(m,n-1)).
		else{
			spaces++;//Increment the number of spaces.
			result = acker(m - 1, acker(m, n - 1));
			printSpaces();
			System.out.println("Leave method acker: acker(" + m + ", " + n + ") = " + result);
			return result;
		}
	}
	//Indent the trace messages according to how "deep" the current recursive call is.
	//To be called by method acker only.
	private void printSpaces(){
		for (int i = 0; i < spaces; i++)            
			System.out.print("    ");
	}
}