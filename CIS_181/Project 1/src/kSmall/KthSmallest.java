/* Dan Matheson
 * 3/17/17
 * This program will be able to find the kth smallest element in an array using partition and recursion methods.
 */

package kSmall;

public class KthSmallest {

	private  static void swap(int[] theArray, int i, int j){
		int temp = theArray[i];
		theArray[i] = theArray[j];
		theArray[j] = temp;
	}

	private static int partition(int[] theArray, int first, int last){
		int lastS1 = first;
		int lastS2 = (first +1);
		int tempLast = last;

		//This is a for loop that will run through the section of the array that is passed in through the first and last attributes.
		for(int i = first; i < last; i++){
			//This if statement will check if the pivot point value is greater than the value next in the array.
			if(theArray[lastS1] >= theArray[lastS2]){
				KthSmallest.swap(theArray, lastS1, lastS2);//Swap the two values being compared.
				lastS1++;//Increment the pivot point index.
				lastS2++;//Increment the value it was compared to.
			}

			//This if statement will check if the pivot point value is less than the value next in the array.
			else if(theArray[lastS1] < theArray[lastS2]){
				KthSmallest.swap(theArray, lastS2, tempLast);//This will swap the value that was compared with the temporary last value in the array.
				tempLast--;//This will decrement the temporary last index in the array.
			}
		}
		return lastS1;//Returns the index of the pivot element.
	}

	public static int kSmall(int k, int[] anArray, int first, int last){
		int pivotIndex = partition(anArray, first, last);//Runs the array through the partition algorithm.
		int p = anArray[pivotIndex];// p is the pivot.
		
		//This is the base case to return the pivot if the pivot index is equal to the value of k.
		if(pivotIndex == (k-1))
			return p;

		//This will handle the case where the pivot index is less than the value of k.
		if(pivotIndex < (k-1))
			return KthSmallest.kSmall(k, anArray, (pivotIndex + 1), last);

		//This will handle the case where the pivot index is more than the value of k.
		return KthSmallest.kSmall(k, anArray, first, (pivotIndex - 1));
	}
}