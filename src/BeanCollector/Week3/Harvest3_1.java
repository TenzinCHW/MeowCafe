package BeanCollector.Week3;

import java.util.Scanner;

/**
 * Created by HanWei on 3/10/2016.
 */
public class Harvest3_1 {
    public static void main(String[] args) {
        int[] test = {10, 40, 101, -35};
        try{
            for (int i = 0; i < test.length; i++) {
                if (test[i] < 0 || test[i] > 100){
                    TestScores();
                }
            }
        }catch (IllegalArgumentException meow){
            System.out.println("Error occured! " + meow);
        }
    }

    private static void TestScores() throws IllegalArgumentException{
        throw new IllegalArgumentException();
    }
}
