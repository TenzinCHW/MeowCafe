package BeanGrinder.Week2;

import java.util.Arrays;

/**
 * Created by HanWei on 19/9/2016.
 */
public class Ground2_4 {
    // Week 2 Homework Question 4

    public static boolean isAllCharacterUnique(String sIn){
        char[] testStr = sIn.toCharArray(); // Create char array
        char[] unique = new char[sIn.length()];
        unique[0] = testStr[0];
        for (int i = 1; i < sIn.length(); i++) {
            for (int j=0; j < i; j++) {
                if (testStr[i] == unique[j]){
                    return false;
                }
                else {
                    unique[i] = testStr[i];
                }
            }
        }
        return true;
    }

    public static boolean isPermutation(String sIn1, String sIn2){
        char[] arr1 = sIn1.toCharArray();
        char[] arr2 = sIn2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
//        Arrays.parallelSort(arr1);    // TutorJ does not have parallelSort D:
//        Arrays.parallelSort(arr2);
        if (sIn1.length() > sIn2.length()){
            for (int i = 0; i < sIn1.length(); i++) {
                if (arr1[i] != arr2[i]){
                    return false;
                }
            }
        }
        else{
            for (int i = 0; i < sIn2.length(); i++) {
                if (arr1[i] != arr2[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAllCharacterUnique("qwertyuiopasdfghjklzxcvbnmq"));
        System.out.println(isPermutation("MeowWoof", "eofwMoWo"));
    }
}
