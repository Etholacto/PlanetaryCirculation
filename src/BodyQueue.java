// A queue of bodies. A collection designed for holding bodies prior to processing.
// The bodies of the queue can be accessed in a FIFO (first-in-first-out) manner,
// i.e., the body that was first inserted by 'add' is retrieved first by 'poll'.
// The number of elements of the queue is not limited.
//
public class BodyQueue {

    //TODO: declare variables.

    // Initializes this queue with an initial capacity.
    public BodyQueue(int initialCapacity) {

        //TODO: define constructor.
    }

    // Initializes this queue as an independent copy of the specified queue.
    // Calling methods of this queue will not affect the specified queue
    // and vice versa.
    public BodyQueue(BodyQueue q) {

        //TODO: define constructor.
    }

    // Adds the specified body 'b' to this queue.
    public void add(Body b) {

        //TODO: implement method.
    }

    // Retrieves and removes the head of this queue, or returns 'null'
    // if this queue is empty.
    public Body poll() {

        //TODO: implement method.
        return null;
    }

    // Returns the number of bodies in this queue.
    public int size() {

        //TODO: implement method.
        return -1;
    }
}
