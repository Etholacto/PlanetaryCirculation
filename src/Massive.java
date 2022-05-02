// Represents a coherent mass with a mass center in 3D space. Has two naming schemes for its
// methods. Please, do not change this interface definition!
//
public interface Massive extends Drawable {

    // Returns the mass.
    default double mass() {

        return getMass();
    }

    // Returns the mass center.
    default Vector3 massCenter() {

        return getMassCenter();
    }

    // Returns the mass.
    default double getMass() {

        return mass();
    }

    // Returns the mass center.
    default Vector3 getMassCenter() {

        return massCenter();
    }

    // Returns the approximate radius of 'this', assuming it is a coherent round mass.
    // (It is assumed that the radius r is related to the mass m by r = m ^ 0.5,
    // where m and r measured in solar units.)
    default double getRadius() {

        return radius();
    }

    // Returns the approximate radius of 'this', assuming it is a coherent round mass.
    // (It is assumed that the radius r is related to the mass m by r = m ^ 0.5,
    // where m and r measured in solar units.)
    default double radius() {

        return SpaceDraw.massToRadius(mass());
    }

    // Returns a vector representing the gravitational force exerted by 'b' on this mass.
    // The gravitational Force F is calculated by F = G*(m1*m2)/(r*r), with m1 and m2 being the
    // masses of the objects interacting, r being the distance between the centers of the masses
    // and G being the gravitational constant.
    default Vector3 gravitationalForce(Massive b) {

        Vector3 direction = b.massCenter().minus(this.massCenter());
        double distance = direction.length();
        direction.normalize();
        double force = Simulation.G*this.mass()*b.mass()/(distance * distance);
        return direction.times(force);
    }

    // Centers this mass at a new position, according to the specified force vector 'force' exerted
    // on it, and updates the current velocity vector accordingly.
    // (Velocity depends on the mass of 'this', its current velocity and the exerted force.)
    void move(Vector3 force);

}
