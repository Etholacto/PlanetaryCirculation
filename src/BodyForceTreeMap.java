import codedraw.CodeDraw;

// A map that associates a Body with a Vector3 (typically this is the force exerted on the body).
// The number of key-value pairs is not limited.
public class BodyForceTreeMap {

    private MyBodyTreeNode root;

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise 'null' is returned.
    // Precondition: key != null.
    public Vector3 put(Body key, Vector3 value) {
        if (root == null) {
            root = new MyBodyTreeNode(key, value, null, null);
            return null;
        }
        return root.add(key, value);
    }

    // Returns the value associated with the specified key, i.e. the method returns the force vector
    // associated with the specified key. Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Vector3 get(Body key) {
        if (!containsKey(key)) {
            return null;
        }
        return root.get(key);
    }

    // Returns 'true' if this map contains a mapping for the specified key.
    public boolean containsKey(Body key) {
        if (root == null) {
            return false;
        }
        return root.containsKey(key);
    }

    // Returns a readable representation of this map, in which key-value pairs are ordered
    // descending according to the mass of the bodies.
    public String toString() {
        if (root == null) {
            return "";
        }
        return root.toString();
    }

    //additional method to visualize tree
    public void draw() {
        CodeDraw cd = new CodeDraw(500, 500);
        if (root == null) {
            cd.drawText(200, 50, "Empty tree");
        } else {
            root.draw(cd, 250, 10);
        }
        cd.show(); 
    }

    public Body getParentKey(Body key){
        Body parent = new Body(0, new Vector3(0,0,0), new Vector3(0,0,0));
        parent = root.getParentKey(key, parent);
        return parent;
    }
}

class MyBodyTreeNode {
    private MyBodyTreeNode left;
    private MyBodyTreeNode right;
    private Body key;
    private Vector3 value;

    MyBodyTreeNode(Body key, Vector3 value, MyBodyTreeNode left, MyBodyTreeNode right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    Vector3 add(Body key, Vector3 value) {
        if (key == this.key) {
            Vector3 oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        if (key.mass() < this.key.mass()) {
            if (left == null) {
                left = new MyBodyTreeNode(key, value, null, null);
                return null;
            } else {
                return left.add(key, value);
            }
        } else {
            if (right == null) {
                right = new MyBodyTreeNode(key, value, null, null);
                return null;
            } else {
                return right.add(key, value);
            }
        }
    }

    Vector3 get(Body key) {
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

    Body getParentKey(Body key, Body parent) {
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

    public boolean containsKey(Body key) {
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
