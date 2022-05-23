import codedraw.CodeDraw;

// A map that associates an object of 'Massive' with a Vector3. The number of key-value pairs
// is not limited.
//
// TODO: define further classes and methods for the binary search tree and the implementation
//  of MassiveSet, if needed.
//
public class MassiveForceTreeMap {

    // TODO: define missing parts of this class.
    private MyMassiveTreeNode root;

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise 'null' is returned.
    // Precondition: key != null.
    public Vector3 put(Massive key, Vector3 value) {
        if (root == null) {
            root = new MyMassiveTreeNode(key, value, null, null);
            return null;
        }
        return root.add(key, value);
    }

    // Returns the value associated with the specified key, i.e. the method returns the force vector
    // associated with the specified key. Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Vector3 get(Massive key) {
        if (!containsKey(key)) {
            return null;
        }
        return root.get(key);
    }

    // Returns 'true' if this map contains a mapping for the specified key.
    //Precondition: key != null
    public boolean containsKey(Massive key) {
        if (root == null) {
            return false;
        }
        return root.containsKey(key);
    }

    // Returns a readable representation of this map, in which key-value pairs are ordered
    // descending according to 'key.getMass()'.
    public String toString() {
        if (root == null) {
            return "";
        }
        return root.toString();
    }

    // Returns a `MassiveSet` view of the keys contained in this tree map. Changing the
    // elements of the returned `MassiveSet` object also affects the keys in this tree map.
    public MassiveSet getKeys() {

        // TODO: implement method.
        return null;
    }
}

//TODO: Define additional class(es) implementing the binary search tree and the implementation
// of MassiveSet (either here or in a separate file).

class MyMassiveTreeNode {
    private MyMassiveTreeNode left;
    private MyMassiveTreeNode right;
    private Massive key;
    private Vector3 value;

    MyMassiveTreeNode(Massive key, Vector3 value, MyMassiveTreeNode left, MyMassiveTreeNode right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    Vector3 add(Massive key, Vector3 value) {
        if (key == this.key) {
            Vector3 oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        if (key.mass() < this.key.mass()) {
            if (left == null) {
                left = new MyMassiveTreeNode(key, value, null, null);
                return null;
            } else {
                return left.add(key, value);
            }
        } else {
            if (right == null) {
                right = new MyMassiveTreeNode(key, value, null, null);
                return null;
            } else {
                return right.add(key, value);
            }
        }
    }

    Vector3 get(Massive key) {
        if (key == this.key) {
            return value;
        }

        if (key.mass() < this.key.mass()) {
            if (left == null) {
                return null;
            }
            return left.get(key);
        } else {
            if (right == null) {
                return null;
            }
            return right.get(key);
        }

    }

    Massive getParentKey(Massive key, Massive parent) {
        if (key == this.key) {
            return parent;
        }
        if (this.right.key != null && key == this.right.key) {
            parent = this.key;
            return parent;
        } else if (this.right.key != null) {
            parent = this.right.key;
            parent = right.getParentKey(this.right.key, parent);
        } else {
            return null;
        }
        if (this.left.key != null && key == this.left.key) {
            parent = this.key;
            return parent;
        } else if (this.left.key != null) {
            parent = this.left.key;
            parent = left.getParentKey(this.left.key, parent);
        } else {
            return null;
        }
        return parent;
    }

    public String toString() {
        String result;
        result = right == null ? "" : right.toString();
        result += "(" + this.key + "|" + this.value + ")\n";
        result += left == null ? "" : left.toString();
        return result;
    }

    public boolean containsKey(Massive key) {
        if (key == this.key) {
            return true;
        }
        if (key.mass() < this.key.mass()) {
            if (left == null) {
                return false;
            }
            return left.containsKey(key);
        } else {
            if (right == null) {
                return false;
            }
            return right.containsKey(key);
        }
    }

    public void draw(CodeDraw cd, double x, double y) {
        cd.fillCircle(x, y, 10);
        cd.drawText(x + 10, y, "" + key.mass());
        if (left != null) {
            cd.drawLine(x, y, x - 30, y + 60);
            left.draw(cd, x - 30, y + 60);
        }
        if (right != null) {
            cd.drawLine(x, y, x + 30, y + 60);
            right.draw(cd, x + 30, y + 60);
        }
    }
}