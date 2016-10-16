package BeanGrinder.Week5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HanWei on 16/10/2016.
 */
public class Grind5_2 {
    public static void main(String[] args) {
        System.out.println(chkNRIC("A3317213R 1963"));
        System.out.println(chkNRIC("S7931123G 1979"));
        System.out.println(chkNRIC("T2279982L 1999"));
        System.out.println(chkNRIC("T1245336V   2012"));
//        System.out.println(Pattern.matches("(\\d\\d)\\1", "1212"));
    }

    public static String chkNRIC(String input){
        String result;
        int birthyear = Integer.parseInt(input.substring(1,3));
        Pattern boom = Pattern.compile(".(\\d\\d).*\\d\\d\\1$");
        Matcher yesboom = boom.matcher(input);
        Pattern strawberry = Pattern.compile(".(\\d\\d).*20\\1$");
        Matcher yesstrawberry = strawberry.matcher(input);
        if ((input.charAt(0) == 'S' || input.charAt(0) == 'F') && 68 <= birthyear && birthyear <= 99 && yesboom.find()){
            result = "No Error";
        }else if (input.charAt(0) == 'T' && yesstrawberry.find()){
            result = "No Error";
        }else{
            result = "Error";
        }
        return result;
    }
}
