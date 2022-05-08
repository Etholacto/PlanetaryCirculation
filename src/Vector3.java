import codedraw.CodeDraw;

import java.awt.*;

// This class represents vectors in a 3D vector space.
public class Vector3 {

    //TODO: change modifiers.
    private double x;
    private double y;
    private double z;

    //TODO: define constructor.
    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Returns the sum of this vector and vector 'v'.
    public Vector3 plus(Vector3 v) {

        //TODO: implement method.
        return new Vector3(this.x+v.x, this.y+v.y, this.z+v.z);
    }

    // Returns the product of this vector and 'd'.
    public Vector3 times(double d) {

        //TODO: implement method.
        return new Vector3(this.x*d, this.y*d, this.z*d);
    }

    // Returns the sum of this vector and -1*v.
    public Vector3 minus(Vector3 v) {

        //TODO: implement method.
        return new Vector3(this.x-v.x, this.y-v.y, this.z-v.z);
    }

    // Returns the Euclidean distance of this vector
    // to the specified vector 'v'.
    public double distanceTo(Vector3 v) {

        //TODO: implement method.
        double distx = this.x-v.x;
        double disty = this.y-v.y;
        double distz = this.z-v.z;
        return Math.sqrt(distx*distx+disty*disty+distz*distz);
    }

    // Returns the length (norm) of this vector.
    public double length() {

        //TODO: implement method.
        return  this.distanceTo(new Vector3(0,0,0));
    }

    // Normalizes this vector: changes the length of this vector such that it becomes 1.
    // The direction and orientation of the vector is not affected.
    public void normalize() {

        //TODO: implement method.
        double leng = this.length();
        x /= leng;
        y /= leng;
        z /= leng;
    }

    // Draws a filled circle with a specified radius centered at the (x,y) coordinates of this vector
    // in the canvas associated with 'cd'. The z-coordinate is not used.
    public void drawAsFilledCircle(CodeDraw cd, double radius) {

        //TODO: implement method.
        double x = cd.getWidth() * (this.x + Simulation.SECTION_SIZE / 2) / Simulation.SECTION_SIZE;
        double y = cd.getWidth() * (this.y + Simulation.SECTION_SIZE / 2) / Simulation.SECTION_SIZE;
        radius = cd.getWidth() * radius / Simulation.SECTION_SIZE;
        cd.fillCircle(x, y, Math.max(radius, 1.5));
    }

    // Returns the coordinates of this vector in brackets as a string
    // in the form "[x,y,z]", e.g., "[1.48E11,0.0,0.0]".
    public String toString() {

        //TODO: implement method.
        return "["+x+","+y+","+z+"]";
    }

    public int summedVector(){
        int sum = (int)this.x + (int)this.y + (int)this.z;
        return sum;
    }

    public boolean compVector(Vector3 v){
        if (this.x == v.x && this.y == v.y && this.z == v.z) {
            return true;
        }
        return false;
    }
}

