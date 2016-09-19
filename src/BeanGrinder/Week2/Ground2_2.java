package BeanGrinder.Week2;

/**
 * Created by HanWei on 19/9/2016.
 */

import java.lang.StrictMath;

public class Ground2_2 extends GeometricObject {
    // Week 2 Homework 2

    private double side1;
    private double side2;
    private double side3;

    Ground2_2(){
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    Ground2_2(double s1, double s2, double s3){
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public String toString(){
        return "Ground2_2: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    public double getArea(){
        double p = getPerimeter()/2.0;
        return StrictMath.sqrt(p * (p-side1) * (p-side2) * (p-side3));
    }
}
