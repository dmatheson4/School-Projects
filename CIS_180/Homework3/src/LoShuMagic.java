/* Dan Matheson
 * 12/4/16
 * This program contains a single method to check a Lo Shu Magic Square and see if it is formatted properly. 
 * It will check if the square has only the numbers 1-9, and makes sure the rows, columns, and diagonals add up to the same number.
 */
public class LoShuMagic {

	public boolean test(int matrix[][]){
		
		//Declare attributes to be used in the method
		int compareTo = matrix[0][0] + matrix[0][1] + matrix[0][2];
		int number;
		boolean hasNum;

		//This for loop will run through the numbers 1-9 to make sure the matrix is properly populated
		for (int i = 1; i<10; i++){
			//Set the attribute number to the number the for loop is currently on
			number = i;
			hasNum = false;
			//These two nested for loops will run through all of the spots in matrix in order to compare the number attribute to each matrix spot
			for (int j = 0; j<3; j++){
				for (int k = 0; k<3; k++){
					//This if statement will check if the number is found and is not a duplicate
					if (matrix[j][k] == number && hasNum == false){
						hasNum = true;
					}
					//This if statement will check if the number has already been found and will return false because it would be a copied number
					else if(matrix[j][k] == number && hasNum == true){ 
						return false;
					}
				}
			}
			//This if statement will catch if the number was not found after going through the entire matrix and return false
			if (hasNum == false){
				return false;
			}
		}

		//These if statements will check if the rows, columns, and diagonals are not equal to each other, false will be returned if they are not equal
		//Compares first row to second row
		if((matrix[1][0] + matrix[1][1] + matrix[1][2]) != compareTo)
			return false;
		//Compares first row to third row
		else if((matrix[2][0] + matrix[2][1] + matrix[2][2]) != compareTo)
			return false;		
		//Compares first row to diagonal going from upper left to bottom right
		else if((matrix[0][0] + matrix[1][1] + matrix[2][2]) != compareTo)
			return false;
		//Compares first row to diagonal going from bottom left to upper right
		else if((matrix[2][0] + matrix[1][1] + matrix[0][2]) != compareTo)
			return false;
		//Compares first row to first column
		else if((matrix[0][0] + matrix[1][0] + matrix[2][0]) != compareTo)
			return false;
		//Compares first row to second column
		else if((matrix[0][1] + matrix[1][1] + matrix[2][1]) != compareTo)
			return false;
		//Compares first row to third column
		else if((matrix[0][2] + matrix[1][2] + matrix[2][2]) != compareTo)
			return false;
		
		//True will be returned if the matrix passes the tests above
		return true;
	}
}
