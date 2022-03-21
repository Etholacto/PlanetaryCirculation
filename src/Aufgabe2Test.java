public class Aufgabe2Test {

    public static void main(String[] args) {

        //test classes BodyQueue and BodyForceMap

        // create three bodies
        Body sun = new Body(1.989e30,new Vector3(0,0,0),new Vector3(0,0,0));
        Body earth = new Body(5.972e24,new Vector3(-1.394555e11,5.103346e10,0),new Vector3(-10308.53,-28169.38,0));
        Body mercury = new Body(3.301e23,new Vector3(-5.439054e10,9.394878e9,0),new Vector3(-17117.83,-46297.48,-1925.57));


        // check basic functions of 'BodyQueue'
        System.out.println("Test1:");

        BodyQueue bq = new BodyQueue(2);
        bq.add(mercury);
        bq.add(sun);
        bq.add(earth);
        testValue(bq.size(), 3);

        testValue(bq.poll(), mercury);
        testValue(bq.poll(), sun);
        testValue(bq.poll(), earth);

        testValue(bq.size(), 0);

        bq.add(mercury);
        bq.add(sun);
        testValue(bq.size(), 2);

        // check constructor of 'BodyQueue'
        BodyQueue bqCopy = new BodyQueue(bq);
        testComparison(bq, bqCopy, false);
        testComparison(bq.poll(), bqCopy.poll(), true);
        bq.add(earth);
        testValue(bq.size(), 2);
        testValue(bqCopy.size(), 1);

        // check basic functions of 'BodyForceMap'
        System.out.println("Test2:");
        BodyForceMap bfm = new BodyForceMap(5);
        bfm.put(earth, earth.gravitationalForce(sun));
        bfm.put(sun, sun.gravitationalForce(earth));

        testValue(bfm.get(earth).distanceTo(earth.gravitationalForce(sun)),0);
        testValue(bfm.get(sun).distanceTo(sun.gravitationalForce(earth)),0);

        bfm.put(earth, new Vector3(0,0,0));
        testValue(bfm.get(earth).distanceTo(new Vector3(0,0,0)), 0);
        testValue(bfm.get(mercury),null);

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
