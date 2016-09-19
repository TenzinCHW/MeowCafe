package BeanGrinder.Week1;

/**
 * Created by HanWei on 18/9/2016.
 */
public class Ground1_7 {
    // Week 1 Homework Question 7 - The Ground1_7 class


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
        // Helper function that returns the value of {minX, maxX, minY, maxY} of the rectangle, in that order
    }

    public Ground1_7() {
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }

    public Ground1_7(double x, double y, double width, double height) {
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
        // Make sure that value of x is in between the minimum and maximum x value of the rectangle
        // and that value of y is also in between the minimum and maximum y value of the rectangle
    }

    public boolean contains(Ground1_7 r) {
        return (this.contains(r.getMinMax()[0], r.getMinMax()[2]) &&
                this.contains(r.getMinMax()[0], r.getMinMax()[3]) &&
                this.contains(r.getMinMax()[1], r.getMinMax()[2]) &&
                this.contains(r.getMinMax()[1], r.getMinMax()[3]));
        // This rectangle should fully contain the corners of the the other rectangle
    }

    public boolean overlaps(Ground1_7 r) {
        double minX1 = this.getMinMax()[0];
        double maxX1 = this.getMinMax()[1];
        double minY1 = this.getMinMax()[2];
        double maxY1 = this.getMinMax()[3];
        double minX2 = r.getMinMax()[0];
        double maxX2 = r.getMinMax()[1];
        double minY2 = r.getMinMax()[2];
        double maxY2 = r.getMinMax()[3];

        return !(maxX2 < minX1 ||   // Go figure.
        minX2 > maxX1 ||
        maxY2 < minY1 ||
        minY2 > maxY1);

//        return !(this.contains(r) || r.contains(this)) &&   // One rectangle should not contain the other
//                (this.contains(r.getMinMax()[0], r.getMinMax()[2]) ||   // But one should contain at least one of the
//                this.contains(r.getMinMax()[0], r.getMinMax()[3]) ||    //other's points
//                this.contains(r.getMinMax()[1], r.getMinMax()[2]) ||
//                this.contains(r.getMinMax()[1], r.getMinMax()[3]))||
//                (r.contains(this.getMinMax()[0], this.getMinMax()[2]) ||
//                r.contains(this.getMinMax()[0], this.getMinMax()[3])  ||
//                r.contains(this.getMinMax()[1], this.getMinMax()[2])  ||
//                r.contains(this.getMinMax()[1], this.getMinMax()[3])) ||    // next few lines make sure they don't make
//                ((this.getMinMax()[3] > r.getMinMax()[3] && this.getMinMax()[2] < r.getMinMax()[2] &&  // cross mark
//                this.getMinMax()[0] > r.getMinMax()[0] && this.getMinMax()[1] < r.getMinMax()[1])  ||
//                 (this.getMinMax()[3] < r.getMinMax()[3] && this.getMinMax()[2] > r.getMinMax()[2] &&
//                 this.getMinMax()[0] < r.getMinMax()[0] && this.getMinMax()[1] > r.getMinMax()[1]));
    }

    public static void main(String[] args) {
        // Please insert tests here :x
    }
}