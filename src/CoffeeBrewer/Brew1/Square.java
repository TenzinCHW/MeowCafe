package CoffeeBrewer.Brew1;

/**
 * Created by HanWei on 29/9/2016.
 */
public class Square extends GeometricObject{
    private double x;
    private double y;
    private double sideLength;

    public Square() {
        this(0, 0, 1.0);
    }
    public Square(double x, double y, double sideLength){
        this.x = x;
        this.y = y;
        this.sideLength = sideLength;
    }

    public boolean contains(double X, double Y){
        return Math.abs(X-x) < sideLength/2.0 && Math.abs(Y-y) < sideLength/2.0;
    }

    public boolean contains(Square inSquare){
        double x1 = inSquare.x - inSquare.sideLength/2.0;
        double x2 = inSquare.x + inSquare.sideLength/2.0;
        double y1 = inSquare.y - inSquare.sideLength/2.0;
        double y2 = inSquare.y + inSquare.sideLength/2.0;
        return this.contains(x1, y1) && this.contains(x1, y2) && this.contains(x2, y1) && this.contains(x2, y2);
    }

    @Override
    public String toString(){
        return "I am a Square with color: " + this.getColor() + " and side length: " + this.sideLength;
    }

    public double getArea(){
        return Math.pow(sideLength, 2);
    }

    public double getPerimeter(){
        return 4.0*sideLength;
    }
}

abstract class GeometricObject {
    protected String color;
    protected boolean filled = false;
    protected java.util.Date dateCreated;

    public GeometricObject() {
        color = "yellow";
        dateCreated = new java.util.Date();
    }

    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public String toString() {
        return "color: " + color + " filled: " + filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
