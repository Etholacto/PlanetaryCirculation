// A representation of a system of bodies with associated forces. Provides methods
// for computing current mutual forces, updating the positions of bodies and drawing
// the bodies in a CodeDraw object.
//
public interface CosmicSystem extends Drawable {

    // Returns a readable representation of this system.
    String toString();

    // Returns the mass center of this system.
    Vector3 getMassCenter();

    // Returns the overall mass of this system.
    double getMass();

    // Returns the overall number of bodies contained in this system.
    int numberOfBodies();

    // Returns the distance between the mass centers of 'this' and the specified system.
    //Precondition: cs != null
    double distanceTo(CosmicSystem cs);

    // Adds the force that the specified body exerts on each of this systems bodies to each of this
    // systems bodies.
    // Precondition: b != null
    void addForceFrom(Body b);

    // Adds the force that this system exerts on each of the bodies of 'cs' to the bodies in 'cs'.
    // For exact computations this means that for each body of 'this' its force on each body of
    // 'cs' is added to this body of 'cs'.
    // Precondition: cs != null
    void addForceTo(CosmicSystem cs);

    // Returns a list with all the bodies of 'this'. The order is not defined.
    BodyLinkedList getBodies();

    // Moves each of the bodies of 'this' according to the previously accumulated forces and
    // resets all forces to zero.
    void update();

}
