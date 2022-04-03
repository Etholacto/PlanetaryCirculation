// A list of bodies implemented as a linked list.
// The number of elements of the list is not limited.
public class BodyLinkedList {

    //TODO: declare variables.
    private ListNode first, last;

    // Initializes 'this' as an empty list.
    public BodyLinkedList() {

        //TODO: define constructor.
        first = last = new ListNode(null, null);
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
        if (body != null) {
            if (this.first.getBody() == null) {
                first = last = new ListNode(body, null);
            }else{
                first.setNext(first = new ListNode(body, this.first));
            }
        }

    }

    // Appends the specified element 'body' to the end of this list.
    public void addLast(Body body) {

        //TODO: implement method.
        if (body != null) {
            if (this.last.getBody() == null) {
                first = last = new ListNode(body, null);
            }else{
                last.setNext(last = new ListNode(body, this.last));
            }
        }
    }

    // Returns the last element in this list.
    // Returns 'null' if the list is empty.
    public Body getLast() {

        //TODO: implement method.
        if (last == null) {
            return null;
        }else{
            return last.getBody();
        }
    }

    // Returns the first element in this list.
    // Returns 'null' if the list is empty.
    public Body getFirst() {

        //TODO: implement method.
            if (first == null) {
                return null;
            }else{
                return first.getBody();
            }
    }

    // Retrieves and removes the first element in this list.
    // Returns 'null' if the list is empty.
    public Body pollFirst() {

        //TODO: implement method.
        if (first != null) {
            Body result = first.getBody();
            first = first.next();
            if (first == null) {
                last = null;
            }
            return result;
        }
        return null;
    }

    // Retrieves and removes the last element in this list.
    // Returns 'null' if the list is empty.
    public Body pollLast() {

        //TODO: implement method.
        if (last != null) {
            Body result = last.getBody();
            last = last.next();
            if (last == null) {
                first = null;
            }
            return result;
        }
        return null;
    }

    // Inserts the specified element 'body' at the specified position in this list.
    // Precondition: i >= 0 && i <= size().
    public void add(int i, Body body) {

        //TODO: implement method.
        if (i > 0) {
            for (ListNode n = first; n != null; n = n.next()) {
                if (--i == 0) {
                    n.setNext(new ListNode(body, n.next()));
                    if (last == n) {
                        last = n.next();
                    }
                }
            }
        } else if (i == 0) {
            first = new ListNode(body, first);
            if (last == null) {
                last = first;
            }
        }
    }

    // Returns the element at the specified position in this list.
    // Precondition: i >= 0 && i < size().
    public Body get(int i) {

        //TODO: implement method.
        for (ListNode n = first; n != null; n = n.next()) {
            if (i-- == 0) {
                return n.getBody();
            }
        }
        return null;
    }

    // Returns the index of the first occurrence of the specified element in this list, or -1 if
    // this list does not contain the element.
    public int indexOf(Body body) {

        //TODO: implement method.
        int i = 0;
        ListNode n = first;
        while (n != null && !(body == null ? body == n.getBody() : body.equals(n.getBody()))) {
            i++;
            n = n.next();
        }
        return n == null ? -1 : i;
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
        if (last == null) {
            return 0;
        }
        return last.size(last.getBody());
    }
}

class ListNode {
    private Body b;
    private ListNode next;

    public ListNode(Body b, ListNode n) {
        this.b = b;
        this.next = n;
    }

    public Body getBody() {
        return b;
    }

    public ListNode next() {
        return next;
    }

    public void setNext(ListNode n) {
        next = n;
    }

    public void setValue(Body b) {
        this.b = b;
    }

    int size(Body b) {
        if (next.getBody() == b) {
            return 2;
        }
        return 1 + next.size(b);

    }
}
