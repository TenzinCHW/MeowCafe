package BeanGrinder.Week1;

/**
 * Created by HanWei on 18/9/2016.
 */
public class MyRectangle2D {
    // Week 1 Homework Question 7 - The MyRectangle2D class, Ground 7


    private double x;
    private double y;
    private double width;
    private double height;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double[] getMinMax() {
        double[] vertices = {x - width / 2, x + width / 2, y - height / 2, y + height / 2};
        return vertices;
    }

    public MyRectangle2D() {
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        return (getMinMax()[0] < x && getMinMax()[1] > x && getMinMax()[2] < y && getMinMax()[3] > y);
    }

    public boolean contains(MyRectangle2D r) {
        return (this.contains(r.getMinMax()[0], r.getMinMax()[2]) && this.contains(r.getMinMax()[0], r.getMinMax()[3]) && this.contains(r.getMinMax()[1], r.getMinMax()[2]) && this.contains(r.getMinMax()[1], r.getMinMax()[3]));
    }

    public boolean overlaps(MyRectangle2D r) {
        return !(this.contains(r)) && (this.contains(r.getMinMax()[0], r.getMinMax()[2]) || this.contains(r.getMinMax()[0], r.getMinMax()[3]) || this.contains(r.getMinMax()[1], r.getMinMax()[2]) || this.contains(r.getMinMax()[1], r.getMinMax()[3]));
    }
}