package CoffeeBrewer.Cup1;

/**
 * Created by HanWei on 26/9/2016.
 */
public class Cup1_2 {

    // Base62
    public static boolean divisible(String x) {
        int total = 0;
        int woof;
        char[] meow = new char[x.length()];
        for (int i = 0; i < x.length(); i++) {
            meow[x.length() - i - 1] = x.charAt(i);
        }
        for (int i = 0; i < x.length(); i++) {
            woof = (int)meow[i];
            double thing = Math.pow(62, i);
            if (47 < woof && woof < 58) {
                total += (woof - 48) * thing;
            } else if (64 < woof && woof < 91) {
                total += (woof - 55) * thing;
            } else {
                total += (woof - 61) * thing;
            }
        }
        return total % 61 == 0;
    }

    public static void main(String[] args) {
        System.out.println(divisible("1v3"));
        System.out.println(divisible("2P6"));
        System.out.println(divisible("iLoveJava"));
    }
}
