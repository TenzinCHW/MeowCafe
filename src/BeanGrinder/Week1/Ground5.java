package BeanGrinder.Week1;

import java.util.Arrays;

/**
 * Created by HanWei on 18/9/2016.
 */
public class Ground5 {
    // Week 1 Homework Question 5 - Integer Sorter
    public static void main(String[] args) {
        int[] first = {2, -3, 1, 5, 0, -10};
        int[] second = {84, 72, 60, 48, 36, 24, 12};
        int[] third = {-1, -2, -3, -4, 99, -4, -3, -2, -1};
        System.out.println(Arrays.toString(bubbleSort(first)));
        System.out.println(Arrays.toString(bubbleSort(second)));
        System.out.println(Arrays.toString(bubbleSort(third)));
    }

    public static int[] bubbleSort(int[] inarray){
        int loops = inarray.length;
        for (int i = 0; i < loops-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < loops-1; j++) {
                if (inarray[j] > inarray[j+1]){
                    swap(inarray, j);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
        return inarray;
    }

    public static void swap(int[] inarray, int i){
        int meow = inarray[i];
        inarray[i] = inarray[i+1];
        inarray[i+1] = meow;
    }
}
