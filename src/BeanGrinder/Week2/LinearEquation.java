package BeanGrinder.Week2;

/**
 * Created by HanWei on 19/9/2016.
 */
public class LinearEquation {
    // Week 2 Homework 1
    // Should be Ground2_1
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double determinant;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        if (a * d - c * d != 0) {
            this.determinant = a * d - c * b;
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

    public boolean isSolvable() {
        return determinant != 0;
    }

    public double getX() {
        return (1.0/determinant)* (d * e - b * f);
    }

    public double getY() {
        return (1.0/determinant) * (-c * e + a * f);
    }
}