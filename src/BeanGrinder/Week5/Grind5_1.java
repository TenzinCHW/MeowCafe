package BeanGrinder.Week5;

/**
 * Created by HanWei on 16/10/2016.
 */
public class Grind5_1 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abdcba"));
        System.out.println(isPalindrome("ZZaZZ"));
        System.out.println(isPalindrome("124321"));
    }

    public static String isPalindrome(String input){
        if (palindromic(input)){
            return String.format("%s is a palindrome", input);
        }else {
            return String.format("%s is not a palindrome", input);
        }
    }

    public static boolean palindromic(String input){
        if (input.length() == 1){
            return true;
        }else if (input.length() == 2){
            if (input.charAt(0) == input.charAt(1)){
                return true;
            }else{
                return false;
            }
        }
        return palindromic(input.substring(1, input.length()-1));
    }
}
