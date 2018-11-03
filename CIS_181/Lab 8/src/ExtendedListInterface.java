/**
 * @author Haiping Xu
 * Created on Nov 13, 2008
 */
///////////////////////////////////////////////////
// Interface ExtendedListInterface for the ADT list
///////////////////////////////////////////////////

public interface ExtendedListInterface {

    public boolean isEmpty();
    // Determines whether a list is empty.
    // Precondition: None.
    // Postcondition: Returns true if the list is empty, otherwise returns false.

    public int size();
    // Determines the length of a list.
    // Precondition: None.
    // Postcondition: Returns the number of items that are currently in the list.

    public void add(int index, Object item) throws ListException;
    // Adds an item to the list at position index.
    // Precondition: index indicates the position at which the item should be
    // inserted in the list.
    // Postcondition: If 1 <= index <= size()+1, item is added at position index
    // in the list, and other items are renumbered accordingly.

    public void addFirst(Object item) throws ListException;
    // Adds an item to the list at the begining of the list.
    // Precondition: None.
    // Postcondition: Item is added at the beginning of the list, and other items
    // are renumbered accordingly.

    public void addLast(Object item) throws ListException;
    // Adds an item at the end of the list.
    // Precondition: None.
    // Postcondition: Item is added at the end of the list, and other items are
    // renumbered accordingly.

    public Object get(int index) throws ListException;
    // Retrieves a list item by position.
    // Precondition: index is the position of the item to be retrieved.
    // Postcondition: If 1 <= index <= size(), the item at position index in the
    // list is returned.

    public Object getFirst() throws ListException;
    // Retrieves the first item in a list.
    // Precondition: None.
    // Postcondition: If size() >= 1, the item at the beginning of the list is
    // returned.

    public Object getLast() throws ListException;
    // Retrieves the last item in the list.
    // Precondition: None.
    // Postcondition: If size() >= 1, the item at the end of the list is returned.

    public void remove(int index) throws ListException;
    // Deletes an item from the list at a given position.
    // Precondition: index indicates where the deletion should occur.
    // Postcondition: If 1 <= index <= size(), the item at position index in the
    // list is deleted, and other items are renumbered accordingly.

    public void removeFirst() throws ListException;
    // Deletes the first item from the list.
    // Precondition: None.
    // Postcondition: If size() >= 1, the first item in the list is deleted, and
    // other items are renumbered accordingly.

    public void removeLast() throws ListException;
    // Deletes the last item from the list.
    // Precondition: None.
    // Postcondition: If size() >= 1, the item at the end of the list is deleted,
    // and other items are renumbered accordingly.

    public void removeAll();
    // Deletes all the items from the list.
    // Precondition: None.
    // Postcondition: The list is empty.
}
