package BeanGrinder.Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HanWei on 18/9/2016.
 */
public class Ground6 {
    // Week 1 Homework Question 6 - White Space Trimmer
    public static void main(String[] args) {
        ArrayList<String> raar = new ArrayList<String>();
        raar.add(" red ");
        raar.add(" white ");
        raar.add(" blue ");
        System.out.println(listTrim(raar));
    }

    public static List<String> listTrim(List<String> strings){
        ArrayList<String> meow = new ArrayList<String>();

        for (String woof :
                strings) {
            meow.add(woof.trim());
        }
        return meow;
    }
}
