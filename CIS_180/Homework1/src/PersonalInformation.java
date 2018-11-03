/* Dan Matheson
 * 10/5/16
 * This program will use information that I have hard coded in to print my information to the console.
 */

public class PersonalInformation {

	public static void main(String[] args) {
		
		//Declare variables
		String name = "Dan Matheson", address = "42 Main Street", city = "Bridgewater", state = "MA";
		String zipCode = "02324", phoneNumber = "508-555-5555", collegeMajor = "Computer Science";
		
		//Print the information on different lines
		System.out.println("Name: " + name);
		System.out.println("Address: " + address + ", " + city + ", " + state + " " + zipCode);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("College Major: " + collegeMajor);
	}
}
