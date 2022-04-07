// A map that associates a body with a force exerted on it. The number of
// key-value pairs is not limited.
//
public class BodyForceMap {

    //TODO: declare variables.
    private int top;
    private Body[] ks;
    private Vector3[] vs;

    // Initializes this map with an initial capacity.
    // Precondition: initialCapacity > 0.
    public BodyForceMap(int initialCapacity) {

        //TODO: define constructor.
        this.ks = new Body[initialCapacity];
        this.vs = new Vector3[initialCapacity];
    }

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise 'null' is returned.
    // Precondition: key != null.
    public Vector3 put(Body key, Vector3 force) {

        //TODO: implement method.
        int i = find(key, ks);
        if (i == top && ++top == ks.length) {
            Body[] nks = new Body[top << 1];
            Vector3[] nvs = new Vector3[top << 1];
            for (int j = 0; j < i; j++) {
                nks[j] = ks[j];
                nvs[j] = vs[j];
            }
            ks = nks;
            vs = nvs;
        }
        ks[i] = key;
        Vector3 old = vs[i];
        vs[i] = force;
        return old;
    }

    // Returns the value associated with the specified key, i.e. the returns the force vector
    // associated with the specified body. Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Vector3 get(Body key) {

        //TODO: implement method.
        return vs[find(key, ks)];
    }

    private int find(Body s, Body[] a) {
        int i = 0;
        while (i < top && !(s == null ? s == a[i] : s.equals(a[i])))
            i++;
        return i;
    }

}