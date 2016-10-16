package BeanCollector.Week5;

import java.util.regex.Pattern;

/**
 * Created by HanWei on 13/10/2016.
 */
public class Harvest5_2 {
    public static void main(String[] args) {
        System.out.println(chkSentence("Timothy's Java program is done?")+"Timothy's Java program is done?");
        System.out.println(chkSentence("I like SUTD."));
        System.out.println(chkSentence("It?s a cloudy day."));
        System.out.println(chkSentence("All's well that ends well-"));
        System.out.println(chkSentence("All's well that ends well."));
        System.out.println(chkSentence("All-s well that ends well."));
//        System.out.println(Pattern.matches("meow$", "meow"));
    }

    public static String chkSentence(String input) {  // the ? is also not allowed before an s followed by whitespace or at the end of a line.
        if (Pattern.matches(".*-s\\s.*", input) || Pattern.matches(".*\\?$", input) || Pattern.matches(".*\\?s\\s.*", input) || Pattern.matches(".*,s\\s.*", input) || Pattern.matches(".*,$", input) || Pattern.matches(".*-$", input)) {
            return "Found bad sentence: ";
        } else {
            return "Found good sentence: ";
        }
    }
}
