package BeanGrinder.Week5;

import java.util.regex.Pattern;

/**
 * Created by HanWei on 16/10/2016.
 */
public class Grind5_2 {
    public static void main(String[] args) {
        System.out.println(NRIC("A3317213R 1963"));
        System.out.println(NRIC("S7931123G 1979"));
        System.out.println(NRIC("T2279982L 1999"));
        System.out.println(NRIC("T1245336V   2012"));
//        System.out.println(Pattern.matches("(\\d\\d)\\1", "1212"));
    }

    public static String NRIC(String input){
        String result;
        int birthyear = Integer.parseInt(input.substring(1,3));
        System.out.println(birthyear);
        if (input.charAt(0) == 'S' && 68 <= birthyear && birthyear <= 99 && Pattern.matches(".(\\d\\d).*\\d\\d\\1$", input)){
            result = " - No Error";
        }else if (input.charAt(0) == 'T' && Pattern.matches(".(\\d\\d).*20\\1$", input)){
            result = " - No Error";
        }else{
            result = " - Error";
        }
        return input + result;
    }
}
