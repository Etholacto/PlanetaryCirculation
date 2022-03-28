// A list of bodies implemented as a linked list.
// The number of elements of the list is not limited.
public class BodyLinkedList {

    //TODO: declare variables.

    // Initializes 'this' as an empty list.
    public BodyLinkedList() {

        //TODO: define constructor.
    }

    // Initializes 'this' as an independent copy of the specified list 'list'.
    // Calling methods of this list will not affect the specified list 'list'
    // and vice versa.
    // Precondition: list != null.
    public BodyLinkedList(BodyLinkedList list) {

        //TODO: define constructor.
    }

    // Inserts the specified element 'body' at the beginning of this list.
    public void addFirst(Body body) {

        //TODO: implement method.
    }

    // Appends the specified element 'body' to the end of this list.
    public void addLast(Body body) {

        //TODO: implement method.
    }

    // Returns the last element in this list.
    // Returns 'null' if the list is empty.
    public Body getLast() {

        //TODO: implement method.
        return null;
    }

    // Returns the first element in this list.
    // Returns 'null' if the list is empty.
    public Body getFirst() {

        //TODO: implement method.
        return null;
    }

    // Retrieves and removes the first element in this list.
    // Returns 'null' if the list is empty.
    public Body pollFirst() {

        //TODO: implement method.
        return null;
    }

    // Retrieves and removes the last element in this list.
    // Returns 'null' if the list is empty.
    public Body pollLast() {

        //TODO: implement method.
        return null;
    }

    // Inserts the specified element 'body' at the specified position in this list.
    // Precondition: i >= 0 && i <= size().
    public void add(int i, Body body) {

        //TODO: implement method.
    }

    // Returns the element at the specified position in this list.
    // Precondition: i >= 0 && i < size().
    public Body get(int i) {

        //TODO: implement method.
        return null;
    }

    // Returns the index of the first occurrence of the specified element in this list, or -1 if
    // this list does not contain the element.
    public int indexOf(Body body) {

        //TODO: implement method.
        return -2;
    }

    // Removes all bodies of this list, which are colliding with the specified
    // body. Returns a list with all the removed bodies.
    public BodyLinkedList removeCollidingWith(Body body) {

        //TODO: implement method.
        return null;
    }

    // Returns the number of bodies in this list.
    public int size() {

        //TODO: implement method.
        return -1;
    }
}
