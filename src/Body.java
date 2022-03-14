import codedraw.CodeDraw;

import java.awt.*;

// This class represents celestial bodies like stars, planets, asteroids, etc..
public class Body {

    //TODO: change modifiers.
    public double mass;
    public Vector3 massCenter; // position of the mass center.
    public Vector3 currentMovement;

    //TODO: define constructor.

    // Returns the distance between the mass centers of this body and the specified body 'b'.
    public double distanceTo(Body b) {

        //TODO: implement method.
        return 0;
    }

    // Returns a vector representing the gravitational force exerted by 'b' on this body.
    // The gravitational Force F is calculated by F = G*(m1*m2)/(r*r), with m1 and m2 being the
    // masses of the objects interacting, r being the distance between the centers of the masses
    // and G being the gravitational constant.
    // Hint: see simulation loop in Simulation.java to find out how this is done.
    public Vector3 gravitationalForce(Body b) {

        //TODO: implement method.
        return null;
    }

    // Moves this body to a new position, according to the specified force vector 'force' exerted
    // on it, and updates the current movement accordingly.
    // (Movement depends on the mass of this body, its current movement and the exerted force.)
    // Hint: see simulation loop in Simulation.java to find out how this is done.
    public void move(Vector3 force) {

        //TODO: implement method.
    }

    // Returns the approximate radius of this body.
    // (It is assumed that the radius r is related to the mass m of the body by r = m ^ 0.5,
    // where m and r measured in solar units.)
    public double radius() {

        //TODO: implement method.
        return 0d;
    }

    // Returns a new body that is formed by the collision of this body and 'b'. The impulse
    // of the returned body is the sum of the impulses of 'this' and 'b'.
    public Body merge(Body b) {

        //TODO: implement method.
        return null;
    }

    // Draws the body to the specified canvas as a filled circle.
    // The radius of the circle corresponds to the radius of the body
    // (use a conversion of the real scale to the scale of the canvas as
    // in 'Simulation.java').
    // Hint: call the method 'drawAsFilledCircle' implemented in 'Vector3'.
    public void draw(CodeDraw cd) {

        //TODO: implement method.
    }

    // Returns a string with the information about this body including
    // mass, position (mass center) and current movement. Example:
    // "5.972E24 kg, position: [1.48E11,0.0,0.0] m, movement: [0.0,29290.0,0.0] m/s."
    public String toString() {

        //TODO: implement method.
        return "";
    }

}

