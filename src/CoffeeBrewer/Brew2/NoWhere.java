package CoffeeBrewer.Brew2;

/**
 * Created by HanWei on 19/10/2016.
 */
public class NoWhere extends Exception {
    static void test() {
        throw new NullPointerException();
    }


    public static void main(String[] args) {
        try  {
            test();
        }catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
            ex.printStackTrace();
        }
    }
}
