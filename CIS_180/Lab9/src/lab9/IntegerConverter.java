/* Dan Matheson
 * 11/15/16
 * This class contains static methods that can be used to change numbers from the base 10 system of counting to Hexadecimal, Binary, and Roman Numeral numbers.
 */
package lab9;

public class IntegerConverter {

	//This private constructor will make it so that an instance of the IntegerConverter class cannot be created
	private IntegerConverter(){

	}

	//This method will be used to convert an integer to a Hexadecimal number
	public static String toHex(int number)
	{
		String total = "";

		//If the number is negative, make it positive
		if(number<0)
		{
			number = number*-1;
		}

		//This loop will run while the number does not equal zero
		do{
			int value = number % 16;
			//If the value of 'value' is greater than 9, assign the appropriate letter
			switch(value){
			case 10:
				total+="A";
				break;
			case 11:
				total+="B";
				break;
			case 12:
				total+="C";
				break;
			case 13:
				total+="D";
				break;
			case 14:
				total+="E";
				break;
			case 15:
				total+="F";
				break;
			default:
				total+=value;

			}

			//divide out 16 and repeat
			number=number/16;
		}
		while(number!=0);

		//reverse the string
		total = (new StringBuilder(total)).reverse().toString();
		return total;
	}

	//This method is used to change an integer to Binary
	public static String toBinary(int number)
	{
		String total = "";

		//Fill in the code here:
		int count = 2;
		int powerOfTwo = 0;
		boolean isDone = false;

		//This if statement will run if the user entered a negative number
		if(number<0){
			number*=-1;
		}

		//This if statement will run if the user entered a 1
		if(number == 1){
			total+="1";
		}
		//This if statement will run if the user entered a 0
		else if(number == 0){
			total+="0";
		}
		//This else statement will run if the user entered a number greater than 1
		else{
			//This while loop will be used to find the greatest multiple of 2 that can go into the number
			while(isDone == false){
				//This if statement will run if the multiple of 2 being compared can go into the number 2 or more times
				if((number/count) >= 2){
					count+=count;
				}
				//This else statement will end the loop when the multiple of 2 only goes into the number once
				else{
					isDone = true;
				}
				powerOfTwo++;//Add one to the count of how many powers of two are added up
			}
			//Since the first number is going to be the highest value gathered from the loop above the first number added to total will be a 1
			total+="1";
			number-=count;//Subtract the greatest multiple of 2 that can be added from the number the user entered
			count/=2;//This will decrease the multiple of 2 by one power

			//This loop will run until the number is equal to zero
			while(number!=0 || powerOfTwo != 0){
				//This if statement will check if the number can be subtracted without making the number equal 1
				if((number / count) == 1){
					number-=count;//Subtract the current power of 2 from the number
					total+="1";
				}
				//This else statement will print a zero if the number cannot be subtracted without making the number equal 1
				else{
					total+="0";
				}
				count/=2;//Decrease the power of two
				powerOfTwo--;//Subtract one from the count of the power of two
			}
		}

		return total;
	}

	//This method is used to change an integer to a Roman Numeral
	public static String toRomanNumeral(int number)
	{
		/* 
		 * I = 1
		 * IV = 4
		 * V = 5
		 * IX = 9
		 * X = 10
		 * XL = 40
		 * L = 50
		 * XC = 90
		 * C = 100
		 * CD = 400
		 * D = 500
		 * CM = 900
		 * M = 1000
		 * 
		 * Rules
		 * the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
		 * X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
		 * C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern
		 * 
		 * 
		 */
		String total = "";

		//Fill in the code here:

		//This if statement will run if the user enters a negative number
		if(number < 0){
			number*=-1;
		}

		//This will run until the number equals zero
		while(number != 0){
			//This if statement will run if the user is entering a very large number so it does not have to print a lot of 'M's
			if(number > 10000){
				total = "M(x" + (number/1000) + ")";
				number-=((number/1000) * 1000);
			}
			//This if statement will run if you can subtract 1000 from the number
			else if((number - 1000) >= 0){
				total+="M";
				number-=1000;
			}
			//This if statement will run if you can subtract 900 from the number
			else if((number - 900) >= 0){
				total+="CM";
				number-=900;
			}
			//This if statement will run if you can subtract 500 from the number
			else if((number - 500) >= 0){
				total+="D";
				number-=500;
			}
			//This if statement will run if you can subtract 400 from the number
			else if((number - 400) >= 0){
				total+="CD";
				number-=400;
			}
			//This if statement will run if you can subtract 100 from the number
			else if((number - 100) >= 0){
				total+="C";
				number-=100;
			}
			//This if statement will run if you can subtract 90 from the number
			else if((number - 90) >= 0){
				total+="XC";
				number-=90;
			}
			//This if statement will run if you can subtract 50 from the number
			else if((number - 50) >= 0){
				total+="L";
				number-=50;
			}
			//This if statement will run if you can subtract 40 from the number
			else if((number - 40) >= 0){
				total+="XL";
				number-=40;
			}
			//This if statement will run if you can subtract 10 from the number
			else if((number - 10) >= 0){
				total+="X";
				number-=10;
			}
			//This if statement will run if you can subtract 9 from the number
			else if((number - 9) >= 0){
				total+="IX";
				number-=9;
			}
			//This if statement will run if you can subtract 5 from the number
			else if((number - 5) >= 0){
				total+="V";
				number-=5;
			}
			//This if statement will run if you can subtract 4 from the number
			else if((number - 4) >= 0){
				total+="IV";
				number-=4;
			}
			//This if statement will run if you can subtract 1 from the number
			else{
				total+="I";
				number-=1;
			}
		}

		return total;
	}

}