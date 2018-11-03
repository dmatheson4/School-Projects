/***********************************************************
 * Lab #4 (CIS 181)                           		        *
 * Submitted By: Dan Matheson                             	*
 * SID: 01511382                    						*
 * Date: 2/28/2017                            			  
 * This program will serve as the test program for the IntSet class. It will implement the methods in the IntSet class
 * to test for correctness.
 ***********************************************************/

package set;

public class TestIntSet {

	public static void main(String[] args) {
		int[] s = {2, 5, 11, 19, 35, 96};
		int[] t = {1, 2, 5, 6, 12, 35, 96};
		IntSet is = new IntSet(s);
		IntSet is2 = new IntSet(t);
		IntSet returnSet;

		// Test cases
		System.out.println("Before insertion: " + is.toString());
		is.insert(34);
		System.out.println("After insertion: " + is.toString());

		System.out.println("\nBefore insertion: " + is.toString());
		is.insert(-88);
		System.out.println("After insertion: " + is.toString());
		
		//Test case for removal
		System.out.println("\nBefore removal: " + is.toString());
		is.remove(11);
		System.out.println("After removal: " + is.toString());
		
		System.out.println("\nBefore removal: " + is.toString());
		is.remove(-12);
		System.out.println("After removal: " + is.toString());

		//Test case for the union
		System.out.println("\nBefore union: Set 1: " + is.toString() + ", Set 2: " + is2.toString());
		returnSet = is.union(is2);
		System.out.println("After union: " + returnSet.toString());
		
		//Test case for the intersection
		System.out.println("\nBefore intersection: Set 1: " + is.toString() + ", Set 2: " + is2.toString());
		returnSet = is.intersection(is2);
		System.out.println("After intersection: " + returnSet.toString());
		
		//Test case for complement
		System.out.println("\nBefore complement: " + is.toString());
		is.complement();
		System.out.println("After complement: " + is.toString());
	}

}