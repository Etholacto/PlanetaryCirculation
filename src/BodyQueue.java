import java.util.Arrays;

// A queue of bodies. A collection designed for holding bodies prior to processing.
// The bodies of the queue can be accessed in a FIFO (first-in-first-out) manner,
// i.e., the body that was fist inserted by 'add' is retrieved first by 'poll'.
// The number of elements of the queue is not limited.
//
public class BodyQueue {

    private int c;
    private Body[] es;
    private int head, tail;

    // Initializes this queue with an initial capacity.
    public BodyQueue(int initialCapacity) {
        c = initialCapacity;
        es = new Body[c];
    }

    // Initializes this queue as an independent copy of the specified queue.
    // Calling methods of this queue will not affect the specified queue
    // and vice versa.
    public BodyQueue(BodyQueue q) {
        this.es = q.es.clone();
        this.c = q.c;
        this.head = q.head;
        this.tail = q.tail;
    }

   public BodyQueue getJoined(BodyQueue bq){
        BodyQueue joined = new BodyQueue(this.size() + bq.size());
        int tsize = 0;
        int bsize = 0;
        for (int i = 0; i < joined.es.length; i++) {
            if (tsize != this.size()) {
                joined.add(this.es[this.head+ i]);
                tsize++;
            }
            if (bsize != bq.size()) {
                joined.add(bq.es[bq.head + i]);
                bsize++;
            }
        }
        return joined;
    }

    // Adds the specified body 'b' to this queue.
    public void add(Body b) {
        es[tail] = b;
        tail = (tail + 1) % c;

        if (tail == head) {
            doubleCapacity();
        }
    }

    // Retrieves and removes the head of this queue, or returns 'null'
    // if this queue is empty.
    public Body poll() {
        Body result = es[head];
        es[head] = null;
        if(tail != head) {
            head = (head + 1) % c;
        }
        return result;
    }

    // Returns the number of bodies in this queue.
    public int size() {
        if (head <= tail) {
            return tail - head;
        }
        return c - head + tail;
    }

    // Doubles the size of the array used by this queue. This method is called if 'add' is called
    // and all positions of the array are already occupied.
    private void doubleCapacity() {
        c = 2*c;

        Body[] newes = new Body[c];

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
