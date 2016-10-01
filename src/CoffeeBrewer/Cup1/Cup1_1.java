package CoffeeBrewer.Cup1;

/**
 * Created by HanWei on 26/9/2016.
 */
public class Cup1_1 extends GeometricObject{
    // Rect
    private double width;
    private double height;

    public Cup1_1(){
        width = 1.0;
        height = 1.0;
    }

    public Cup1_1(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width * height;
    }

    @Override
    public String toString(){
        return "I am a rectangle of width " + width + " and height " + height + ".";
    }

    public static void main(String[] args) {
        TestRect();
    }
    public static void TestRect() {
        Cup1_1 r1 = new Cup1_1();
        System.out.println(r1);
        System.out.println(r1.getArea());
        Cup1_1 r2 = new Cup1_1(2, 12); // width, height
        System.out.println(r2);
        System.out.println(r2.getArea());
    }
}
