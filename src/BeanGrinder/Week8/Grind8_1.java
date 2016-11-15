package BeanGrinder.Week8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HanWei on 5/11/2016.
 */
public class Grind8_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your web address");
        String webAdd = in.nextLine();
        if (webValidate(webAdd)){
            System.out.println("It matches.");
        }else{
            System.out.println("Doesn't match.");
        }
    }

    public static boolean webValidate(String input){
        Pattern reg = Pattern.compile("(http|https|ftp)://(www\\.|m\\.)?([a-zA-Z1-9]|-|_)+\\.(com|edu|net)");
        Matcher matcher = reg.matcher(input);
        return matcher.matches();
    }
}
