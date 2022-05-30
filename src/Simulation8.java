import codedraw.CodeDraw;

// Simulates the solar system.
//
public class Simulation8 {

    // gravitational constant
    public static final double G = 6.6743e-11;

    // one astronomical unit (AU) is the average distance of earth to the sun.
    public static final double AU = 150e9; // meters

    // set some system parameters
    public static final double SECTION_SIZE = 10 * AU; // the size of the square region in space

    // all quantities are based on units of kilogram respectively second and meter.

    // The main simulation method using instances of other classes.
    public static void main(String[] args) {

        // simulation
        CodeDraw cd = new CodeDraw();

        // create solar system with 13 bodies
        MassiveForceTreeMap map = new MassiveForceTreeMap();

        map.put(new NamedBody("Oumuamua", 8e6, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Earth", 5.972E24, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Moon", 7.349E22, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));
        map.put(new NamedBody("Mars1", 6.41712E23, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
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
        map.put(new NamedBody("Ceres1", 9.394E20, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));


        //TODO: implementation of this method according to 'Aufgabenblatt8.md'.

        // add sun after states have been read from files.
        map.put(new NamedBody("Sun", 1.989E30, new Vector3(0, 0, 0), new Vector3(0, 0, 0)),
                new Vector3(0, 0, 0));

    }
}
