/* Dan Matheson
 * 3/7/17
 * This program will emulate two threads that are running on a single core.
 */
public class MainClass {

	public static void main(String[] args) {
		MyThread t1 = new MyThread('h');
		MyThread t2 = new MyThread('a');
		
		//Start the threads
		t1.start();
		t2.start();
	}
}

/*	6.) When I ran the program a few times it would always print the h's before the a's.
 *  8.) When I ran the program a few times it would pick a random sequence to print out the h's and the a's. 
 * 	10.) When I ran the program a few times it would print them in a random sequence, but it would pause for a small amount of time after printing the letter.
 *  This happened because the sleep method will put the thread to sleep for a certain number of milliseconds, then continues the thread.
 */ 
