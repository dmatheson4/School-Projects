/* Dan Matheson
 * 2/7/17
 * This program contains static methods that will check if a date entered is valid, and that will be able to advance the date forward by one day. 
 * It also has a method to print the date out.
 */

public class Date {
	private int month;
	private int day;
	private int year;

	public Date() {
		month = 1;
		day = 1;
		year =2006;
	}

	public Date (int m, int d, int y){
		month = m;
		day = d;
		year =y;
	}

	// -----------------------------------------------------------------------------
	// Check if a date is valid.
	// Preconditon: mon, day and year are integers.
	// Postcondtion: If the combination of mon, day and year represents a valid date,
	//       a true value is returned; othereise, a false value is returned.
	// -----------------------------------------------------------------------------
	public static boolean isLegitimate(int mon, int day, int year){

		// February has 29 days in any year evenly divisible by four,
		// EXCEPT for centurial years which are not also divisible by 400.


		// TODO 1: Check if a date is valid.
		//Check to make sure the year is valid
		if(year<=0){
			return false;
		}
		//This if statement will check if the date entered is a valid date in April, June, September, and November
		if(mon == 4||mon == 6||mon == 9||mon == 11||mon == 12 && day >= 1 && day <=31){
			return true;
		}
		//This if statement will check if the date entered is a valid date in January, March, May, July, August, October, and December.
		else if(mon != 2 && mon >= 1 && mon <= 10 && day >= 1 && day <=30){
			return true;
		}
		//This if statement will check if the date entered is in February and valid.
		else if(mon == 2){
			//This if statement will check if it is a valid leap year date or not.
			if(year % 4 == 0 && (year % 100 !=0 || year % 400 == 0) && day >=1 && day <=29)
				return true;
			//This if statement will check if it is a valid non leap year date or not.
			else if(day >= 1 && day <= 28)
				return true;
		}
		return false;
	}

	// -----------------------------------------------------------------------------
	// Advance a given date by one day
	// Preconditon: aDate is a valid date
	// Postcondtion: aDate is a new valid date that is increased by one day
	// -----------------------------------------------------------------------------
	public static void advanceDate(Date aDate) {

		// TODO 2: Implement this method to advance aDate by one day.
		//This if statement will handle all of the possible advancements for April, June, September, and November.
		if(aDate.month == 4||aDate.month == 6||aDate.month == 9||aDate.month == 11||aDate.month == 12 && aDate.day >= 1 && aDate.day <=31){
			//Handle the new year.
			if(aDate.day == 31){
				if(aDate.month == 12){
					aDate.month = 1;
					aDate.day = 1;
					aDate.year++;
				}
				//This if statement will catch if it is the last day of the month.
				else{
					aDate.month++;
					aDate.day = 1;
				}	
			}
			else{
				aDate.day++;
			}
		}
		// This if statement will handle all of the possible advancements for January, March, May, July, August, October, and December.
		else if(aDate.month != 2 && aDate.month >=1 && aDate.month <= 10 && aDate.day >= 1 && aDate.day <=30){
			//Handle the change of a month.
			if(aDate.day == 30){
				aDate.month++;
				aDate.day = 1;
			}
			else{
				aDate.day++;
			}
		}
		//This if statement will handle all of the possible advancements for the month of February.
		else if(aDate.month == 2){
			//Check if it is a leap year.
			if(aDate.year % 4 == 0 && (aDate.year % 100 !=0 || aDate.year % 400 == 0) && aDate.day >=1 && aDate.day <=29){
				//Handle the change of the month during leap year.
				if(aDate.day == 29){
					aDate.month++;
					aDate.day = 1;
				}
				else{
					aDate.day++;
				}
			}
			//Check if it is not a leap year.
			else if(aDate.day >= 1 && aDate.day <= 28){
				//Handle the change of month.
				if(aDate.day == 28){
					aDate.month++;
					aDate.day = 1;
				}
				else{
					aDate.day++;
				}
			}
		}
	}
	//Method to print out the month, day, and year
	public void display(String s){
		System.out.println(s + month + "/" + day + "/" + year);
	}
}
