package CoffeeBrewer.Brew2;

/**
 * Created by HanWei on 19/10/2016.
 */
public class InvalidTest extends Exception{
    public InvalidTest() {
        super();
    }

    public InvalidTest(String message){
        super(message);
    }
    public static void testScores(double[] s) throws InvalidTest{
        for (int i = 0; i <s.length; i++) {
            if (s[i] < 0 || s[i] > 100){
                throw new InvalidTest("Score negative or bigger than 100: " + s[i]);
            }
        }
    }
}
