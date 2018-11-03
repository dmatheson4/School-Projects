/* Dan Matheson
 * 4/4/17
 * This program will serve as a doubly linked list that can have many different functions operated on it.
 */

/////////////////////////////////////////////////////////////
// Circular Linked List that implements ExtendedListInterface
/////////////////////////////////////////////////////////////

public class CircularDoublyLinkedList implements ExtendedListInterface {
	private DoublyNode head; // the head reference to the dummy head node
	private int numItems;    // number of items in list

	public CircularDoublyLinkedList() {
		numItems = 0;

		// create a dummy head node
		head = new DoublyNode(null);
		head.setPrev(head);
		head.setNext(head);
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public int size() {
		return numItems;
	}

	// -------------------------------------------------------------------
	// Locates a specified node in a linked list.
	// Precondition: index is the number of the desired node. Assumes that
	// 1 <= index <= numItems+1
	// Postcondition: Returns a reference to the desired node.
	// -------------------------------------------------------------------
	private DoublyNode find(int index) {
		DoublyNode curr = head;

		// due to the dummy head, we skip nodes for index times
		for (int skip = 1; skip <= index; skip++) {
			curr = curr.getNext();
		}
		return curr;
	}

	public Object get(int index) throws ListException {
		if (index >= 1 && index <= numItems) {
			// get reference to node, then data in node
			DoublyNode curr = find(index);
			Object dataItem = curr.getItem();
			return dataItem;
		} else {
			throw new ListException("List index out of bounds exception " +
					"on get: " + index);
		}
	}

	// Reuse the get method with appropriate parameter
	public Object getFirst() throws ListException {
		if (size() >= 1) {
			return get(1);
		} else {
			throw new ListException("getFirst on an empty list");
		}
	}

	// To locate the last node without a traversal, DO NOT call the method get
	// in this method. Access the last node through head.getPrev().
	public Object getLast() throws ListException {
		if (size() >= 1) {
			DoublyNode lastNode =  head.getPrev();
			return lastNode.getItem();
		} else {
			throw new ListException("getLast on an empty list");
		}
	}

	// Insert the new node containing item at position index. Refer to
	// Figure 4-30 in the textbook on page 196.
	public void add(int index, Object item) throws ListException {
		// due to the dummy head, index == 1 is not a special case!
		if (index >= 1 && index <= numItems+1) {
			DoublyNode prev = find(index-1);
			DoublyNode curr = prev.getNext();

			DoublyNode newNode = new DoublyNode(item);
			newNode.setPrev(prev);
			newNode.setNext(curr);
			prev.setNext(newNode);
			curr.setPrev(newNode);

			numItems++;
		} else {
			throw new ListException("List index out of bounds exception " +
					"on add: " + index);
		}
	}

	// Reuse the method add in this method with appropriate parameter.
	public void addFirst(Object item) throws ListException {

		DoublyNode newNode = new DoublyNode(item);
		//This will add to the first slot if the list is not empty
		if(!isEmpty()){
			//Set a nextNode pointer to keep track of the node after the new node
			DoublyNode nextNode;
			nextNode = head.getNext();

			nextNode.setPrev(newNode);//Set the next nodes previous pointer
			newNode.setNext(nextNode);//Set the new nodes next pointer
			newNode.setPrev(head);//Set the new nodes previous pointer
			head.setNext(newNode);//Set the heads next pointer
		}
		//This will add to the first slot if the list is empty
		else{
			head.setNext(newNode);//Set the head next pointer to the new node
			head.setPrev(newNode);//Set the head prev pointer to the new node
			newNode.setNext(head);//Set the new node next pointer to the head
			newNode.setPrev(head);//Set the new node prev pointer to the head
		}
		numItems++;//Increment number of items
	}

	// To locate the last node without a traversal, DO NOT call the method add
	// in this method.
	public void addLast(Object item) throws ListException {
		DoublyNode newNode = new DoublyNode(item);
		//This will add an item to the last spot in the list if the list is not empty
		if(!isEmpty()){
			//Set a prevNode pointer to keep track of the node before the new node
			DoublyNode prevNode;
			prevNode = head.getPrev();

			head.setPrev(newNode);//Set the heads previous pointer
			newNode.setPrev(prevNode);//Set the new nodes previous pointer
			newNode.setNext(head);//Set the new nodes next pointer
			prevNode.setNext(newNode);//Set the previous nodes next pointer
		}
		//This will add an item to the last spot in the list of an empty list
		else{
			head.setNext(newNode);//Set the head next pointer to the new node
			head.setPrev(newNode);//Set the head prev pointer to the new node
			newNode.setNext(head);//Set the new node next pointer to the head
			newNode.setPrev(head);//Set the new node prev pointer to the head
		}
		numItems++;//Increment number of items
	}

	// Delete the node at position index of the list. Refer to Figure 4-29
	// in the textbook on page 195.
	public void remove(int index) throws ListException {
		//Check to make sure the index is in a valid location
		if (index >= 1 && index <= numItems+1) {
			DoublyNode prev = find(index-1);//Set the previous pointer to the item before the one to be removed
			DoublyNode next = find(index+1);//Set the next pointer to the item after the one to be removed

			prev.setNext(next);//Set the next pointer of the previous node
			next.setPrev(prev);//Set the previous pointer of the next node

			numItems--;//Decrement the number of items
		} 
		//This will check if the user is trying to remove an item from an empty list
		else if(isEmpty()){
			throw new ListException("Remove from empty list exception");
		}
		//This will check if the user is trying to remove an item from the wrong index position
		else {
			throw new ListException("List index out of bounds exception on remove: " + index);
		}
	}

	// Reuse the method remove in this method with appropriate parameter.
	public void removeFirst() throws ListException {
		//This will check if the user is trying to remove from an empty list
		if(isEmpty()){
			throw new ListException("Remove from empty list exception");
		}
		//Set the nextNode pointer past the first element in the list
		DoublyNode nextNode;
		nextNode = head.getNext().getNext();

		nextNode.setPrev(head);//Set the next nodes previous pointer
		head.setNext(nextNode);//Set the heads next pointer
		numItems--;//Decrement number of items
	}

	// To locate the last node without a traversal, DO NOT call the method remove
	// in this method.
	public void removeLast() throws ListException {
		//This will check if the user is trying to remove from an empty list
		if(isEmpty()){
			throw new ListException("Remove from empty list exception");
		}
		//Set the prevNode pointer before the last element in the list
		DoublyNode prevNode;
		prevNode = head.getPrev().getPrev();

		head.setPrev(prevNode);//Set the heads previous pointer
		prevNode.setNext(head);//Set the prev nodes next pointer
		numItems--;//Decrement number of items
	}

	public void removeAll() {
		// create a dummy head
		head = new DoublyNode(null);
		head.setPrev(head);
		head.setNext(head);
		numItems = 0;
	}
}