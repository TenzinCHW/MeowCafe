package BeanGrinder.Week2;

/**
 * Created by HanWei on 19/9/2016.
 */
public class Ground2_1 {
    // Week 2 Homework Question 1
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double determinant;

    public Ground2_1(double a, double b, double c, double d, double e, double f) {
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

    public static void main(String[] args) {
        double a = 1.0;
        double b = 2.0;
        double c = 3.0;
        double d = 5.0;
        double e = 6.0;
        double f = 7.0;
        Ground2_1 equation = new Ground2_1(a, b, c, d, e, f);
        if (equation.isSolvable()) {
            System.out.println("x is " +
                    equation.getX() + " and y is " + equation.getY());
        } else {
            System.out.println("The equation has no solution");
        }
        Ground2_1 equation2 = new Ground2_1(1.25, 2.0, 2.0, 4.2, 3.0, 6.0);
        if (equation2.isSolvable()) {
            System.out.println("x is " + equation2.getX() + " y is " + equation2.getY());
        }
        Ground2_1 equation3 = new Ground2_1(1.0, 2.0, 2.0, 4.0, 3.0, 6.0);
        System.out.println(equation3.isSolvable());
    }
}