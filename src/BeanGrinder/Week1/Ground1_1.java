package BeanGrinder.Week1;

/**
 * Created by HanWei on 18/9/2016.
 */
public class Ground1_1 {
    // Week 1 Homework Question 1 - Birth Year Generator
    public static void main(String[] args) {
        calYearOfBirth(2013, 8);
    }

    public static int calYearOfBirth(int yearCurrent, int age){
        return yearCurrent - age;
    }

}
