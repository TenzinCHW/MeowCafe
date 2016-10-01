package CoffeeBrewer.Brew1;

/**
 * Created by HanWei on 29/9/2016.
 */
public class TstSquare {
    public static void main(String[] args) {
        Square s1 = new Square();
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        s1.setColor("blue");
        System.out.println(s1);
        Square s2 = new Square(0.1, 0.2, 0.3);
        System.out.println(s1.contains(0.6, 0.5));
        System.out.println(s1.contains(s2));
    }
}