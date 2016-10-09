package BeanGrinder.Week4;

import java.util.Scanner;

/**
 * Created by HanWei on 8/10/2016.
 */
public class Grind4_1 {
    public static void main(String[] args) {
        System.out.println("Welcome to the modulus computer.");
        Scanner in = new Scanner(System.in);
        String cont = "y";
        String meow;
        String woof;
        int num;
        int den;
        int ans;
        String result;
        while (cont.equalsIgnoreCase("y")) {
            System.out.println("Enter two integer values");
            meow = in.next();
            woof = in.next();
            try {
                num = Integer.parseInt(meow);
                den = Integer.parseInt(woof);
                ans = num / den;
                result = String.format("%d divided by %d is %d", num, den, ans);//num / den);
                System.out.println(result);
            } catch (ArithmeticException e) {
                System.out.println("Sorry, cannot compute mod by 0");
            } catch (NumberFormatException n) {
                System.out.println("Sorry, you must enter two integer values");
            }
            System.out.println("Do another pair of values? (y)");
            cont = in.next();
        }
    }

}
