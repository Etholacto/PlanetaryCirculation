// A collection of 'Massive' objects in which there are no duplicates.
//
public interface MassiveSet extends MassiveIterable, Drawable {

    // Returns 'true' if the set has the specified element (i.e., has an element equal to the
    // specified element).
    boolean contains(Massive element);

    // Removes the specified element from the set.
    void remove(Massive element);

    // Removes all elements from the set.
    void clear();

    // Returns the number of elements in the set.
    int size();

    // Returns an object of 'MassiveLinkedList' with all elements of 'this'.
    MassiveLinkedList toList();

}