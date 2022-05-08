import codedraw.CodeDraw;

import java.awt.*;
import java.util.Objects;

// This class represents celestial bodies like stars, planets, asteroids, etc..
public class Body implements Massive{

    //TODO: change modifiers.
    private double mass;
    private Vector3 massCenter; // position of the mass center.
    private Vector3 currentMovement;
    private Body mainbody;

    //TODO: define constructor.
    public Body(double mass, Vector3 massCenter, Vector3 currentMovement){
        this.mass = mass;
        this.massCenter = massCenter;
        this.currentMovement = currentMovement;
    }

    public Body(Body mainbody, double mass, Vector3 massCenter, Vector3 currentMovement){
        this.mainbody = mainbody;
        this.mass = mass;
        this.massCenter = massCenter;
        this.currentMovement = currentMovement;
    }

    // Returns the distance between the mass centers of this body and the specified body 'b'.
    public double distanceTo(Body b) {

        //TODO: implement method.
        return this.massCenter.distanceTo(b.massCenter);
    }

    // Returns a vector representing the gravitational force exerted by 'b' on this body.
    // The gravitational Force F is calculated by F = G*(m1*m2)/(r*r), with m1 and m2 being the
    // masses of the objects interacting, r being the distance between the centers of the masses
    // and G being the gravitational constant.
    // Hint: see simulation loop in Simulation.java to find out how this is done.
    @Override
    public Vector3 gravitationalForce(Massive b) {

        //TODO: implement method.
        Vector3 direction = b.getMassCenter().minus(this.massCenter);
        double distance = direction.length();
        direction.normalize();
        double force = Simulation.G * this.mass * b.getMass() / (distance * distance);
        return direction.times(force);
    }

    // Moves this body to a new position, according to the specified force vector 'force' exerted
    // on it, and updates the current movement accordingly.
    // (Movement depends on the mass of this body, its current movement and the exerted force.)
    // Hint: see simulation loop in Simulation.java to find out how this is done.
    @Override
    public void move(Vector3 force) {

        //TODO: implement method.
        if (force != null) {
            Vector3 newPos = this.currentMovement.plus(this.massCenter.plus(force.times(1/this.mass)));
            Vector3 newMov = newPos.minus(this.massCenter);
            this.massCenter = newPos;
            this.currentMovement = newMov;
        }
    }

    // Returns the approximate radius of this body.
    // (It is assumed that the radius r is related to the mass m of the body by r = m ^ 0.5,
    // where m and r measured in solar units.)
    @Override
    public double radius() {

        //TODO: implement method.
        return SpaceDraw.massToRadius(this.mass);
    }

    // Returns a new body that is formed by the collision of this body and 'b'. The impulse
    // of the returned body is the sum of the impulses of 'this' and 'b'.
    public Body merge(Body b) {

        //TODO: implement method.
        Body result = new Body(0, new Vector3(0,0,0), new Vector3(0,0,0));
        result.mass = this.mass + b.mass;
        result.massCenter = this.massCenter.times(this.mass).plus(b.massCenter.times(b.mass)).times(1/result.mass);
        result.currentMovement = this.currentMovement.times(this.mass).plus(b.currentMovement.times(b.mass)).times(1/result.mass);
        return result;
    }

    @Override
    public double mass(){
        return this.mass;
    }

    // Draws the body to the specified canvas as a filled circle.
    // The radius of the circle corresponds to the radius of the body
    // (use a conversion of the real scale to the scale of the canvas as
    // in 'Simulation.java').
    // Hint: call the method 'drawAsFilledCircle' implemented in 'Vector3'.
    @Override
    public void draw(CodeDraw cd) {

        //TODO: implement method.
        cd.setColor(SpaceDraw.massToColor(this.mass));
        this.massCenter.drawAsFilledCircle(cd, this.radius());
    }

    //returns true if this body collides with the Body b
    public boolean collidesWith(Body b) {
        return (this.distanceTo(b) < this.radius() + b.radius());
    }

    @Override
    public Vector3 massCenter(){
        return this.massCenter;
    }

    // Returns a string with the information about this body including
    // mass, position (mass center) and current movement. Example:
    // "5.972E24 kg, position: [1.48E11,0.0,0.0] m, movement: [0.0,29290.0,0.0] m/s."
    @Override
    public String toString() {
        //TODO: implement method.
        return this.mass+" kg, position: "+this.massCenter+" m, movement: "+this.currentMovement+" m/s";
    }

    //Getter for the Mass of the Body
    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public Vector3 getMassCenter() {
        return massCenter;
    }

    @Override
    public double getRadius() {
        return this.radius();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()){
            Body body = (Body) o;
            if (body.mass == this.mass) {
                if (body.massCenter.compVector(this.massCenter) && body.currentMovement.compVector(this.currentMovement)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (this != null) {
            hash = (int)this.mass + this.massCenter.summedVector() + this.currentMovement.summedVector();
        }
        return hash;
    }
}

