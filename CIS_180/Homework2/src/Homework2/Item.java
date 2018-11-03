/* Dan Matheson
 * 10/31/16
 * This class will allow the user to create an instance of Item. It is only possible to create an item if the four attributes of the item are used in the constructor.
 * It will also be possible to get all of the attributes of the item through methods that return them.
 */
package Homework2;

public class Item {

	//Declare the private attributes in the Item class
	private String name;
	private int quantity;
	private double price;
	private String upc;

	//This private constructor will keep people from creating instances of the Item class without entering the four attributes when creating the instance
	@SuppressWarnings("unused") //This will keep me sane. So I do not have to see the yellow triangle ;)
	private Item(){

	}

	//This constructor will allow people to create an instance of the class and set the values to the attributes
	public Item(String name, int qty, double price, String upc){
		this.name = name;
		quantity = qty;
		this.price = price;
		this.upc = upc;
	}

	//This method will return the name of the item
	public String getName(){
		return name;
	}

	//This method will return the quantity
	public int getQuantity(){
		return quantity;
	}

	//This method will return the price of the product
	public double getPrice(){
		return price;
	}

	//This method will return the upc of the product
	public String getUPC(){
		return upc;
	}
}
