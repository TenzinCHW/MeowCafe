package BeanGrinder.Week1;

/**
 * Created by HanWei on 18/9/2016.
 */
public class Ground1_4 {
    // Week 1 Homework Question 4 - Hailstone Sequence Counter
    public static void main(String[] args) {
        System.out.println(Counter(1));
        System.out.println(Counter(21));
        System.out.println(Counter(999));
    }

    public static int Counter(int n){
        int count = 0;
        while (n != 1){
            if (n%2 == 0){
                n /= 2;
            }
            else{
                n = 3 * n + 1;
            }
            count += 1;
        }
        return count;
    }
}
