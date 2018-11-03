/* Dan Matheson
 * 10/11/16
 * This class will hold all of the information to private data types for one specific pet that is stored to a instance in the main method.
 * The class can also give and set the names using the public methods.
 */

package lab5Conversion;

public class Pet {
	
	//Class Private Data Members
	private String petName;
	private int petAge;
	private String petType; //Cat, Dog, Ferret, etc
	private String petOwner;
	
	//Constructor
	public Pet(){
		
	}
	
	//Public Methods
	//This method will return the pet name as a string
	public String getPetName() {
		return petName;
	}

	//This method will set the pet name to a string that is passed in
	public void setPetName(String name) {
		petName = name;
	}

	//This method will return the pets age as an integer
	public int getPetAge() {
		return petAge;
	}

	//This method will set the pets age to an integer that is passed in
	public void setPetAge(int age) {
		petAge = age;
	}

	//This method will return the pets type as a string
	public String getPetType() {
		return petType;
	}

	//This method will set the pets type to a string that is passed in
	public void setPetType(String type) {
		petType = type;
	}

	//This method will return the pet owners name as a string
	public String getPetOwner() {
		return petOwner;
	}

	//This method will set the pet owners name to a string that is passed in
	public void setPetOwner(String owner) {
		petOwner = owner;
	}
}