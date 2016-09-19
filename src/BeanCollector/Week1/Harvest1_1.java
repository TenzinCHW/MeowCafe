package BeanCollector.Week1;

/**
 * Created by HanWei on 13/9/2016.
 */
public class Harvest1_1 {
    // This is Question 1 in Week 1's cohort for Info Sys

    public static void main(String[] args1){
        System.out.println(fibonacci());
    }

    public static String fibonacci(){
        String toprint = "";
        for (int i=0; i<20; i++){
            if (i!=19) {
                toprint += fib(i) + ",";
            }
            else{
                toprint += fib(i);
            }
        }
        return toprint;
    }

    public static int fib(int n){   // Helper function to calculate the value of the nth number in the Fibonacci sequence
        if (n<2){
            return n;   // Base case
        }
        else{
            return fib(n-1) + fib(n-2); // Recursive call
        }
    }
}
