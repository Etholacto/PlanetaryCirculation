import codedraw.CodeDraw;

// A hash map that associates a 'Massive'-object with a Vector3 (typically this is the force
// exerted on the object). The number of key-value pairs is not limited.
//
public class MassiveForceHashMap {

    // TODO: define missing parts of this class.
    private MyHashMap root;
    private MassiveLinkedList list = new MassiveLinkedList();

    // Initializes 'this' as an empty map.
    public MassiveForceHashMap() {

        // TODO: implement constructor.
    }

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise 'null' is returned.
    // Precondition: key != null.
    public Vector3 put(Massive key, Vector3 value) {

        // TODO: implement method.
        if (root == null) {
            root = new MyHashMap(key, value, null, null);
            list.addLast(key);
            return null;
        }
        if (list.indexOf(key) == -1) {
            list.addLast(key);
        }
        return root.add(key, value);
    }

    // Returns the value associated with the specified key, i.e. the method returns the force vector
    // associated with the specified key. Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Vector3 get(Massive key) {

        // TODO: implement method.
        if (!containsKey(key)) {
            return null;
        }
        return root.get(key);
    }

    // Returns 'true' if this map contains a mapping for the specified key.
    public boolean containsKey(Massive key) {

        // TODO: implement method.
        if (root == null) {
            return false;
        }
        return root.containsKey(key);
    }

    // Returns a readable representation of this map, with all key-value pairs. Their order is not
    // defined.
    public String toString() {

        // TODO: implement method.
        if (root == null) {
            return "";
        }
        return root.toString();
    }

    // Compares `this` with the specified object for equality. Returns `true` if the specified
    // `o` is not `null` and is of type `MassiveForceHashMap` and both `this` and `o` have equal
    // key-value pairs, i.e. the number of key-value pairs is the same in both maps and every
    // key-value pair in `this` equals one key-value pair in `o`. Two key-value pairs are
    // equal if the two keys are equal and the two values are equal. Otherwise `false` is returned.
    public boolean equals(Object o) {

        // TODO: implement method.
        boolean check = false;
        if (o != null && o.getClass() == MassiveForceHashMap.class) {
            MassiveForceHashMap t = (MassiveForceHashMap)o;
            if (t.keyList().size() == this.keyList().size()) {
                check = true;
                for (int i = 0; i < t.keyList().size(); i++) {
                    if (t.keyList().get(i) == this.keyList().get(i)) {
                        if (t.get(t.keyList().get(i)) != this.get(this.keyList().get(i))) {
                            check = false;
                        }
                    }else{
                        check = false;
                    }
                }
            }
        }
        return check;
    }

    // Returns the hashCode of `this`.
    public int hashCode() {

        //TODO: implement method.
        int hash = 0;
        if (this != null) {
            MassiveLinkedList lis = this.keyList();
            for (int i = 0; i < lis.size(); i++) {
                hash += lis.get(i).hashCode();
            }
            for (int i = 0; i < lis.size(); i++) {
                hash += this.get(lis.get(i)).summedVector();
            }
        }
        return hash;
    }

    public int numberOfCollisions(){
        int temp = 0;
        MassiveLinkedList tmp = this.list;
        for (int i = 0; i < tmp.size(); i++) {
            for (int j = 0; j < tmp.size(); j++) {
                if (tmp.get(i).hashCode() == tmp.get(j).hashCode() && i != j){
                    temp++;
                    break;
                }
            }
        }
        return temp;
    }

    // Returns a list of all the keys in no specified order.
    public MassiveLinkedList keyList() {

        // TODO: implement method.
        return list;
    }

}

class MyHashMap {
    private MyHashMap left;
    private MyHashMap right;
    private Massive key;
    private Vector3 value;

    MyHashMap(Massive key, Vector3 value, MyHashMap left, MyHashMap right) {
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

        if (key.hashCode() < this.key.hashCode()) {
            if (left == null) {
                left = new MyHashMap(key, value, null, null);
                return null;
            } else {
                return left.add(key, value);
            }
        } else {
            if (right == null) {
                right = new MyHashMap(key, value, null, null);
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

        if (key.hashCode() < this.key.hashCode()) {
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
        if (key.hashCode() < this.key.hashCode()) {
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
        cd.drawText(x + 10, y, "" + key.getMass());
        if (left != null) {
            cd.drawLine(x, y, x - 30, y + 60);
            left.draw(cd, x - 30, y + 60);
        }
        if (right != null) {
            cd.drawLine(x, y, x + 30, y + 60);
            right.draw(cd, x + 30, y + 60);
        }
    }
    
    public boolean equals(MassiveForceHashMap o){
        if (o == null) {
            
        }
        return false;
    }
}