package CoffeeBrewer.Brew2;

/**
 * Created by HanWei on 19/10/2016.
 */
public class Test {
    public static void main(String[] args)
    {
        double[] badScores = {97.5, -1.0, 88.0, 99.0, 99.0 };
        try{
            InvalidTest inv = new InvalidTest();
            inv.testScores(badScores);
        }
        catch (InvalidTest e){
            System.out.println("Invalid score found.\n" + e.getMessage());
        }
    }
}
