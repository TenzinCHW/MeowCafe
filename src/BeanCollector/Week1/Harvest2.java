package BeanCollector.Week1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by HanWei on 15/9/2016.
 */
public class Harvest2 {
    public static void main(String[] args){
        // This is the third question for week 1
        List<Integer> woof = new ArrayList<Integer>();
        for (int i = 1; i < 6; i++){
            woof.add(i);
        }
        System.out.println(forlooping(woof));
        System.out.println(iterator(woof));
    }

    public static int iterator(List<Integer> integers){
        // Part 1
        int total = 0;
        Iterator<Integer> woof = integers.iterator();

        while (woof.hasNext()){
            total += woof.next();
        }
        return total;
    }

    public static int forlooping(List<Integer> integers){
        // Part 2
        int total = 0;
        for (Integer item : integers){
            total += item.intValue();
        }
        return total;
    }

}
