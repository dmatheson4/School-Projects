/*Dan Matheson
 * Sep. 22, 2016
 * This program will calculate the gross pay of the user based on the number of hours they work and their hourly rate.
 */

public class Payroll {

	public static void main(String[] args) {
		int hours = 40;						//declaring variables
		double grossPay, payRate = 25.0;

		grossPay = hours * payRate; //Calculating gross pay
		System.out.println("Your gross pay is $" + grossPay);	//Printing gross pay to the console
	}
}