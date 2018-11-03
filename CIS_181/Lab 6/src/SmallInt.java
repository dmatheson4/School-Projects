/* Dan Matheson
 * 3/21/17
 * This program will take in a string and store it to a private variable. It will also be able to take in an integer from a different class and 
 * add, subtract, multiply, or divide the two integers.
 */
public class SmallInt {
	private int smallInt;

	//Method to parse the string to an int.
	public int setValue(String s){
		int temp;
		//This will try to set the small int to the value of s.
		try{
			temp = Integer.parseInt(s);
			smallInt = temp;
			return 0;
		}
		//If it cannot parse the string to an integer it will return -1.
		catch(Exception e){
			return -1;
		}
	}
	
	//Method to return the value of the small integer.
	public int getValue(){
		return smallInt;
	}
	
	//Method to add the two integers together.
	public int add(SmallInt sInt){
		//This will check if the integers will be out of the range when being added.
		if(((smallInt + sInt.getValue()) <= Integer.MIN_VALUE) || ((smallInt + sInt.getValue()) >= Integer.MAX_VALUE)){
			return 0;
		}
		return (smallInt + sInt.getValue());
	}
	
	//Method to subtract the two integers.
	public int subtract(SmallInt sInt){
		//This will check if the integers will be out of the range when being subtracted.
		if(((smallInt - sInt.getValue()) <= Integer.MIN_VALUE) || ((smallInt - sInt.getValue()) >= Integer.MAX_VALUE)){
			return 0;
		}
		return (smallInt - sInt.getValue());
	}
	
	//Method to multiply the two integers.
	public int multiply(SmallInt sInt){
		//This will check if the integers will be out of the range when being multiplied.
		if(((smallInt * sInt.getValue()) <= Integer.MIN_VALUE) || ((smallInt * sInt.getValue()) >= Integer.MAX_VALUE)){
			return 0;
		}
		return (smallInt * sInt.getValue());
	}
	
	//Method to divide the two integers.
	public int divide(SmallInt sInt){
		//This will check if the integers will be out of the range when being divided, or if the denominator is zero.
		if(sInt.getValue() == 0 || (smallInt / sInt.getValue()) <= Integer.MIN_VALUE || ((smallInt / sInt.getValue()) >= Integer.MAX_VALUE)){
			return 0;
		}
		return (smallInt / sInt.getValue());
	}
}
