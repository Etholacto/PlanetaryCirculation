// A queue of bodies. A collection designed for holding bodies prior to processing.
// The bodies of the queue can be accessed in a FIFO (first-in-first-out) manner,
// i.e., the body that was first inserted by 'add' is retrieved first by 'poll'.
// The number of elements of the queue is not limited.
//
public class BodyQueue {

    //TODO: declare variables.
    private int initialCapacity;
    private DEQueue q;
    private BodyQueue copyq;

    // Initializes this queue with an initial capacity.
    // Precondition: initialCapacity > 0.
    public BodyQueue(int initialCapacity) {
        //TODO: define constructor.
        this.initialCapacity = initialCapacity;
        this.q = new DEQueue();
    }

    // Initializes this queue as an independent copy of the specified queue.
    // Calling methods of this queue will not affect the specified queue
    // and vice versa.
    // Precondition: q != null.
    public BodyQueue(BodyQueue q) {
        //TODO: define constructor.
        this.copyq = q;
    }

    // Adds the specified body 'b' to this queue.
    public void add(Body b) {
        //TODO: implement method.
        q.addLast(b);
    }

    // Retrieves and removes the head of this queue, or returns 'null'
    // if this queue is empty.
    public Body poll() {

        //TODO: implement method.
        return q.pollFirst();
    }

    // Returns the number of bodies in this queue.
    public int size() {

        //TODO: implement method.
        return q.size();
    }
}

class DEQueue{
    private int mask = (1 << 3) - 1;
    private Body[] es = new Body[mask + 1];
    private int head, tail;


    public void addFirst(Body e) {
        es[head = (head - 1) & mask] = e;
        if (tail == head) {
            doubleCapacity();
        }
    }

    public Body pollFirst() {
        Body result = es[head];
        es[head] = null;
        if (tail != head) {
            head = (head + 1) & mask;
        }
        return result;
    }

    public Body peekFirst() {
        return es[head];
    }

    public void addLast(Body e) {
        es[tail] = e;
        tail = (tail + 1) & mask;
        if (tail == head) {
            doubleCapacity();
        }
    }

    public Body pollLast() {
        if (tail != head) {
            tail = (tail - 1) & mask;
        }
        Body result = es[tail];
        es[tail] = null;
        return result;
    }

    public Body peekLast() {
        return es[(tail - 1) & mask];
    }

    public int size() {
        return (tail - head) & mask;
    }

    private void doubleCapacity() {
        mask = (mask << 1) | 1;
        Body[] newes = new Body[mask + 1];
        int i = 0, j = 0;
        while (i < head) {
            newes[j++] = es[i++];
        }
        j = head += es.length;
        while (i < es.length) {
            newes[j++] = es[i++];
        }
        es = newes;
    }
}
