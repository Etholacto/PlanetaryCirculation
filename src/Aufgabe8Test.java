
import java.util.HashSet;
import java.util.NoSuchElementException;

public class Aufgabe8Test {

    public static void main(String[] args) {

        /* //TODO: uncomment for testing

        MassiveForceTreeMap map = new MassiveForceTreeMap();
        NamedBody mars;

        map.put(new NamedBody("Oumuamua", 8e6, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Earth", 5.972E24, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Moon", 7.349E22, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(mars = new NamedBody("Mars", 6.41712E23, new Vector3(0, 0, 0),
                        new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Deimos", 1.8E20, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Phobos", 1.08E20, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Mercury", 3.301E23, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Venus", 4.86747E24, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Vesta", 2.5908E20, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Pallas", 2.14E20, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Hygiea", 8.32E19, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Ceres", 9.394E20, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));


        System.out.println("Test1:");
        MassiveIterator iterator = map.getKeys().iterator();
        int count = 0;
        while(iterator.hasNext()) {
            if (iterator.next().equals(mars)) {
                iterator.remove();
            }
            count++;
        }
        testValue(count, 12);
        testValue(map.getKeys().size(), 11);
        testValue(map.getKeys().contains(mars), false);

        System.out.println("Test2:");
        try {
            iterator.next();
            // this statement must not be reached
            testValue(true, false);
        } catch (NoSuchElementException e) {
            testValue(true, true);
        }

        System.out.println("Test3:");
        iterator = map.getKeys().iterator();
        while(iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        testValue(map.getKeys().size(),0);

        */ //TODO: uncomment
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
