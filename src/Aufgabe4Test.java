import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Aufgabe4Test {

    public static void main(String[] args) {

        //TODO: uncomment for testing
        /*
        //test classes HierachicalSystem and NamedBodyForcePair

        // create 12 bodies
        Body sun1, earth1, moon1, mars1, deimos1, phobos1, mercury1, venus1, vesta1, pallas1,
                hygiea1, ceres1;
        NamedBodyForcePair sun2, mercury2, venus2, earth2, moon2, mars2, deimos2, phobos2, vesta2,
                pallas2, hygiea2, ceres2;

        sun1 = new Body(1.989E30, new Vector3(0.0,0.0,0.0), new Vector3(0.0,0.0,
           0.0));
        earth1 = new Body(5.972E24, new Vector3(-6.13135922534815E10,-1.383789852227691E11,
           2.719682263474911E7), new Vector3(26832.720535473603,-11948.23168764519,1.9948243075997851));
        moon1 = new Body(7.349E22, new Vector3(-6.132484773775896E10,-1.387394951280871E11,
           1.701046736294776E7), new Vector3(27916.62329282941,-12020.39526008238,-94.89703264508708));
        mars1 = new Body(6.41712E23, new Vector3(-1.7923193702925848E11,1.726665823982123E11
           ,7.991673845249474E9), new Vector3(-15925.78496403673,-15381.16179928219,68.67560910598857));
        deimos1 = new Body(1.8E20, new Vector3(-1.792255010450533E11,1.726891122683271E11,
           7.990659337380297E9), new Vector3(-17100.476719804457,-15020.348656808,631.2927851249581));
        phobos1 = new Body(1.08E20, new Vector3(-1.792253482539647E11,1.72661109673625E11,
           7.987848354800322E9), new Vector3(-14738.203714241401,-13671.17675223948,-411.0012490555253));
        mercury1 = new Body(3.301E23, new Vector3(-5.167375560011926E10,
           -4.217574885682655E10,1.14808913958168E9), new Vector3(21580.25398577148,-34951.03632847389,-4835.225596525241));
        venus1 = new Body(4.86747E24, new Vector3(-3.123150865740532E10,
           1.0395568504115701E11,3.173401325838074E9), new Vector3(-33748.180519629335,-10014.25141045021,1809.94488874165));
        vesta1 = new Body(2.5908E20, new Vector3(-3.337493557929893E11,
           -4.7147908276077385E10,4.1923010146878105E10), new Vector3(4440.54247538484,-19718.49074006637,48.06573124543601));
        pallas1 = new Body(2.14E20, new Vector3(4.3452066613895575E11,-2.057319365171432E11,
           1.0549957423213101E11), new Vector3(5058.947582097117,11184.45711782372,-8183.524138259704));
        hygiea1 = new Body(8.32E19, new Vector3(-3.983943433707043E11,2.325833000024021E11,
           -2.233667695713672E10), new Vector3(-6931.864585548552,-15686.8108598699,-690.5791992347208));
        ceres1 = new Body(9.394E20, new Vector3(3.781372641419032E11,1.96718960466285E11,
           -6.366459168068592E10), new Vector3(-8555.324226752316,14718.33755980907,2040.230135060142));

        Body[] bodies = new Body[]{sun1, mercury1, venus1, earth1, moon1, mars1, deimos1, phobos1,
                vesta1, pallas1, hygiea1, ceres1};
        Vector3[] forceOnBody = new Vector3[bodies.length];

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

        NamedBodyForcePair[] pairs = new NamedBodyForcePair[] {sun2, mercury2, venus2, earth2,
                moon2, mars2, deimos2, phobos2,
                vesta2, pallas2, hygiea2, ceres2};

        // check basic functions of 'HierachicalSystem'
        System.out.println("Test1:");

        CosmicSystem earthSystem = new HierarchicalSystem(earth2, moon2);
        CosmicSystem marsSystem = new HierarchicalSystem(mars2, deimos2, phobos2);
        CosmicSystem solarSystem = new HierarchicalSystem(sun2, mercury2, venus2, earthSystem,
                marsSystem, vesta2, pallas2, hygiea2, ceres2);

        testValue(earthSystem.numberOfBodies(), 2);
        testValue(solarSystem.numberOfBodies(), 12);

        System.out.println("Test2:");
        System.out.println(solarSystem.toString());
        testValue(solarSystem.toString().contains("Mars"), true);
        testValue(solarSystem.toString().contains("Deimos"), true);
        testValue(solarSystem.toString().contains("Moon"), true);
        testValue(earthSystem.toString().contains("Moon"), true);
        testValue(earthSystem.toString().contains("Earth"), true);

        System.out.println("Test3:");
        testValue(solarSystem.getMass(),1.9890118865556799E30);

        System.out.println("Test4:");
        BodyLinkedList bl = solarSystem.getBodies();
        testValue(bl.size(),12);
        HashSet<Body> set = new HashSet<>();
        while(bl.size() > 0) {
            set.add(bl.pollFirst());
        }
        testValue(set.size(), 12);

        System.out.println("Test5:");
        for (int seconds = 0; seconds < 50000; seconds++) {
            // for each body (with index i): compute the total force exerted on it.
            for (int i = 0; i < bodies.length; i++) {
                forceOnBody[i] = new Vector3(0, 0, 0); // begin with zero
                for (int j = 0; j < bodies.length; j++) {
                    if (i != j) {
                        pairs[i].addForceTo(pairs[j]);
                        Vector3 forceToAdd = bodies[i].gravitationalForce(bodies[j]);
                        forceOnBody[i] = forceOnBody[i].plus(forceToAdd);
                    }
                }
            }
            // now forceOnBody[i] holds the force vector exerted on body with index i.

            // for each body (with index i): move it according to the total force exerted on it.
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].move(forceOnBody[i]);
                pairs[i].update();
            }
        }

        for (int i = 0; i < bodies.length; i++) {
            testValue(bodies[i].massCenter().distanceTo(pairs[i].getMassCenter()),0);
        }

        System.out.println("Test6:");
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

        pairs = new NamedBodyForcePair[] {sun2, mercury2, venus2, earth2,
                moon2, mars2, deimos2, phobos2,
                vesta2, pallas2, hygiea2, ceres2};
        HierarchicalSystem hs = new HierarchicalSystem(sun2, mercury2, venus2,
                new HierarchicalSystem(earth2, moon2), new HierarchicalSystem(mars2, deimos2,
                phobos2), vesta2, pallas2, hygiea2, ceres2);

        for (int seconds = 0; seconds < 50000; seconds++) {
            hs.addForceTo(hs);
            hs.update();
        }

        for (int i = 0; i < bodies.length; i++) {
            testValue(bodies[i].massCenter().distanceTo(pairs[i].getMassCenter()),0);
        }
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
