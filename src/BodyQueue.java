// A queue of bodies. A collection designed for holding bodies prior to processing.
// The bodies of the queue can be accessed in a FIFO (first-in-first-out) manner,
// i.e., the body that was first inserted by 'add' is retrieved first by 'poll'.
// The number of elements of the queue is not limited.
//
public class BodyQueue {

    //TODO: declare variables.
    private int initialCapacity;
    private DEQueue que;

    // Initializes this queue with an initial capacity.
    // Precondition: initialCapacity > 0.
    public BodyQueue(int initialCapacity) {
        //TODO: define constructor.
        this.initialCapacity = initialCapacity;
        this.que = new DEQueue();
    }

    // Initializes this queue as an independent copy of the specified queue.
    // Calling methods of this queue will not affect the specified queue
    // and vice versa.
    // Precondition: q != null.
    public BodyQueue(BodyQueue q) {
        //TODO: define constructor.
        this(q.getInitialCapacity());
        this.que.setBodies(q.que.getBodies());
        this.que.setHead(q.que.getHead());
        this.que.setTail(q.que.getTail());
    }

    // Adds the specified body 'b' to this queue.
    public void add(Body b) {
        //TODO: implement method.
        que.addLast(b);
    }

    // Retrieves and removes the head of this queue, or returns 'null'
    // if this queue is empty.
    public Body poll() {

        //TODO: implement method.
        return this.que.pollFirst();
    }

    // Returns the number of bodies in this queue.
    public int size() {

        //TODO: implement method.
        return que.size();
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

}

class DEQueue{
    private int mask = (1 << 3) - 1;
    private Body[] bodies = new Body[mask + 1];
    private int head, tail;


    public void addFirst(Body e) {
        bodies[head = (head - 1) & mask] = e;
        if (tail == head) {
            doubleCapacity();
        }
    }

    public Body pollFirst() {
        Body result = bodies[head];
        bodies[head] = null;
        if (tail != head) {
            head = (head + 1) & mask;
        }
        return result;
    }

    public Body peekFirst() {
        return bodies[head];
    }

    public void addLast(Body e) {
        bodies[tail] = e;
        tail = (tail + 1) & mask;
        if (tail == head) {
            doubleCapacity();
        }
    }

    public Body pollLast() {
        if (tail != head) {
            tail = (tail - 1) & mask;
        }
        Body result = bodies[tail];
        bodies[tail] = null;
        return result;
    }

    public Body peekLast() {
        return bodies[(tail - 1) & mask];
    }

    public int size() {
        return (tail - head) & mask;
    }

    private void doubleCapacity() {
        mask = (mask << 1) | 1;
        Body[] newes = new Body[mask + 1];
        int i = 0, j = 0;
        while (i < head) {
            newes[j++] = bodies[i++];
        }
        j = head += bodies.length;
        while (i < bodies.length) {
            newes[j++] = bodies[i++];
        }
        bodies = newes;
    }

    public Body[] getBodies() {
        return bodies;
    }

    public void setBodies(Body[] body){
        for (int i = 0; i < body.length; i++) {
            if (body.length > bodies.length) {
                doubleCapacity();
            }
            this.bodies[i] = body[i];
        }
    }

    public int getHead(){
        return head;
    }

    public void setHead(int head){
        this.head = head;
    }

    public int getTail(){
        return tail;
    }

    public void setTail(int tail){
        this.tail = tail;
    }
}
