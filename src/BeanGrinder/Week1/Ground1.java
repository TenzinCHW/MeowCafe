package BeanGrinder.Week1;

/**
 * Created by HanWei on 18/9/2016.
 */
public class Ground1 {
    // This is homework for week 1
    // Question 1 - Birth Year Generator
    public static void main(String[] args) {
        calYearOfBirth(2013, 8);
    }

    public static int calYearOfBirth(int yearCurrent, int age){
        return yearCurrent - age;
    }

}
