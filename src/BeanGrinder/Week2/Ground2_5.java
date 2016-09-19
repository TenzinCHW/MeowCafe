package BeanGrinder.Week2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by HanWei on 19/9/2016.
 */
public class Ground2_5 implements Comparable<Ground2_5> {
    // Week 2 Homework Question 5

    private double side;
    public Ground2_5(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }

    @Override
    public int compareTo(Ground2_5 o){
        if (o.getSide() == this.getSide()){
            return 0;
        }
        else if (o.getSide() > this.getSide()){
            return -1;
        }
        else{
            return 1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Ground2_5> l = new ArrayList<Ground2_5>();
        l.add(new Ground2_5(2));
        l.add(new Ground2_5(3));
        l.add(new Ground2_5(1));
        Collections.sort(l);
        for (Ground2_5 o:l)
            System.out.println(o.getSide());
    }
}
