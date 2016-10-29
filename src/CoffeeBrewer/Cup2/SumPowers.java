package CoffeeBrewer.Cup2;

/**
 * Created by HanWei on 20/10/2016.
 */
public class SumPowers {
    public static void main(String[] args) {
        System.out.println(sumpowers(3));
    }
    public static long sumpowers (int n) {
        if (n == 1){
            return 1;
        }else {
            return calculate(n) + sumpowers(n - 1);
        }
    }

    public static long calculate(int a){
        if (a%2 == 0){
            return (long)Math.pow(a, 3);
        }else{
            return (long)Math.pow(a, 2);
        }
    }
}
