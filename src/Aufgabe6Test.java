import java.util.HashSet;

public class Aufgabe6Test {

    public static void main(String[] args) {

        /* //TODO: uncomment for testing
        NamedBody sun1, mercury1, venus1, earth1, moon1, mars1, deimos1, phobos1, vesta1,
                pallas1, hygiea1, ceres1;

        // create the same 12 named body-force pairs
        sun1 = new NamedBody("Sun",1.989E30, new Vector3(0.0,0.0,0.0)
                , new Vector3(0.0,0.0,0.0));
        earth1 = new NamedBody("Earth",5.972E24,
                new Vector3(-6.13135922534815E10,-1.383789852227691E11,2.719682263474911E7), new Vector3(26832.720535473603,-11948.23168764519,1.9948243075997851));
        moon1 = new NamedBody("Moon",7.349E22,
                new Vector3(-6.132484773775896E10,-1.387394951280871E11,1.701046736294776E7), new Vector3(27916.62329282941,-12020.39526008238,-94.89703264508708));
        mars1 = new NamedBody("Mars",6.41712E23,
                new Vector3(-1.7923193702925848E11,1.726665823982123E11,7.991673845249474E9), new Vector3(-15925.78496403673,-15381.16179928219,68.67560910598857));
        deimos1 = new NamedBody("Deimos",1.8E20,
                new Vector3(-1.792255010450533E11,1.726891122683271E11,7.990659337380297E9), new Vector3(-17100.476719804457,-15020.348656808,631.2927851249581));
        phobos1 = new NamedBody("Phobos",1.08E20,
                new Vector3(-1.792253482539647E11,1.72661109673625E11,7.987848354800322E9), new Vector3(-14738.203714241401,-13671.17675223948,-411.0012490555253));
        mercury1 = new NamedBody("Mercury",3.301E23,
                new Vector3(-5.167375560011926E10,-4.217574885682655E10,1.14808913958168E9), new Vector3(21580.25398577148,-34951.03632847389,-4835.225596525241));
        venus1 = new NamedBody("Venus",4.86747E24,
                new Vector3(-3.123150865740532E10,1.0395568504115701E11,3.173401325838074E9), new Vector3(-33748.180519629335,-10014.25141045021,1809.94488874165));
        vesta1 = new NamedBody("Vesta",2.5908E20,
                new Vector3(-3.337493557929893E11,-4.7147908276077385E10,4.1923010146878105E10), new Vector3(4440.54247538484,-19718.49074006637,48.06573124543601));
        pallas1 = new NamedBody("Pallas",2.14E20,
                new Vector3(4.3452066613895575E11,-2.057319365171432E11,1.0549957423213101E11), new Vector3(5058.947582097117,11184.45711782372,-8183.524138259704));
        hygiea1 = new NamedBody("Hygiea",8.32E19,
                new Vector3(-3.983943433707043E11,2.325833000024021E11,-2.233667695713672E10), new Vector3(-6931.864585548552,-15686.8108598699,-690.5791992347208));
        ceres1 = new NamedBody("Ceres",9.394E20,
                new Vector3(3.781372641419032E11,1.96718960466285E11,-6.366459168068592E10), new Vector3(-8555.324226752316,14718.33755980907,2040.230135060142));

        // check basic functions of 'MassiveForceHashMap'
        MassiveForceTreeMap map = new MassiveForceTreeMap();
        map.put(sun1, new Vector3(0,0,0));
        map.put(mercury1, new Vector3(0,0,0));
        map.put(venus1, new Vector3(0,0,0));
        map.put(earth1, new Vector3(0,0,0));
        map.put(moon1, new Vector3(0,0,0));
        map.put(mars1, new Vector3(0,0,0));
        map.put(deimos1, new Vector3(0,0,0));
        map.put(phobos1, new Vector3(0,0,0));
        map.put(vesta1, new Vector3(0,0,0));
        map.put(pallas1, new Vector3(0,0,0));
        map.put(hygiea1, new Vector3(0,0,0));
        map.put(ceres1, new Vector3(0,0,0));
        map.put(mars1, new Vector3(0,0,0)); // inserted twice

        HashSet<Massive> set1 = new HashSet<>();
        set1.add(sun1);
        set1.add(mercury1);
        set1.add(venus1);
        set1.add(earth1);
        set1.add(moon1);
        set1.add(mars1);
        set1.add(deimos1);
        set1.add(phobos1);
        set1.add(vesta1);
        set1.add(pallas1);
        set1.add(hygiea1);
        set1.add(ceres1);

        System.out.println("Test1:");
        testValue(map.toString().contains("Mars"), true);
        testValue(map.toString().contains("Deimos"), true);
        testValue(map.toString().contains("Moon"), true);
        testValue(map.toString().contains("Earth"), true);

        System.out.println("Test2:");
        testValue(map.getKeys().size(), 12);

        System.out.println("Test3:");
        testValue(map.getKeys().contains(mars1), true);
        testValue(map.getKeys().contains(new NamedBody("Mars",6.41712E23,
                new Vector3(0,0,0),
                new Vector3(0,0,0))), true);
        testValue(map.getKeys().contains(new Body(6.41712E23,
                new Vector3(0,0,0),
                new Vector3(0,0,0))), false);

        System.out.println("Test4:");
        HashSet<Massive> set2 = new HashSet<>();
        for(Massive m: map.getKeys()) {
            set2.add(m);
        }

        testValue(set1.equals(set2), true);

        System.out.println("Test5:");
        MassiveLinkedList list = map.getKeys().toList();
        while (list.size() > 0) {
            set1.remove(list.pollLast());
        }
        testValue(set1.isEmpty(), true);

        System.out.println("Test6:");
        map.getKeys().remove(mars1);
        testValue(map.containsKey(mars1), false);
        testValue(map.getKeys().size(), 11);
        map.getKeys().clear();
        testValue(map.getKeys().size(), 0);

        System.out.println("Test7:");
        NamedBodyForcePair sun2, mercury2, venus2, earth2, moon2, mars2, deimos2, phobos2, vesta2,
                pallas2, hygiea2, ceres2;

        //test classes NamedBody and MassiveForceHashMap

        // create 12 named bodies
        // create the same 12 named body-force pairs
        sun2 = new NamedBodyForcePair("Sun",1.989E30, new Vector3(0.0,0.0,0.0)
                , new Vector3(0.0,0.0,0.0));
        earth2 = new NamedBodyForcePair("Earth",5.972E24,
                new Vector3(-6.13135922534815E10,-1.383789852227691E11,2.719682263474911E7), new Vector3(26832.720535473603,-11948.23168764519,1.9948243075997851));
        moon2 = new NamedBodyForcePair("Moon",7.349E22,
                new Vector3(-6.132484773775896E10,-1.387394951280871E11,1.701046736294776E7), new Vector3(27916.62329282941,-12020.39526008238,-94.89703264508708));
        mars2 = new NamedBodyForcePair("Mars",6.41712E23,
                new Vector3(-1.7923193702925848E11,1.726665823982123E11,7.991673845249474E9), new Vector3(-15925.78496403673,-15381.16179928219,68.67560910598857));
        deimos2 = new NamedBodyForcePair("Deimos",1.8E20,
                new Vector3(-1.792255010450533E11,1.726891122683271E11,7.990659337380297E9), new Vector3(-17100.476719804457,-15020.348656808,631.2927851249581));
        phobos2 = new NamedBodyForcePair("Phobos",1.08E20,
                new Vector3(-1.792253482539647E11,1.72661109673625E11,7.987848354800322E9), new Vector3(-14738.203714241401,-13671.17675223948,-411.0012490555253));
        mercury2 = new NamedBodyForcePair("Mercury",3.301E23,
                new Vector3(-5.167375560011926E10,-4.217574885682655E10,1.14808913958168E9), new Vector3(21580.25398577148,-34951.03632847389,-4835.225596525241));
        venus2 = new NamedBodyForcePair("Venus",4.86747E24,
                new Vector3(-3.123150865740532E10,1.0395568504115701E11,3.173401325838074E9), new Vector3(-33748.180519629335,-10014.25141045021,1809.94488874165));
        vesta2 = new NamedBodyForcePair("Vesta",2.5908E20,
                new Vector3(-3.337493557929893E11,-4.7147908276077385E10,4.1923010146878105E10), new Vector3(4440.54247538484,-19718.49074006637,48.06573124543601));
        pallas2 = new NamedBodyForcePair("Pallas",2.14E20,
                new Vector3(4.3452066613895575E11,-2.057319365171432E11,1.0549957423213101E11), new Vector3(5058.947582097117,11184.45711782372,-8183.524138259704));
        hygiea2 = new NamedBodyForcePair("Hygiea",8.32E19,
                new Vector3(-3.983943433707043E11,2.325833000024021E11,-2.233667695713672E10), new Vector3(-6931.864585548552,-15686.8108598699,-690.5791992347208));
        ceres2 = new NamedBodyForcePair("Ceres",9.394E20,
                new Vector3(3.781372641419032E11,1.96718960466285E11,-6.366459168068592E10), new Vector3(-8555.324226752316,14718.33755980907,2040.230135060142));

        CosmicSystem earthSystem = new HierarchicalSystem(earth2, moon2);
        CosmicSystem marsSystem = new HierarchicalSystem(mars2, deimos2, phobos2);
        HierarchicalSystem solarSystem = new HierarchicalSystem(sun2, mercury2, venus2, earthSystem,
                marsSystem, vesta2, pallas2, hygiea2, ceres2);

        int count = 0;
        for (Massive b: solarSystem) {
            count++;
        }
        testValue(count, 12);

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
