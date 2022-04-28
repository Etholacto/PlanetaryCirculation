import codedraw.CodeDraw;

// An object that can be drawn in a CodeDraw canvas.
//
public interface Drawable {

    //draws the object into the canvas 'cd'
    //Precondition: cd != null
    void draw(CodeDraw cd);
}
