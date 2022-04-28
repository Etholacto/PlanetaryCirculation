// A list of bodies implemented as a linked list.
// The number of elements of the list is not limited.
public class BodyLinkedList {

    private MyListNode head;
    private MyListNode tail;

    // Initializes 'this' as an empty list.
    public BodyLinkedList() {
    }

    // Initializes 'this' as an independent copy of the specified list 'list'.
    // Calling methods of this list will not affect the specified list 'list'
    // and vice versa.
    // Precondition: list != null.
    public BodyLinkedList(BodyLinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            this.addLast(list.get(i));
        }
    }

    // Inserts the specified element 'body' at the beginning of this list.
    public void addFirst(Body body) {
        if (head == null) {
            head = tail = new MyListNode(body, null, null);
        } else if (head == tail) {
            head = new MyListNode(body, null, head);
            tail.setPrev(head);
        } else {
            head = new MyListNode(body, null, head);
            head.getNext().setPrev(head);
        }
    }

    // Appends the specified element 'body' to the end of this list.
    public void addLast(Body body) {
        if (head == null) {
            head = tail = new MyListNode(body, null, null);
        } else if (head == tail) {
            tail = new MyListNode(body, tail, null);
            head.setNext(tail);
        }
        else {
            tail = new MyListNode(body, tail, null);
            tail.getPrev().setNext(tail);
        }
    }

    // Returns the last element in this list.
    // Returns 'null' if the list is empty.
    public Body getLast() {
        if (head == null) {
            return null;
        }
        return tail.getBody();
    }

    // Returns the first element in this list.
    // Returns 'null' if the list is empty.
    public Body getFirst() {
        if (head == null) {
            return null;
        }
        return head.getBody();
    }

    // Retrieves and removes the first element in this list.
    // Returns 'null' if the list is empty.
    public Body pollFirst() {
        if (head == null) {
            return null;
        }
        Body toReturnBody = head.getBody();
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
    public Body pollLast() {
        if (head == null) {
            return null;
        }
        Body toReturnBody = tail.getBody();
        tail = tail.getPrev();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        return toReturnBody;
    }

    // Inserts the specified element 'body' at the specified position in this list.
    // Precondition: i >= 0 && i <= size().
    public void add(int i, Body body) {
        if (i == 0) {
            addFirst(body);
        } else if (i == size()) {
            addLast(body);
        } else {
            head.add(body, i);
        }
    }

    // Returns the element at the specified position in this list.
    // Precondition: i >= 0 && i < size().
    public Body get(int i) {
        return head.get(i);
    }

    // Returns the index of the first occurrence of the specified element in this list, or -1 if
    // this list does not contain the element.
    public int indexOf(Body body) {
        if (head == null) {
            return -1;
        }
        return head.indexOf(body, 0);
    }

    // Removes all bodies of this list, which are colliding with the specified
    // body. Returns a list with all the removed bodies.
    public BodyLinkedList removeCollidingWith(Body body) {
        BodyLinkedList collidingList = new BodyLinkedList();
        if (head == null) {
            return new BodyLinkedList();
        }
        while (head != null && head.getBody().collidesWith(body)) {
            collidingList.addLast(this.pollFirst());
        }
        while (tail != null && tail.getBody().collidesWith(body)) {
            collidingList.addLast(this.pollLast());
        }
        //still inner nodes to check?
        if (head != null && head.getNext() != null) {
            MyListNode currentNode = head.getNext();
            while (currentNode != tail) {
                if (currentNode.getBody().collidesWith(body)) {
                    collidingList.addLast(currentNode.getBody());
                    currentNode.getPrev().setNext(currentNode.getNext());
                    currentNode.getNext().setPrev(currentNode.getPrev());
                }
                currentNode = currentNode.getNext();
            }
        }
        return collidingList;
    }

    // Returns the number of bodies in this list.
    public int size() {
        if (head == null) {
            return 0;
        }
        return head.size();
    }
}

//class implementing the linked list
class MyListNode {
    private final Body b;
    private MyListNode next;
    private MyListNode prev;

    MyListNode(Body b,  MyListNode prev, MyListNode next) {
        this.b = b;
        this.prev = prev;
        this.next = next;
    }

    Body getBody() {
        return b;
    }

    //Precondition: inner index
    void add(Body b, int i) {
        if (i == 0) {
            //insert
            MyListNode newNode = new MyListNode(b, prev, this);
            prev.next = newNode;
        } else {
            next.add(b, i - 1);
        }
    }

    // Precondition: 'i' is a valid index.
    Body get(int i) {
        if (i == 0) {
            return b;
        } else {
            return next.get(i - 1);
        }
    }

    int indexOf(Body body, int i) {
        if (body == this.b) {
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

    public MyListNode getNext() {
        return next;
    }

    public MyListNode getPrev() {
        return prev;
    }

    void setNext(MyListNode node) { next = node; }

    void setPrev(MyListNode node) { prev = node; }
}
