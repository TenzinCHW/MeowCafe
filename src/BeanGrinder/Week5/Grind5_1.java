package BeanGrinder.Week5;

import java.util.Arrays;

/**
 * Created by HanWei on 16/10/2016.
 */
public class Grind5_1 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba".toCharArray()));
        System.out.println(isPalindrome("abdcba".toCharArray()));
        System.out.println(isPalindrome("ZZaZZ".toCharArray()));
        System.out.println(isPalindrome("124321".toCharArray()));
    }

    public static boolean isPalindrome(char[] input){
        if (input.length == 1){
            return true;
        }else if (input.length == 2){
            if (input[0] == input[1]){
                return true;
            }else{
                return false;
            }
        }
        return isPalindrome(Arrays.copyOfRange(input, 1, input.length-1));
    }
}
