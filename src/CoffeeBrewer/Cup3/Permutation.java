package CoffeeBrewer.Cup3;

import java.util.ArrayList;

/**
 * Created by HanWei on 24/11/2016.
 */
public class Permutation {
    private final String in;
    private ArrayList<String> a = new ArrayList<String>();
    // additional attribute if needed
    private String temp;
    private String currentlyPermuting;


    Permutation(final String str) {
        in = str;
        // additional initialization if needed
        currentlyPermuting = "";
        temp = "";
        for (int i = 0; i < in.length(); i++) {
            temp += str.substring(i, i + 1);
        }
    }

    public void permute() {
        if (temp.length() == 1) {
            currentlyPermuting += temp;
            a.add(currentlyPermuting);
            currentlyPermuting = "";
        } else {
            for (int i = 0; i < temp.length(); i++) {
                currentlyPermuting += temp.substring(0, 1);
                temp = temp.substring(0, i) + temp.substring(i+1);
                permute();
                temp = in.substring(1) + in.substring(0,1);
            }
        }
    }

    public ArrayList<String> getA() {
        return a;
    }
}