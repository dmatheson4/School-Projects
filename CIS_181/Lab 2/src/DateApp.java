/* Dan Matheson
 * 2/7/17
 * This program will allow a user to enter a date and use the Date class to check validity of the date, then print the next day to the user.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DateApp {

	public static void main(String[] args)  {
		String nextLine = "";
		int month = 1, day = 1, year = 2006;
		Date appointment = new Date();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		while(true){

			System.out.print("Input the date in the format of MM/DD/YYYY (enter \"q\" to quit): ");

			try {
				nextLine = stdin.readLine();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}

			if (nextLine.length() > 0 &&
					(nextLine.charAt(0) == 'q' || nextLine.charAt(0) == 'Q')) {
				System.out.println("Done!");
				System.exit(0);
			}

			// nextLine = nextLine.replaceAll("/", " ");

			StringTokenizer input = new StringTokenizer(nextLine,"/");
			try {
				month = Integer.parseInt(input.nextToken());
				day = Integer.parseInt(input.nextToken());
				year = Integer.parseInt(input.nextToken());
			} 
			catch (Exception e) {
				System.out.println("Invalid date! Please try again!");
				continue;
			}

			if (!Date.isLegitimate(month, day, year)) {
				System.out.println("Invalid date! Please try again!");
			} 
			else {
				appointment = new Date(month, day, year);
				appointment.display("The input date is: ");
				Date.advanceDate(appointment);
				appointment.display("The new date is: ");
			}
		}
	}
}
