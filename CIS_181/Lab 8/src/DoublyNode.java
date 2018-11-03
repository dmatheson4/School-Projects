/**
 * @author Haiping Xu
 * Created on Nov 13, 2008
 */

public class DoublyNode {

    private Object item;
    private DoublyNode prev;
    private DoublyNode next;

    // constructors
    public DoublyNode() {}

    public DoublyNode(Object newItem) {
        item = newItem;
        prev = null;
        next = null;
    }

    public DoublyNode(Object newItem, DoublyNode prevNode, DoublyNode nextNode) {
        item = newItem;
        prev = prevNode;
        next = nextNode;
    }

    // mutators
    public void setItem(Object newItem) {
        item = newItem;
    }

    public void setPrev(DoublyNode prevNode) {
        prev = prevNode;
    }

    public void setNext(DoublyNode nextNode) {
        next = nextNode;
    }

    // accessors
    public Object getItem() {
        return item;
    }

    public DoublyNode getPrev() {
        return prev;
    }

    public DoublyNode getNext() {
        return next;
    }
}
