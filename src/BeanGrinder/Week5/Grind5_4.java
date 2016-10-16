package BeanGrinder.Week5;

/**
 * Created by HanWei on 16/10/2016.
 */
public class Grind5_4 {
    public static void main(String[] args) {
        System.out.println(wordMatch("meow", "mfdknwnvdofde"));
    }

    public static boolean wordMatch(String in1, String in2) {
        int grr = 0;
        for (int i = 0; i < in1.length(); i++) {
            if (in2.contains(in1.substring(i, i+1))){
                grr += 1;
            }
        }
        if (grr == in1.length()){
            return true;
        }else{
            return false;
        }
    }
}
