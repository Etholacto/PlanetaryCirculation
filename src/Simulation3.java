import codedraw.CodeDraw;

import java.awt.*;
import java.util.Random;

// Simulates the formation of a massive solar system.
//
public class Simulation3 {

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
        BodyLinkedList bodies = new BodyLinkedList();
        BodyForceTreeMap forceOnBody = new BodyForceTreeMap();

        Random random = new Random(2022);

        for (int i = 0; i < NUMBER_OF_BODIES; i++) {
            bodies.addLast(new Body(Math.abs(random.nextGaussian()) * OVERALL_SYSTEM_MASS / NUMBER_OF_BODIES,
                    new Vector3(0.2 * random.nextGaussian() * AU, 0.2 * random.nextGaussian() * AU, 0.2 * random.nextGaussian() * AU),
                    new Vector3(0 + random.nextGaussian() * 5e3, 0 + random.nextGaussian() * 5e3, 0 + random.nextGaussian() * 5e3)));
            System.out.println(bodies.getLast());
        }

        double seconds = 0;

        // simulation loop
        while (true) {
            seconds++; // each iteration computes the movement of the celestial bodies within one second.


            // merge bodies that have collided
            BodyLinkedList bodiesCopy = new BodyLinkedList(bodies);
            while (bodiesCopy.getLast() != null) {
                BodyLinkedList collidingBodies = bodies.removeCollidingWith(bodiesCopy.pollLast());
                Body mergedBody = collidingBodies.pollLast(); //collidingBodies.size() >= 1, as at least one collided (the body itself)
                while (collidingBodies.getLast() != null) {
                    System.out.println("collision!");
                    mergedBody = mergedBody.merge(collidingBodies.pollLast());
                }
                bodies.addLast(mergedBody);
            }

            // for each body (with index i): compute the total force exerted on it.
            for (int i = 0; i < bodies.size(); i++) {
                Body currentBody = bodies.get(i);
                Vector3 totalForce = new Vector3(0, 0, 0);
                for (int j = 0; j < bodies.size(); j++) {
                    if (i != j) {
                        totalForce = totalForce.plus(currentBody.gravitationalForce(bodies.get(j)));
                    }
                }
                forceOnBody.put(currentBody, totalForce);
            }
            // now forceOnBody[i] holds the force vector exerted on body with index i.

            // for each body (with index i): move it according to the total force exerted on it.
            for (int i = 0; i < bodies.size(); i++) {
                Body currentBody = bodies.get(i);
                currentBody.move(forceOnBody.get(currentBody));
            }

            // show all movements in the canvas only every hour (to speed up the simulation)
            if (seconds % (3600) == 0) {
                // clear old positions (exclude the following line if you want to draw orbits).
                cd.clear(Color.BLACK);
                System.out.println(seconds);

                // draw new positions
                for (int i = 0; i < bodies.size(); i++) {
                    bodies.get(i).draw(cd);
                }

                // show new positions
                cd.show();
            }
        }
    }
}