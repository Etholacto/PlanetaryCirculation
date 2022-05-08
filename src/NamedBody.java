import codedraw.CodeDraw;

public class NamedBody implements Massive/* TODO: add clause(s) */
{

    // TODO: add missing parts of this class.
    private String name;
    private Body body;

    // Initializes this with name, mass, current position and movement. The associated force
    // is initialized with a zero vector.
    public NamedBody(String name, double mass, Vector3 massCenter, Vector3 currentMovement) {
        // TODO: implement constructor.
        this.name = name;
        this.body = new Body(mass, massCenter, currentMovement);
    }

    // Returns the name of the body.
    public String getName() {
        // TODO: implement method.
        return this.name;

    }

    // Compares `this` with the specified object. Returns `true` if the specified `o` is not
    // `null` and is of type `NamedBody` and both `this` and `o` have equal names.
    // Otherwise `false` is returned.
    public boolean equals(Object o) {
        //TODO: implement method.
        if (o != null && NamedBody.class == o.getClass() && ((NamedBody) o).name == this.name){
            return true;
        }
        return false;

    }

    // Returns the hashCode of `this`.
    public int hashCode() {
        //TODO: implement method.
        char[] chara = this.name.toCharArray();
        int hash = 0;
        for (int i = 0; i < chara.length; i++) {
            hash += chara[i];
        }
        if (this != null) {
            hash++;
        }
        return hash;
    }

    // Returns a readable representation including the name of this body.
    public String toString() {
        //TODO: implement method.
        return this.name + ": " + this.body.toString();

    }

    @Override
    public void draw(CodeDraw cd) {
        this.body.draw(cd);
    }

    @Override
    public void move(Vector3 force) {
        this.body.move(force);
    }

    @Override
    public double getMass() {
        return this.body.getMass();
    }

    @Override
    public double mass() {
        return this.body.mass();
    }

    @Override
    public Vector3 getMassCenter() {
        return this.body.getMassCenter();
    }

    @Override
    public Vector3 massCenter() {
        return this.body.massCenter();
    }
}
