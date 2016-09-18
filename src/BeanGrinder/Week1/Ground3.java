package BeanGrinder.Week1;

import java.util.ArrayList;

/**
 * Created by HanWei on 18/9/2016.
 */
public class Ground3 {
    // Week 1 Homework Question 3 - Prime Number Checker
    public static void main(String[] args) {
        int[] meow = {4, 7, 14, 23, 99};
        for (int i :
                meow) {
            System.out.println(isPrime(i));
        }
    }

    public static int isPrime(int num) {
        int[] somePrimes = {2, 3, 5, 7, 11, 13, 17, 19};    // Will only work for some prime numbers
        for (int i : somePrimes) {
            if (num % i == 0 && num / i != 1) {
                return 0;
            }
        }
        return 1;
    }
}
