// A list of massive objects implemented as a linked list.
// The number of elements of the list is not limited.
public class MassiveLinkedList {

    //TODO: declare variables.
    MyListNode2 head, tail;

    // Initializes 'this' as an empty list.
    public MassiveLinkedList() {

        //TODO: define constructor.

    }

    // Initializes 'this' as an independent copy of the specified list 'list'.
    // Calling methods of this list will not affect the specified list 'list'
    // and vice versa.
    // Precondition: list != null.
    public MassiveLinkedList(BodyLinkedList list) {

        //TODO: define constructor.
        for (int i = 0; i < list.size(); i++) {
            this.addLast(list.get(i));
        }
    }

    // Inserts the specified element 'body' at the beginning of this list.
    public void addFirst(Massive body) {

        //TODO: implement method.
        if (head == null) {
            head = tail = new MyListNode2(body, null, null);
        } else if (head == tail) {
            head = new MyListNode2(body, null, head);
            tail.setPrev(head);
        } else {
            head = new MyListNode2(body, null, head);
            head.getNext().setPrev(head);
        }
    }

    // Appends the specified element 'body' to the end of this list.
    public void addLast(Massive body) {

        //TODO: implement method.
        if (head == null) {
            head = tail = new MyListNode2(body, null, null);
        } else if (head == tail) {
            tail = new MyListNode2(body, tail, null);
            head.setNext(tail);
        }
        else {
            tail = new MyListNode2(body, tail, null);
            tail.getPrev().setNext(tail);
        }
    }

    // Returns the last element in this list.
    // Returns 'null' if the list is empty.
    public Massive getLast() {

        //TODO: implement method.
        if (head == null) {
            return null;
        }
        return tail.getMassive();
    }

    // Returns the first element in this list.
    // Returns 'null' if the list is empty.
    public Massive getFirst() {

        //TODO: implement method.
        if (head == null) {
            return null;
        }
        return head.getMassive();
    }

    // Retrieves and removes the first element in this list.
    // Returns 'null' if the list is empty.
    public Massive pollFirst() {

        //TODO: implement method.
        if (head == null) {
            return null;
        }
        Massive toReturnBody = head.getMassive();
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrev(null);
        }
        return toReturnBody;
    }

    // Retrieves and removes the last element in this list.
    // Returns 'null' if the list is empty.
    public Massive pollLast() {

        //TODO: implement method.
        if (head == null) {
            return null;
        }
        Massive toReturnBody = tail.getMassive();
        tail = tail.getPrev();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        return toReturnBody;
    }

    // Inserts the specified element at the specified position in this list.
    // Precondition: i >= 0 && i <= size().
    public void add(int i, Massive m) {

        //TODO: implement method.
        if (i == 0) {
            addFirst(m);
        } else if (i == size()) {
            addLast(m);
        } else {
            head.add(m, i);
        }
    }

    // Returns the element at the specified position in this list.
    // Precondition: i >= 0 && i < size().
    public Massive get(int i) {

        //TODO: implement method.
        return head.get(i);
    }

    // Returns the index of the first occurrence of the specified element in this list, or -1 if
    // this list does not contain the element.
    public int indexOf(Massive m) {

        //TODO: implement method.
        if (head == null) {
            return -1;
        }
        return head.indexOf(m, 0);
    }

    // Returns the number of elements in this list.
    public int size() {

        //TODO: implement method.
        if (head == null) {
            return 0;
        }
        return head.size();
    }
}

//class implementing the linked list
class MyListNode2 {
    private final Massive b;
    private MyListNode2 next;
    private MyListNode2 prev;

    MyListNode2(Massive b,  MyListNode2 prev, MyListNode2 next) {
        this.b = b;
        this.prev = prev;
        this.next = next;
    }

    Massive getMassive() {
        return b;
    }

    //Precondition: inner index
    void add(Massive b, int i) {
        if (i == 0) {
            //insert
            MyListNode2 newNode = new MyListNode2(b, prev, this);
            prev.next = newNode;
        } else {
            next.add(b, i - 1);
        }
    }

    // Precondition: 'i' is a valid index.
    Massive get(int i) {
        if (i == 0) {
            return b;
        } else {
            return next.get(i - 1);
        }
    }

    int indexOf(Massive body, int i) {
        if (this.b.equals(body)) {
            return i;
        }
        if (next == null) {
            return -1;
        }
        return next.indexOf(body, i + 1);
    }

    int size() {
        if (next == null) {
            return 1;
        }
        return 1 + next.size();
    }

    public MyListNode2 getNext() {
        return next;
    }

    public MyListNode2 getPrev() {
        return prev;
    }

    void setNext(MyListNode2 node) { next = node; }

    void setPrev(MyListNode2 node) { prev = node; }
}
