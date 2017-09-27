package CoffeeBrewer.Cup3;

import java.util.ArrayList;

/**
 * Created by HanWei on 24/11/2016.
 */
public class TestPermutation {
    public static void main(String[] args) {
        ArrayList<String> v;

        Permutation p = new Permutation("hat");
        p.permute();
        v = p.getA();
        System.out.println(v);

    }
}
