import codedraw.CodeDraw;

// A body with a name and an associated force. The leaf node of
// a hierarchical cosmic system. This class implements 'CosmicSystem'.
//
public class NamedBodyForcePair implements CosmicSystem/* TODO: add clause */ {

    // TODO: define missing parts of this class.
    private String name;
    private Body body;
    private Vector3 force;

    // Initializes this with name, mass, current position and movement. The associated force
    // is initialized with a zero vector.
    public NamedBodyForcePair(String name, double mass, Vector3 massCenter, Vector3 currentMovement) {
        // TODO: implement constructor.
        this.name = name;
        this.body = new Body(mass, massCenter, currentMovement);
        this.force = new Vector3(0,0,0);
    }

    // Returns the name of the body.
    public String getName() {
        // TODO: implement method.
        return this.name;

    }

    @Override
    public Vector3 getMassCenter() {
        return this.body.massCenter();
    }

    @Override
    public double getMass() {
        return this.body.getMass();
    }

    @Override
    public int numberOfBodies() {
        return 1;
    }

    @Override
    public double distanceTo(CosmicSystem cs) {
        return 0;
    }

    @Override
    public void addForceFrom(Body b) {
        if (this.body != b) {
            this.force = this.force.plus(this.body.gravitationalForce(b));
        }
    }

    @Override
    public void addForceTo(CosmicSystem cs) {
        if (this.body != cs.getBodies().pollLast()) {
            this.force = this.force.plus(this.getBodies().pollFirst().gravitationalForce(cs.getBodies().pollFirst()));
        }
    }

    @Override
    public BodyLinkedList getBodies() {
        BodyLinkedList temp = new BodyLinkedList();
        temp.addLast(this.body);
        return temp;
    }

    @Override
    public void update() {
        this.body.move(this.force);
        this.force = new Vector3(0,0,0);
    }

    @Override
    public int getNumberOfCentralBodies() {
        return 0;
    }

    @Override
    public void draw(CodeDraw cd) {
        this.body.draw(cd);
    }

    @Override
    public String toString(){
        return this.getName();
    }

    public Body getBody() {
        return body;
    }
}
