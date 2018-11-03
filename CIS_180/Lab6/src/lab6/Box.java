/* Dan Matheson
 * 10/17/16
 * This class will allow boxes to be created and the class will store the width, length, height, and label name to private variables.
 * The class will also give information about the boxes through public methods. 
 */
package lab6;

public class Box {

	//private class attributes
	private double width;
	private double length;
	private double height;
	private String label;

	//private constructors
	@SuppressWarnings("unused")
	private Box(){
		
		//By having a private constructor, outside users can not create an instance
		//with a default constructor :-D
	}

	//This is one of the constructors for the box class that will take the variables width, length, height, and label in order to create the box
	public Box(double w, double l, double h,String name){
		
		//Fill in code to copy w, l, h, name to width, length, height, label respectively
		width = w;
		length = l;
		height = h;
		label = name;
	}

	public Box(Box cloneMe){
		
		//This if statement will run if there is no information in the cloneMe variable
		if(cloneMe==null)return;

		//These next four lines will copy the length, width, height, and label name to this box from the cloned box
		this.length = cloneMe.length;
		this.width = cloneMe.width;
		this.height = cloneMe.height;
		this.label = cloneMe.label + " Clone";//This will also add the word "Clone" to the name so that it is known that this box is a clone
	}

	//This method will return the width of the box
	public double getWidth() {
		return width;
	}

	//This method will return the length of the box
	public double getLength() {
		return length;
	}

	//This method will return the height of the box
	public double getHeight() {
		return height;
	}

	//This method will return the label of the box
	public String getLabel() {
		return label;
	}
	
	//This method will calculate the volume of the box and return it
	public double getVolume(){
		double volume = length * width * height;
		return volume;
	}


}