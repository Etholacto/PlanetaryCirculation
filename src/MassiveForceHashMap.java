// A hash map that associates a 'Massive'-object with a Vector3 (typically this is the force
// exerted on the object). The number of key-value pairs is not limited.
//
public class MassiveForceHashMap {

    // TODO: define missing parts of this class.

    // Initializes 'this' as an empty map.
    public MassiveForceHashMap() {

        // TODO: implement constructor.
    }

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise 'null' is returned.
    // Precondition: key != null.
    public Vector3 put(Massive key, Vector3 value) {

        // TODO: implement method.
        return null;
    }

    // Returns the value associated with the specified key, i.e. the method returns the force vector
    // associated with the specified key. Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Vector3 get(Massive key) {

        // TODO: implement method.
        return null;
    }

    // Returns 'true' if this map contains a mapping for the specified key.
    public boolean containsKey(Massive key) {

        // TODO: implement method.
        return false;
    }

    // Returns a readable representation of this map, with all key-value pairs. Their order is not
    // defined.
    public String toString() {

        // TODO: implement method.
        return "";
    }

    // Compares `this` with the specified object for equality. Returns `true` if the specified
    // `o` is not `null` and is of type `MassiveForceHashMap` and both `this` and `o` have equal
    // key-value pairs, i.e. the number of key-value pairs is the same in both maps and every
    // key-value pair in `this` equals one key-value pair in `o`. Two key-value pairs are
    // equal if the two keys are equal and the two values are equal. Otherwise `false` is returned.
    public boolean equals(Object o) {

        // TODO: implement method.
        return false;
    }

    // Returns the hashCode of `this`.
    public int hashCode() {

        //TODO: implement method.
        return 0;
    }

    // Returns a list of all the keys in no specified order.
    public MassiveLinkedList keyList() {

        // TODO: implement method.
        return null;
    }

}