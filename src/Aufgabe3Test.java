public class Aufgabe3Test {

    public static void main(String[] args) {

        //test classes BodyLinkedList and BodyForceTreeMap

        // create five bodies
        Body sun = new Body(1.989e30, new Vector3(0, 0, 0), new Vector3(0, 0, 0));
        Body earth = new Body(5.972e24, new Vector3(-1.394555e11, 5.103346e10, 0), new Vector3(-10308.53, -28169.38, 0));
        Body mercury = new Body(3.301e23, new Vector3(-5.439054e10, 9.394878e9, 0), new Vector3(-17117.83, -46297.48, -1925.57));
        Body venus = new Body(4.86747e24, new Vector3(-1.707667e10, 1.066132e11, 2.450232e9), new Vector3(-34446.02, -5567.47, 2181.10));
        Body mars = new Body(6.41712e23, new Vector3(-1.010178e11, -2.043939e11, -1.591727E9), new Vector3(20651.98, -10186.67, -2302.79));

        // check basic functions of 'BodyLinkedList'
        System.out.println("Test1:");

        BodyLinkedList bl = new BodyLinkedList();

        bl.addLast(mercury);
        bl.addLast(sun);
        bl.addLast(earth);
        testValue(bl.size(), 3);

        testValue(bl.getFirst(), mercury);
        testValue(bl.getLast(), earth);

        testValue(bl.get(0), mercury);
        testValue(bl.get(1), sun);
        testValue(bl.get(2), earth);

        System.out.println("Test2:");
        testValue(bl.indexOf(earth), 2);
        testValue(bl.indexOf(sun), 1);
        testValue(bl.indexOf(mercury), 0);

        System.out.println("Test3:");
        testValue(bl.pollFirst(), mercury);
        testValue(bl.pollLast(), earth);
        testValue(bl.pollFirst(), sun);

        testValue(bl.size(), 0);
        testValue(bl.getFirst(), null);

        System.out.println("Test4:");
        bl.addFirst(earth);
        bl.addFirst(venus);
        bl.addFirst(sun);
        bl.add(1, mercury);
        bl.add(4, mars);

        testValue(bl.size(), 5);

        testValue(bl.get(0), sun);
        testValue(bl.get(1), mercury);
        testValue(bl.get(2), venus);
        testValue(bl.get(3), earth);
        testValue(bl.get(4), mars);

        // check constructor of 'BodyLinkedList'
        BodyLinkedList blCopy = new BodyLinkedList(bl);
        testComparison(bl, blCopy, false);
        testComparison(bl.pollFirst(), blCopy.pollFirst(), true);
        bl.addFirst(sun);
        testValue(bl.size(), 5);
        testValue(blCopy.size(), 4);

        // check basic functions of 'BodyForceTreeMap'
        System.out.println("Test5:");
        BodyForceTreeMap bfm = new BodyForceTreeMap();
        bfm.put(earth, earth.gravitationalForce(sun));
        bfm.put(sun, sun.gravitationalForce(earth).plus(sun.gravitationalForce(venus)));
        bfm.put(venus, venus.gravitationalForce(sun));
        bfm.put(mars, mars.gravitationalForce(sun));
        bfm.put(mercury, mercury.gravitationalForce(sun));

        testValue(bfm.get(earth).distanceTo(earth.gravitationalForce(sun)), 0);
        testValue(bfm.get(sun).distanceTo(sun.gravitationalForce(earth).plus(sun.gravitationalForce(venus))), 0);

        testValue(bfm.put(earth, new Vector3(0, 0, 0)).distanceTo(earth.gravitationalForce(sun)), 0);
        testValue(bfm.get(earth).distanceTo(new Vector3(0, 0, 0)), 0);
        testValue(bfm.get(mercury), mercury.gravitationalForce(sun));

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
        if (given < expected + (expected + 1) / 1e12 && given > expected - (expected + 1) / 1e12) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }
}
