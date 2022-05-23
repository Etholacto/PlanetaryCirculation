import codedraw.CodeDraw;

// A cosmic system that is composed of a central named body (of type 'NamedBodyForcePair')
// and an arbitrary number of subsystems (of type 'HierarchicalSystem') in its orbit.
// This class implements 'CosmicSystem'.
//
public class HierarchicalSystem implements CosmicSystem, MassiveIterable /* TODO: add clause */ {

    // TODO: define missing parts of this class.
    NamedBodyForcePair central;
    CosmicSystem[] inOrbit;

    // Initializes this system with a name and a central body.
    public HierarchicalSystem(NamedBodyForcePair central, CosmicSystem... inOrbit) {
        // TODO: implement constructor.
        this.central = central;
        this.inOrbit = inOrbit;
    }

    @Override
    public String toString() {
        String system = central.getName() + " {";
        for (int i = 0; i < inOrbit.length; i++) {
            if (i == inOrbit.length - 1) {
                system = system + inOrbit[i].toString();
            } else {
                system = system + inOrbit[i].toString() + ", ";
            }
        }
        system = system + '}';
        return system;
    }

    @Override
    public Vector3 getMassCenter() {
        Vector3 sum = this.central.getMassCenter();
        for (int i = 0; i < this.inOrbit.length; i++) {
            sum = sum.plus(this.inOrbit[i].getMassCenter());
        }
        return sum;
    }

    @Override
    public double getMass() {
        double sum = this.central.getMass();
        for (int i = 0; i < this.inOrbit.length; i++) {
            sum += (this.inOrbit[i].getMass());
        }
        return sum;
    }

    @Override
    public int numberOfBodies() {
        int count = 1;
        for (int i = 0; i < this.inOrbit.length; i++) {
            count += this.inOrbit[i].numberOfBodies();
        }
        return count;
    }

    @Override
    public double distanceTo(CosmicSystem cs) {
        return 0;
    }

    @Override
    public void addForceFrom(Body b) {
        this.central.addForceFrom(b);
        for (int i = 0; i < this.inOrbit.length; i++) {
            this.inOrbit[i].addForceFrom(b);
        }
    }

    @Override
    public void addForceTo(CosmicSystem cs) {
        BodyLinkedList linklis = this.getBodies();
        int length = linklis.size();
        for (int i = 0; i < length; i++) {
            Body b = linklis.pollFirst();
            cs.addForceFrom(b);
        }
    }

    @Override
    public BodyLinkedList getBodies() {
        BodyLinkedList bodlist = new BodyLinkedList();
        bodlist.addFirst(this.central.getBody());
        for (int i = 0; i < this.inOrbit.length; i++) {
            BodyLinkedList tmp = this.inOrbit[i].getBodies();
            for (int j = 0; j < this.inOrbit[i].getBodies().size(); j++) {
                bodlist.addLast(tmp.pollLast());
            }
        }
        return bodlist;
    }

    @Override
    public void update() {
        this.central.update();
        for (int i = 0; i < this.inOrbit.length; i++) {
            this.inOrbit[i].update();
        }
    }

    @Override
    public void draw(CodeDraw cd) {
        this.central.draw(cd);
        for (int i = 0; i < this.inOrbit.length; i++) {
            this.inOrbit[i].draw(cd);
        }
    }

    @Override
    public int getNumberOfCentralBodies() {
        int count = 1;
        if (this.central != null) {
            for (int i = 0; i < inOrbit.length; i++) {
                count += this.inOrbit[i].getNumberOfCentralBodies();
            }
        }
        return count;
    }

    @Override
    public MassiveIterator iterator() {
        return new MyMassiveIterator(new MyListNode2(this.central.getBody(), null, null));
    }
}

public class MyMassiveIterator implements MassiveIterator{
    private MyListNode2 node;
    private MyMassiveIterator iter;

    public MyMassiveIterator(MyListNode2 node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return node != null || (iter != null && iter.hasNext());
    }

    @Override
    public Massive next() {
        if (node == null) {
            if (iter != null && !iter.hasNext()) return null;
        }
        Massive massive;

        if (iter != null && iter.hasNext()) {
            return iter.next();
        } else {
            Massive c = node.Myvalue();

            if (c.getClass() == NamedBodyForcePair.class) {
                massive = c;
                node = node.getNext();
            } else if (c.getClass() == NamedBodyForcePair.class) {
                iter = (NamedBodyForcePair)c.iterator();
                node = node.getNext();

                massive = iter.next();
            } else return null;

            return massive;
        }
    }
}
