/**
 * @author Haiping Xu
 * Created on Nov 13, 2008
 */
public class CircularDoublyLinkedListTest {

    // Displays the items on the list aList
    public static void displayList(ExtendedListInterface aList) throws ListException {
        Object dataItem;

        for (int index = 1; index < aList.size(); index++){
            dataItem = aList.get(index);
            System.out.print(dataItem + ", ");
        }
        if (aList.size() >= 1) {
            dataItem = aList.get(aList.size());
            System.out.println(dataItem + ".");
        } else {
            throw new ListException("displayList on an empty list");
        }
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList aList = new CircularDoublyLinkedList();

        try {
            aList.add(1, "aa");
            aList.add(2, "bb");
            aList.add(3, "cc");
            aList.add(4, "dd");
            aList.add(5, "ee");
            displayList(aList);

            aList.remove(3);
            displayList(aList);
        } catch (ListException e) {}

        try {
            aList.removeAll();
            aList.addFirst("bb");
            aList.addFirst("aa");
            aList.addLast("cc");
            displayList(aList); // print out "aa, bb, cc."

            aList.removeFirst();
            aList.removeLast();
            displayList(aList); // print out "bb."

            aList.removeLast();
            displayList(aList); // print out "ListException: displayList on an empty list"
        } catch(ListException e) {}

        try {
            aList.removeLast(); // a ListException is thrown from the called method
            displayList(aList); // this statement is ignored
        } catch (ListException e) {}
    }
}
