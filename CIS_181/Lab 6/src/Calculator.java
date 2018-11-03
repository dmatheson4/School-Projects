/* Dan Matheson
 * 3/21/17
 * This program will use different classes to establish a GUI and take in two integers that is entered into the input line. 
 * It will then perform addition, subtraction, multiplication, and division on the integers.
 */

public class Calculator implements Process{
	protected final String PROMPT = "In the input line please enter two integers:";
	protected SmallInt smallInt1 = new SmallInt();
	protected SmallInt smallInt2 = new SmallInt();
	protected int numInts = 1;
	protected GUI gui;

	//Constructor.
	public Calculator(){
		//Creates an instance of the GUI class.
		gui = new GUI (this);
		gui.print(PROMPT);
	}

	//This method will process input from the GUI.
	public void processInput(String s){
		final String CLOSE_WINDOW_PROMPT = "\nThe execution of this project has " +
				"been completed.\nPlease close this window when you are ready.";
		int num;
		int add;
		int subtract;
		int multiply;
		int divide;
		boolean print = true;


		gui.print("\nInteger " + numInts + ": " + s);
		//This will run if it is taking in the first int from the input line.
		if(numInts == 1){
			num = smallInt1.setValue(s);//Set value of the first int.
			//This will check if the number could not be set.
			if(num == -1){
				gui.println("\nInvalid Entry For Integer 1!" + CLOSE_WINDOW_PROMPT);
				gui.freeze();
				print = false;
			}
			else
				numInts++;//Increment numInts to avoid setting the first value again.
		}
		//This will run if the program is taking the second number.
		else{
			num = smallInt2.setValue(s);//Set the value of the second int.
			//This will check if the number could not be set.
			if(num == -1){
				gui.println("\nInvalid Entry For Integer 2!" + CLOSE_WINDOW_PROMPT);
				gui.freeze();
				print = false;
			}
			//This will perform the add function.
			add = smallInt1.add(smallInt2);
			//This will make sure that the add function worked properly.
			if(add == 0 && (smallInt1.getValue() + smallInt2.getValue() != 0)){
				gui.println("\nInvalid Entry For Addition!" + CLOSE_WINDOW_PROMPT);
				gui.freeze();
				print = false;
			}
			//This will perform the subtract function.
			subtract = smallInt1.subtract(smallInt2);
			//This will check that the subtract function worked properly.
			if(subtract == 0 && (smallInt1.getValue() - smallInt2.getValue() != 0)){
				gui.println("\nInvalid Entry For Subtraction!" + CLOSE_WINDOW_PROMPT);
				gui.freeze();
				print = false;
			}
			//This will perform the multiply function.
			multiply = smallInt1.multiply(smallInt2);
			//This will check that the multiplication function worked properly.
			if(multiply == 0 && (smallInt1.getValue() != 0 || smallInt2.getValue() != 0)){
				gui.println("\nInvalid Entry For Multiplication!" + CLOSE_WINDOW_PROMPT);
				gui.freeze();
				print = false;
			}
			//This will perform the divide function.
			divide = smallInt1.divide(smallInt2);
			//This will check that the division function worked properly.
			if(smallInt2.getValue() == 0 || (divide == 0 && smallInt1.getValue() / smallInt2.getValue() !=0)){
				gui.println("\nInvalid Entry For Division!" + CLOSE_WINDOW_PROMPT);
				gui.freeze();
				print = false;
			}
			//This will print all of the values to the gui.
			if(print = true){
				gui.println("\nAddition: " + smallInt1.getValue() + " + " + smallInt2.getValue() + " = " + add);
				gui.println("subtraction: " + smallInt1.getValue() + " - " + smallInt2.getValue() + " = " + subtract);
				gui.println("Multiplication: " + smallInt1.getValue() + " * " + smallInt2.getValue() + " = " + multiply);
				gui.println("Division: " + smallInt1.getValue() + " / " + smallInt2.getValue() + " = " + divide);
				gui.println(CLOSE_WINDOW_PROMPT);
				gui.freeze();
				print = false;
			}
		}
	}
	//The main method creates an instance of the calculator class.
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
	}

}
