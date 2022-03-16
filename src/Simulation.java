import codedraw.CodeDraw;

import java.awt.*;
import java.util.Random;

// TODO: insert answers to questions (Zusatzfragen) in 'Aufgabenblatt1.md' as comment.

// Simulates the formation of a massive solar system.
public class Simulation {

    // gravitational constant
    public static final double G = 6.6743e-11;

    // one astronomical unit (AU) is the average distance of earth to the sun.
    public static final double AU = 150e9; // meters

    // one light year
    public static final double LY = 9.461e15; // meters

    // some further constants needed in the simulation
    public static final double SUN_MASS = 1.989e30; // kilograms
    public static final double SUN_RADIUS = 696340e3; // meters
    public static final double EARTH_MASS = 5.972e24; // kilograms
    public static final double EARTH_RADIUS = 6371e3; // meters

    // set some system parameters
    public static final double SECTION_SIZE = 2 * AU; // the size of the square region in space
    public static final int NUMBER_OF_BODIES = 22;
    public static final double OVERALL_SYSTEM_MASS = 20 * SUN_MASS; // kilograms

    // all quantities are based on units of kilogram respectively second and meter.

    // The main simulation method using instances of other classes.
    public static void main(String[] args) {

        //TODO: change implementation of this method according to 'Aufgabenblatt1.md'.

        // simulation
        CodeDraw cd = new CodeDraw();
        Body[] bodies = new Body[NUMBER_OF_BODIES];
        Vector3[] forceOnBody = new Vector3[bodies.length];

        Random random = new Random(2022);

        for (int i = 0; i < bodies.length; i++) {
            bodies[i] = new Body(Math.abs(random.nextGaussian()) * OVERALL_SYSTEM_MASS / bodies.length,
                    new Vector3(0.2 * random.nextGaussian() * AU, 0.2 * random.nextGaussian() * AU, 0.2 * random.nextGaussian() * AU),
                    new Vector3( 0 + random.nextGaussian() * 5e3, 0 + random.nextGaussian() * 5e3, 0 + random.nextGaussian() * 5e3));
            /*bodies[i].mass = Math.abs(random.nextGaussian()) * OVERALL_SYSTEM_MASS / bodies.length; // kg
            bodies[i].massCenter = new Vector3();
            bodies[i].currentMovement = new Vector3();
            bodies[i].massCenter.x = 0.2 * random.nextGaussian() * AU;
            bodies[i].massCenter.y = 0.2 * random.nextGaussian() * AU;
            bodies[i].massCenter.z = 0.2 * random.nextGaussian() * AU;

            bodies[i].currentMovement.x = 0 + random.nextGaussian() * 5e3;
            bodies[i].currentMovement.y = 0 + random.nextGaussian() * 5e3;
            bodies[i].currentMovement.z = 0 + random.nextGaussian() * 5e3;*/

        }

        double seconds = 0;

        // simulation loop
        while (true) {
            seconds++; // each iteration computes the movement of the celestial bodies within one second.

            // merge bodies that have collided
            for (int i = 0; i < bodies.length; i++) {
                for (int j = i + 1; j < bodies.length; j++) {
                    if (bodies[j].distanceTo(bodies[i]) < bodies[j].radius()+bodies[i].radius()){
                        bodies[i] = bodies[i].merge(bodies[j]);
                        Body[] bodiesOneRemoved = new Body[bodies.length - 1];
                        for (int k = 0; k < bodiesOneRemoved.length; k++) {
                            bodiesOneRemoved[k] = bodies[k < j ? k : k + 1];
                        }
                        bodies = bodiesOneRemoved;

                        // since the body index i changed size there might be new collisions
                        // at all positions of bodies, so start all over again
                        i = -1;
                        j = bodies.length;
                    }
                }
            }

            // for each body (with index i): compute the total force exerted on it.
            for (int i = 0; i < bodies.length; i++) {
                forceOnBody[i] = new Vector3(0,0,0); // begin with zero
                for (int j = 0; j < bodies.length; j++) {
                    if (i != j) {
                        Vector3 forceToAdd = bodies[i].gravitationalForce(bodies[j]);
                        forceOnBody[i] = forceOnBody[i].plus(forceToAdd);
                    }
                }
            }
            // now forceOnBody[i] holds the force vector exerted on body with index i.

            // for each body (with index i): move it according to the total force exerted on it.
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].move(forceOnBody[i]);
            }

            // show all movements in the canvas only every hour (to speed up the simulation)
            if (seconds % (3600) == 0) {
                // clear old positions (exclude the following line if you want to draw orbits).
                cd.clear(Color.BLACK);

                // draw new positions
                for (Body body : bodies) {
                    body.draw(cd);
                }

                // show new positions
                cd.show();
            }

        }
/*

    }

    //TODO: remove static methods below.

    // Draws a body in the 'cd' canvas showing a projection onto the (x,y)-plane. The body's mass
    // center coordinates and its radius are transformed into canvas coordinates. The color of
    // the body corresponds to the temperature of the body, assuming the relation of mass and
    // temperature of a main sequence star.
    // The canvas is assumed to show a quadratic SECTION_SIZE x SECTION_SIZE
    // section of space centered arround (x, y) = (0, 0).
    public static void draw(CodeDraw cd, Body b) {

        cd.setColor(SpaceDraw.massToColor(b.mass));
        drawAsFilledCircle(cd, b.massCenter, SpaceDraw.massToRadius(b.mass));

    }

    // Draws a filled circle in the 'cd' canvas unsing the (x,y)-coordinates of 'center'
    // Coordinates and 'radius' are transformed into canvas coordinates. The canvas is assumed
    // to show a quadratic SECTION_SIZE x SECTION_SIZE projection of space centered arround (x, y) =
    // (0, 0).
    public static void drawAsFilledCircle(CodeDraw cd, Vector3 center, double radius) {
        double x = cd.getWidth() * (center.x + Simulation.SECTION_SIZE / 2) / Simulation.SECTION_SIZE;
        double y = cd.getWidth() * (center.y + Simulation.SECTION_SIZE / 2) / Simulation.SECTION_SIZE;
        radius = cd.getWidth() * radius / Simulation.SECTION_SIZE;
        cd.fillCircle(x, y, Math.max(radius, 1.5));
    }

    // Returns a vector representing the gravitational force exerted by body 'b2' on body 'b1'.
    // The gravitational Force F is calculated by F = G*(m1*m2)/(r*r), with m1 and m2 being the masses of the objects
    // interacting, r being the distance between the centers of the masses and G being the gravitational constant.
    // To calculate the force exerted on b1, simply multiply the normalized vector pointing from b1 to b2 with the
    // calculated force.
    public static Vector3 gravitationalForce(Body b1, Body b2) {

        Vector3 direction = minus(b2.massCenter, b1.massCenter);
        double distance = length(direction);
        normalize(direction);
        double force = G * b1.mass * b2.mass / (distance * distance);
        return times(direction, force);
    }

    // Returns a new body that is formed by the collision of 'b1' and 'b2'. The impulse
    // of the returned body is the sum of the impulses of 'b1' and 'b2'.
    public static Body merge(Body b1, Body b2) {

        Body result = new Body();
        result.mass = b1.mass + b2.mass;
        result.massCenter = times(plus(times(b1.massCenter, b1.mass), times(b2.massCenter,
                        b2.mass)),
                1 / result.mass);
        result.currentMovement =
                times(plus(times(b1.currentMovement, b1.mass), times(b2.currentMovement, b2.mass)),
                        1.0 / result.mass);
        return result;
    }

    // Move the body 'b' according to the 'force' excerted on it.
    public static void move(Body b, Vector3 force) {
        Vector3 newPosition = plus(plus(b.massCenter, times(force, 1 / b.mass)), b.currentMovement);

        // new minus old position.
        Vector3 newMovement = minus(newPosition, b.massCenter);

        // update body state
        b.massCenter = newPosition;
        b.currentMovement = newMovement;
    }

    // Returns the norm of v1-v2.
    public static double distance(Vector3 v1, Vector3 v2) {

        double dX = v1.x - v2.x;
        double dY = v1.y - v2.y;
        double dZ = v1.z - v2.z;

        return Math.sqrt(dX * dX + dY * dY + dZ * dZ);
    }

    // Returns v1+v2.
    public static Vector3 plus(Vector3 v1, Vector3 v2) {

        Vector3 result = new Vector3();
        result.x = v1.x + v2.x;
        result.y = v1.y + v2.y;
        result.z = v1.z + v2.z;

        return result;
    }

    // Returns v1-v2.
    public static Vector3 minus(Vector3 v1, Vector3 v2) {

        Vector3 result = new Vector3();
        result.x = v1.x - v2.x;
        result.y = v1.y - v2.y;
        result.z = v1.z - v2.z;

        return result;
    }

    // Returns v*d.
    public static Vector3 times(Vector3 v, double d) {

        Vector3 result = new Vector3();
        result.x = v.x * d;
        result.y = v.y * d;
        result.z = v.z * d;

        return result;
    }

    // Returns the norm of 'v'.
    public static double length(Vector3 v) {

        return distance(v, new Vector3()); // distance to origin.
    }

    // Normalizes the specified vector 'v': changes the length of the vector such that its length
    // becomes one. The direction and orientation of the vector is not affected.
    public static void normalize(Vector3 v) {

        double length = length(v);
        v.x /= length;
        v.y /= length;
        v.z /= length;

 */
    }


}
