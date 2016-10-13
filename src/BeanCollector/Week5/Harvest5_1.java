package BeanCollector.Week5;

/**
 * Created by HanWei on 13/10/2016.
 */
public class Harvest5_1 {
    public static void main(String[] args) {
        System.out.println(mcn(4,1));
        System.out.println(mcn(6,2));
        System.out.println(mcn(8,5));
        System.out.println(mcn(12,8));
    }

    public static int factorial(int n){
        return factorial1(n, 1);
    }

    public static int factorial1(int n, int acc){
        if (n == 0){
            return acc;
        }else {
            return factorial1(n-1, n * acc);
        }
    }

    public static long mcn(int m, int n) {
        return factorial(m)/(factorial(n)*factorial(m-n));
    }
}
