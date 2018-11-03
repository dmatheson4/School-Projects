/***********************************************************
 * Lab #4 (CIS 181)                 		               *
 * Submitted By: Dan Matheson   	                       *
 * SID: 01511382					                       *
 * Date: 2/28/2017                   
 * This program will be able to perform union, intersection, and complement on sets of numbers.             		   
 ***********************************************************/

package set;
/**
 * Created on Sept. 24, 2006
 * Provides for creating and manipulating sets of non-negative integers.
 * The set can contain non-negative integers (0...) with values from min...max.
 *
 */

public class IntSet {

	//Attributes
	private final int min = 0, max = 100;
	private boolean[] contents = new boolean[101];
	private int cardinality = 0; //maintains the number of elements in the set

	//Constructors

	//Postcondition: Creates an empty set, cardinality()==0 and
	// for all i, such that min<=i<=max, contents[i]==false
	public IntSet(){
		//all variables set when object is created
	}

	//Precondition: every element of values has the property min<=element<=max
	//Postcondition: For all x in values, such that min<=x<=max, contents[x]==true.
	public IntSet(int[] values){
		for (int i = 0; i < values.length; i++) {
			if (values[i] <= max && values[i] >= min ) {
				this.contents[values[i]] = true;
				this.cardinality++;
			}
		}
	}

	//Set Methods

	/**
	 * Precondtion: null
	 * Postcondition: return this.cardinality==0
	 */
	public boolean isEmpty(){
		return this.cardinality == 0;
	}

	/**
	 * Precondition: null
	 * Postcondition: return this.cardinality
	 */
	public int cardinality(){
		return this.cardinality;
	}

	/**
	 * Precondition: min<=element<=max
	 * Postcondition: return this.contents[element]
	 */
	public boolean isElement(int element){
		if (element >= min && element <= max) {
			return this.contents[element];
		} else {
			return false;
		}
	}

	/**
	 * Precondition: min<=element<=max and !isElement(element)
	 * Postcondition: this.contents[element] = true.  returns true if successful,
	 *                false otherwise
	 *
	 */
	public boolean insert(int element){

		if ((element <= max && element >= min) && !this.isElement(element)) {
			this.contents[element] = true;
			this.cardinality++;
			return true;
		} else {
			System.out.println("Precondition is NOT satisfied: element = " + element);
			return false;
		}
	}

	/**
	 * Precondition: min<=element<=max and isElement(element)
	 * Postcondition: this.contents[element] = false. returns true if successful,
	 *                false otherwise
	 *
	 */
	public boolean remove(int element){

		// TODO 1: implement the remove method.
		//If the element is true and in the range, this will remove it.
		if ((min <= element && max >= element) && this.isElement(element)){
			this.contents[element] = false;
			this.cardinality--;
			return true;
		}
		System.out.println("The number " + element + " is not in the set");
		return false;
	}

	//Operations

	/**
	 * Precondition: s is an IntSet object.
	 * Postcondition: returns a new set that is the union of this set and set s
	 */
	public IntSet union(IntSet s){
		IntSet newSet = new IntSet();

		// TODO 2: implement the union method.
		//This for loop will run through all of the array spots in both arrays and compare the booleans.
		for(int i = 0; i!=max; i++){
			//If one of the booleans is true, then it will set the new set spot to true as well.
			if(this.contents[i] == true || s.contents[i] == true){
				newSet.contents[i] = true;
				newSet.cardinality++;
			}
			//If both of the booleans are false, then it will set the new set spot to false.
			else
				newSet.contents[i] = false;
		}
		return newSet;
	}

	/**
	 * Precondition: s is an IntSet object.
	 * Postcondition: returns a new set that is the intersection of this set and set s
	 */
	public IntSet intersection(IntSet s){
		IntSet newSet = new IntSet();

		// TODO 3: implement the intersection method.
		//This for loop will run through all of the array spots in both arrays and compare the booleans.
		for(int i = 0; i<max; i++){
			//If both of the booleans are true, then it will set the new set spot to true as well.
			if(this.contents[i] == true && s.contents[i] == true){
				newSet.contents[i] = true;
				newSet.cardinality++;
			}
			//If one or none of the booleans is false, then it will set the new set spot to false.
			else
				newSet.contents[i] = false;
		}

		return newSet;
	}

	/**
	 * Precondition: null
	 * Postcondition: produces a new set representing those elements that are in the
	 *            universal set but not in this set, this set is unchanged.
	 */
	public IntSet complement(){
		IntSet newSet = new IntSet();

		// TODO 4: implement the complement method.
		//This for loop will run through all of the booleans in the contents array.
		for (int i = 0; i!=max; i++){
			//If the boolean is true, then it will be set to false.
			if(contents[i] == true){
				contents[i] = false;
				this.cardinality--;
			}
			//If the boolean is false or null, then it will be set to true.
			else{
				contents[i] = true;
				this.cardinality++;
			}
		}
		return newSet;
	}

	//Utilities

	/**
	 * Postcondition: returns a String representation of the calling Set. The
	 *  representation is {int, int, int} beginning with the smallest value
	 *  in the set to the largest from left to right.
	 */
	public String toString(){
		StringBuffer s = new StringBuffer();
		s.append("{");

		for (int i = 0; i <= max; i++) {
			if (this.contents[i]) {
				s.append(i + ", ");
			}
		}

		//remove the last "," and white space from the end of the stringbuffer
		if (s.length() > 1) {
			s.delete(s.length()-2, s.length());
		}
		s.append("}");

		return s.toString();
	}
}