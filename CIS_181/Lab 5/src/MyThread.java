/* Dan Matheson
 * 3/7/17
 * This program will manipulate the threads to do things like lowering its priority on the core, pausing the thread, and swapping between threads,
 * while printing a character.
 */
import java.util.concurrent.*;

public class MyThread extends Thread {

	//Declare the character array and static Semaphore.
	char character;
	static Semaphore s = new Semaphore(1, true);
	int NUMBER_OF_ITERATIONS = 1000;
	
	//Constructor for the MyThread class that takes a character as input.
	public MyThread(char entry){
		//Set the character to the entered character.
		character = entry;
	}

	//This is the run method for the class that will run the threads.
	public void run(){
		//For loop to run through the total number of iterations
		for(int i = 0; i < NUMBER_OF_ITERATIONS; i++){

			//This will acquire the Semaphore to use the thread.
			try {
				s.acquire();
			} 
			catch (InterruptedException e1) {
				System.out.println("Interrupted Error!");
			}
			//This will print the character.
			System.out.print(character);
			//This will lower the priority of the thread, and make allow it to give up its processor use.
			Thread.yield();
			
			//This will put the program to sleep for 1 millisecond.
			try {
				Thread.sleep(1);
			} 
			catch (InterruptedException e) {
				System.out.println("Interrupted Error!");
			}
			//This will release the thread so another thread may run.
			s.release();
		}
	}
}
