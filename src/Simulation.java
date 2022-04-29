import codedraw.CodeDraw;

import java.awt.*;
import java.util.Random;

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

        // simulation
        CodeDraw cd = new CodeDraw();
        BodyQueue bodies = new BodyQueue(NUMBER_OF_BODIES);
        BodyForceMap forceOnBody = new BodyForceMap(NUMBER_OF_BODIES);

        Random random = new Random(2022);

        for (int i = 0; i < NUMBER_OF_BODIES; i++) {
            bodies.add(new Body(Math.abs(random.nextGaussian()) * OVERALL_SYSTEM_MASS / NUMBER_OF_BODIES,
                    new Vector3(0.2 * random.nextGaussian() * AU, 0.2 * random.nextGaussian() * AU, 0.2 * random.nextGaussian() * AU),
                    new Vector3(0 + random.nextGaussian() * 5e3, 0 + random.nextGaussian() * 5e3, 0 + random.nextGaussian() * 5e3)));
            //System.out.println(bodies[i]);
        }

        double seconds = 0;

        // simulation loop
        while (true) {
            seconds++; // each iteration computes the movement of the celestial bodies within one second.

            // for each body (with index i): compute the total force exerted on it.
            BodyQueue bodyCopy1 = new BodyQueue(bodies);
            while (bodyCopy1.size() > 0) {
                Vector3 force = new Vector3(0, 0, 0); // begin with zero
                Body body1 = bodyCopy1.poll();
                BodyQueue bodyCopy2 = new BodyQueue(bodies);
                while (bodyCopy2.size() > 0) {
                    Body body2 = bodyCopy2.poll();
                    if (body1 != body2) {
                        Vector3 forceToAdd = body1.gravitationalForce(body2);
                        force = force.plus(forceToAdd);
                    }
                }
                forceOnBody.put(body1, force);

            }
            // now forceOnBody holds the force vector exerted on each body

            // for each body: move it according to the total force exerted on it.
            bodyCopy1 = new BodyQueue(bodies);
            while (bodyCopy1.size() > 0) {
                Body body1 = bodyCopy1.poll();
                body1.move(forceOnBody.get(body1));
            }

            // show all movements in the canvas only every hour (to speed up the simulation)
            if (seconds % (3600) == 0) {
                // clear old positions (exclude the following line if you want to draw orbits).
                cd.clear(Color.BLACK);

                // draw new positions
                bodyCopy1 = new BodyQueue(bodies);
                while (bodyCopy1.size() > 0) {
                    Body body1 = bodyCopy1.poll();
                    body1.draw(cd);
                }

                // show new positions
                cd.show();
            }
        }
    }
}
