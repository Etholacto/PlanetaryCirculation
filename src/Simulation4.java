import codedraw.CodeDraw;

import java.awt.*;

// Simulates the formation of a massive solar system.
//
public class Simulation4 {

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
    public static final double SECTION_SIZE = 10 * AU; // the size of the square region in space

    // all quantities are based on units of kilogram respectively second and meter.

    // The main simulation method using instances of other classes.
    public static void main(String[] args) {

        // simulation
        CodeDraw cd = new CodeDraw();

        // create solar system with 12 bodies
        NamedBodyForcePair sun = new NamedBodyForcePair("Sun",1.989E30, new Vector3(0.0,0.0,0.0), new Vector3(0.0,0.0,0.0));
        NamedBodyForcePair earth = new NamedBodyForcePair("Earth",5.972E24, new Vector3(-6.13135922534815E10,-1.383789852227691E11,2.719682263474911E7), new Vector3(26832.720535473603,-11948.23168764519,1.9948243075997851));
        NamedBodyForcePair moon = new NamedBodyForcePair("Moon",7.349E22, new Vector3(-6.132484773775896E10,-1.387394951280871E11,1.701046736294776E7), new Vector3(27916.62329282941,-12020.39526008238,-94.89703264508708));
        NamedBodyForcePair mars = new NamedBodyForcePair("Mars",6.41712E23, new Vector3(-1.7923193702925848E11,1.726665823982123E11,7.991673845249474E9), new Vector3(-15925.78496403673,-15381.16179928219,68.67560910598857));
        NamedBodyForcePair deimos = new NamedBodyForcePair("Deimos",1.8E20, new Vector3(-1.792255010450533E11,1.726891122683271E11,7.990659337380297E9), new Vector3(-17100.476719804457,-15020.348656808,631.2927851249581));
        NamedBodyForcePair phobos = new NamedBodyForcePair("Phobos",1.08E20, new Vector3(-1.792253482539647E11,1.72661109673625E11,7.987848354800322E9), new Vector3(-14738.203714241401,-13671.17675223948,-411.0012490555253));
        NamedBodyForcePair mercury = new NamedBodyForcePair("Mercury",3.301E23, new Vector3(-5.167375560011926E10,-4.217574885682655E10,1.14808913958168E9), new Vector3(21580.25398577148,-34951.03632847389,-4835.225596525241));
        NamedBodyForcePair venus = new NamedBodyForcePair("Venus",4.86747E24, new Vector3(-3.123150865740532E10,1.0395568504115701E11,3.173401325838074E9), new Vector3(-33748.180519629335,-10014.25141045021,1809.94488874165));
        NamedBodyForcePair vesta = new NamedBodyForcePair("Vesta",2.5908E20, new Vector3(-3.337493557929893E11,-4.7147908276077385E10,4.1923010146878105E10), new Vector3(4440.54247538484,-19718.49074006637,48.06573124543601));
        NamedBodyForcePair pallas = new NamedBodyForcePair("Pallas",2.14E20, new Vector3(4.3452066613895575E11,-2.057319365171432E11,1.0549957423213101E11), new Vector3(5058.947582097117,11184.45711782372,-8183.524138259704));
        NamedBodyForcePair hygiea = new NamedBodyForcePair("Hygiea",8.32E19, new Vector3(-3.983943433707043E11,2.325833000024021E11,-2.233667695713672E10), new Vector3(-6931.864585548552,-15686.8108598699,-690.5791992347208));
        NamedBodyForcePair ceres = new NamedBodyForcePair("Ceres",9.394E20, new Vector3(3.781372641419032E11,1.96718960466285E11,-6.366459168068592E10), new Vector3(-8555.324226752316,14718.33755980907,2040.230135060142));

        //TODO: implementation of this method according to 'Aufgabenblatt4.md'.
        double seconds = 0;
        HierarchicalSystem hs = new HierarchicalSystem(sun, mercury, venus,
                new HierarchicalSystem(earth, moon), new HierarchicalSystem(mars, deimos,
                phobos), vesta, pallas, hygiea, ceres);

        while(true){
            seconds++;

            hs.addForceTo(hs);
            hs.update();

            if (seconds % (3600) == 0) {
                cd.clear(Color.BLACK);
                hs.draw(cd);
                cd.show();
            }
        }

    }
}
