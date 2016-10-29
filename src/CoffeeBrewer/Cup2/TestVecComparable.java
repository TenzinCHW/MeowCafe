package CoffeeBrewer.Cup2;

import java.util.ArrayList;
import java.util.Collections;


// Test case for Vec
/**
 * Created by HanWei on 20/10/2016.
 */
public class TestVecComparable {
    public static void main(String[] args) {
        Vec a = new Vec();
        Vec b = new Vec(2,4);
        System.out.println(a);
        System.out.println(b);
        ArrayList<Vec> l = new ArrayList<>();
        l.add(new Vec(1,2));
        l.add(new Vec(-1,-3));
        l.add(new Vec(3.2,-2));
        l.add(new Vec(0,0));
        Collections.sort(l);
        System.out.println(l);
    }
}