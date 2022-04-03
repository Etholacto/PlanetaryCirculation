// A map that associates a Body with a Vector3 (typically this is the force exerted on the body).
// The number of key-value pairs is not limited.
public class BodyForceTreeMap {

    //TODO: declare variables.
    private TANode root;

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise 'null' is returned.
    // Precondition: key != null.
    public Vector3 put(Body key, Vector3 value) {

        //TODO: implement method.
        if (root != null) {
            return root.put(key, value);
        }
        root = new TANode(key, value);
        return null;
    }

    // Returns the value associated with the specified key, i.e. the method returns the force vector
    // associated with the specified key. Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Vector3 get(Body key) {

        //TODO: implement method.
        if (root == null) {
            return null;
        }
        TANode node = root.find(key);
        return node == null ? null : node.value();
    }

    // Returns 'true' if this map contains a mapping for the specified key.
    public boolean containsKey(Body key) {

        //TODO: implement method.
        return root != null && root.find(key) != null;
    }

    // Returns a readable representation of this map, in which key-value pairs are ordered
    // descending according to the mass of the bodies.
    public String toString() {

        //TODO: implement method.
        return null;

    }
}

class TANode {
    private Body key;
    private Vector3 value;
    private TANode left, right;

    public TANode(Body k, Vector3 v) {
        key = k;
        value = v;
    }

    private int compare(Body k) {
        if (k == null) {
            return key == null ? 0 : -1;
        }
        if (key == null) {
            return 1;
        }
        return k.compareTo(key);
    }

    public Vector3 put(Body k, Vector3 v) {
        int cmp = compare(k);
        if (cmp < 0) {
            if (left != null) {
                return left.put(k, v);
            }
            left = new TANode(k, v);
        } else if (cmp > 0) {
            if (right != null) {
                return right.put(k, v);
            }
            right = new TANode(k, v);
        } else {
            Vector3 result = value;
            value = v;
            return result;
        }
        return null;
    }

    public TANode find(Body k) {
        int cmp = compare(k);
        if (cmp == 0) {
            return this;
        }
        TANode node = cmp < 0 ? left : right;
        if (node == null) {
            return null;
        }
        return node.find(k);
    }

    public boolean hasValue(Vector3 v) {
        return (v == null ? value == v
                : v.equals(value)) ||
                (left != null && left.hasValue(v)) ||
                (right != null && right.hasValue(v));
    }

    public Vector3 value() {
        return value;
    }
}
