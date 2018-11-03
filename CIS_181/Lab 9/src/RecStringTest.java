import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RecStringTest {
	// you need change this value if you need a bigger stack
  public static final int MAX_ITEMS = 50;

  public static void main(String[] args) {
	  // test if Stack works
	  testStack();
	  
	  String input = getInput();
	  StringRecognizer recognizer = new StringRecognizer();
	  
	  boolean solution = recognizer.recognizeString(input);
	   if (solution){
		   System.out.print("input is in language w$w'");
	   }else{
		   System.out.print("input is not in language w$w'");
	   }    
  } // end main
  
  public static String getInput(){
	  InputStreamReader isr = new InputStreamReader(System.in);
	  BufferedReader br = new BufferedReader(isr);
	  String lines = null;
	  System.out.print("Please type a string for testing in language w$w':");
	    try {
    		lines = br.readLine();
    	} catch (Exception e) {
    		System.out.print("Not a valid input\n");
    	}
    	System.out.println("input is:"+lines);
    	return lines;
  }
  
  public static void testStack(){
	  StackArrayBased stack = new StackArrayBased();
	    Integer items[] = new Integer[MAX_ITEMS];
	    for (int i=0; i<MAX_ITEMS; i++) {
	      items[i] = new Integer(i);
	      if (!stack.isFull()) {
	        stack.push(items[i]);
	      }  // end if
	    }  // end for
	    while (!stack.isEmpty()) {
	      // cast result of pop to Integer
	      System.out.println((Integer)(stack.pop()));
	    }  // end while
  }
  
} // end StackTest