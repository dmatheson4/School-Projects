/* Dan Matheson
 * 12/4/16
 * This program will test the LoShuMagic class that I have made and make sure that I made the conditions of the Lo Shu Magic Square be true.
 */
public class LoShuClassTester {

	public static void main(String[] args) {
		
		LoShuMagic lsm = new LoShuMagic();
		int matrix[][] = new int[3][3];
		matrix[0][0] = 4;
		matrix[0][1] = 9;
		matrix[0][2] = 2;
		matrix[1][0] = 3;
		matrix[1][1] = 5;
		matrix[1][2] = 7;
		matrix[2][0] = 8;
		matrix[2][1] = 1;
		matrix[2][2] = 6;
		
		if(lsm.test(matrix)==true)
		{
			System.out.println("Test 1 passed");
		}else
		{
			System.out.println("Test 1 failed");
		}
		matrix[0][1] = 10;
		
		if(lsm.test(matrix)==false)
		{
			System.out.println("Test 2 passed");
		}else
		{
			System.out.println("Test 2 failed");
		}
	}

}
