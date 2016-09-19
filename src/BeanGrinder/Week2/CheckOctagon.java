package BeanGrinder.Week2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by HanWei on 19/9/2016.
 */
public class CheckOctagon {
    public static void main(String[] args) {
        ArrayList<Octagon> l = new ArrayList<Octagon>();
        l.add(new Octagon(2));
        l.add(new Octagon(3));
        l.add(new Octagon(1));
        Collections.sort(l);
        for (Octagon o:l)
            System.out.println(o.getSide());
    }
}
