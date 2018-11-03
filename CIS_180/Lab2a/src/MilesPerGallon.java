/*Dan Matheson
 * Sep. 22, 2016
 * This Program will calculate the miles per gallon of a car using the values of miles traveled and number of gallons consumed.
 */

public class MilesPerGallon {

	public static void main(String[] args) {
		double miles = 120, gallons = 4, mpg;	//declaring variables

		mpg = miles/gallons;	//calculating miles per gallon
		System.out.println("You are getting " + mpg + " miles to the gallon!");	//Printing miles to the gallon to the screen
	}
}