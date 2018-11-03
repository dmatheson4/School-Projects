/* Dan Matheson
 * 10/27/16
 * This program will get numbers from the user using the RunningTotal class and print the results when the user is done entering values.
 */
package Lab7Part1;

public class MainClass {

	public static void main(String[] args) {

		//Create an instance of the RunningTotal class
		RunningTotal user = new RunningTotal();

		//Run the method to get integers from the user
		user.getNumbersFromUser();

		//Print out the results of the numbers that were entered to the screen
		System.out.println("The average of the numbers you entered is " + user.getAverage());
		System.out.println("The sum of the numbers you entered is " + user.getSum());
		System.out.println("The product of the numbers you entered " + user.getProduct());
	}
}
