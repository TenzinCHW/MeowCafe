package BeanGrinder.Week4;

/**
 * Created by HanWei on 8/10/2016.
 */
public class Grind4_2 {
    public static void testScores(double[] s) throws IllegalArgumentException { // change tutor's method to static
        for (int i = 0; i < s.length; i++) {
            if (s[i] < 0.0 || s[i] > 100.0){
                throw new IllegalArgumentException("Element:" + i + "  Score:" + s[i]);
            }
        }
    }

    public static void main(String[] args) {
        try {
            double[] values = {1.2,1.3,1,102};
            testScores(values);
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex);
            System.out.println("Exception: Values cannot be less than 0 or bigger than 100 ");
        }
        System.out.println("Execution continues here");

    }
}
