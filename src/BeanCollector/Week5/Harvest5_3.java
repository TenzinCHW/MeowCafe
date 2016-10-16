package BeanCollector.Week5;

import java.util.regex.Pattern;

/**
 * Created by HanWei on 16/10/2016.
 */
public class Harvest5_3 {
    public static void main(String[] args) {
        System.out.println(findSGnumber("8698 9823"));
        System.out.println(findSGnumber("+65 90013321"));
        System.out.println(findSGnumber("88 62319001"));
        System.out.println(findSGnumber("911"));
        System.out.println(findSGnumber("+6590010331443"));
        System.out.println(findSGnumber("001 65 6488 7771"));
        System.out.println(findSGnumber("+656565 6565"));
    }

    public static String findSGnumber(String input){
        if (Pattern.matches("(\\+65 )?[689][0-9]{3}( )?[0-9]{4}", input)){
            return String.format("Found good phone number: %s", input);
        }else {
            return String.format("Found bad phone number: %s", input);
        }
    }
}
