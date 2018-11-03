/* Dan Matheson
 * 3/28/17
 * This program will serve as an ADT for the tester program. It will allow for the entry of items, removal of items, removal of all items,
 * and searching for an items index.
 */

public class SortedList implements SortedListInterface {
	private static final int MAX_LIST = 50;
	private Object items[];  // an array of list items
	private int numItems;    // number of items in list

	// default constructor
	public SortedList() {
		items = new Object[MAX_LIST];
		numItems = 0;
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public int size() {
		return numItems;
	}

	public Object get(int index) throws ListException {

		if (index >= 1 && index <= size()) {
			return items[index-1];
		} else  {  // index out of range
			throw new ListException("get (index out of range): " + index);
		}
	}

	public void removeAll() {
		items = new Object[MAX_LIST];
		numItems = 0;
	}

	// new operations: sortedAdd
	public void sortedAdd(Comparable newItem) throws ListException {
		int index = 0;

		//This will check if the list is full and throw an exception.
		if (size() == MAX_LIST)
			throw new ListException("add (array is full)");
		//This for loop will go through the array and check to make sure that the new item gets put in the right place.
		for(int i = 0; i < size(); i++){
			//This will increment the index as long as the new item is 'greater' than the item it is compared to.
			if(newItem.compareTo(items[i]) >= 0)
				index++;
		}
		//This will add the new item to the end of the array if the index is equal to the size.
		if(index == size()){
			items[index] = newItem;
		}
		//This will run if the new item needs to be added to the middle of the array.
		else{
			//This for loop will run through the end of the array to the index and move the items up one position in the array.
			for(int j = numItems; j > index; j--){
				items[j] = items[(j-1)];
			}
			items[index] = newItem;
		}
		numItems++;//Increment number of items
	}

	// new operation: sortedRemove
	public void sortedRemove(Comparable anItem) throws ListException {
		int index = -1;

		//This for loop will go through the array and try to find the index where the item exists.
		for(int i = 0; i < size(); i++){
			//If the item is found, then the index is set to that position.
			if(anItem.equals(items[i]))
				index = i;
		}
		//If the index could not be found, then an exception will be thrown.
		if(index == -1)
			throw new ListException("remove (item not found) : " + anItem);
		//This will run if the item could be found.
		else{
			//This will run through the array from the index to the end of the array and move the items down one position.
			for(int j = index; j < size(); j++){
				items[j] = items[(j+1)];
			}
			numItems--;//Decrement the number of items in the array.
		}
	}

	// new operation: locateIndex
	public int locateIndex(Comparable anItem) throws ListException {
		int index = -1;
		int shouldBe = 1;
		//This will go through the entire array and compare the item the user is looking for to the items in the array.
		for(int i = 0; i < size(); i++){
			//This will change the index if there is a item equal to the one the user is looking for.
			if(anItem.equals(items[i]))
				index = i;
			//This will increase the value of where the number should be in the case that an exception is thrown.
			if(anItem.compareTo(items[i]) >= 0){
				shouldBe++;
			}
		}
		//This will check if the item could not be found and throw an exception.
		if(index == -1)
			throw new ListException("locate (item not found): " + anItem + ". It should be in position " + shouldBe);
		return (index + 1);
	}
}