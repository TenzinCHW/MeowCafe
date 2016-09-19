package BeanGrinder.Week1;

/**
 * Created by HanWei on 18/9/2016.
 */
public class Ground1_2 {
    // Week 1 Homework Question 2 - Power2 Generator
    public static void main(String[] args) {
        System.out.println(printNums());
    }

    public static String printNums(){
        String meow = "";
        for (int i = 0; i < 8; i++) {
            meow += power(2, i) + " ";
        }
        return meow;
    }

    public static int power(int base, int power) {

        if (power == 0) {
            return 1;
        }
        else if (power == 1){
            return base;
        }
        else {
            int total = base;
            for (int i = 1; i < power; i++) {
                total *= base;
            }
            return total;
        }
    }
}
