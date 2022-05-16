// Iterable objects with 'Massive' elements.
//
public interface MassiveIterable extends Iterable<Massive> {

    @Override
    // Returns an iterator over elements of 'Massive'.
    MassiveIterator iterator();
}
