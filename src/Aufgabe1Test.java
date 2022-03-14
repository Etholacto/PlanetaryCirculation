import java.awt.*;

public class Aufgabe1Test {

    public static void main(String[] args) {

        //test classes Body and Vector3

        /* TODO: remove this line

        // create two bodies
        Body sun = new Body(1.989e30,new Vector3(0,0,0),new Vector3(0,0,0));
        Body earth = new Body(5.972e24,new Vector3(-1.394555e11,5.103346e10,0),new Vector3(-10308.53,-28169.38,0));

        testValue(earth.distanceTo(sun), 1.4850000175024106E11);
        testValue(sun.distanceTo(earth), 1.4850000175024106E11);

        for(int i = 0; i < 3600*24; i++) {
            Vector3 f1 = earth.gravitationalForce(sun);
            Vector3 f2 = sun.gravitationalForce(earth);

            earth.move(f1);
            sun.move(f2);
        }

        // a dummy body to check the correct position after 24h of movement
        Body targetPositionEarth = new Body(1, new Vector3(-1.403250141841815E11,
                4.859202658875631E10, 0.0), new Vector3(0,0,0));

        // check distance to target position (should be zero)
        testValue(earth.distanceTo(targetPositionEarth), 0);

        // TODO: remove this line */

    }

    public static void testComparison(Object first, Object second, boolean expected) {
        boolean real = first == second;

        if (real == expected) {
            System.out.println("Successful comparison");
        } else {
            System.out.println("Comparison NOT successful! Expected value: " + expected + " / Given value: " + real);
        }
    }

    public static void testValue(Object given, Object expected) {
        if (given == expected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }

    public static void testValue(double given, double expected) {
        if (given < expected + (expected+1)/1e12 && given > expected - (expected+1)/1e12) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }
}
