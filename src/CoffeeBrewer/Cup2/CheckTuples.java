package CoffeeBrewer.Cup2;

import java.util.regex.Pattern;


//Disclaimer: I got one test case wrong.
/**
 * Created by HanWei on 20/10/2016.
 */
public class CheckTuples {
    public static String checkTuples (String input) {
        if (Pattern.matches("([A-Z][a-z]{1,14}) ([a-zA-Z]\\. )?([A-Z][a-z]{1,14})", input)){
            return "Name tuple";
        }else if(Pattern.matches("(Wheat|Oil|Sugar) (\\d\\d) (kgs|litres) (\\d\\d\\.\\d\\d)", input)){
            return "Commodity tuple";
        }else{
            return "Error tuple";
        }
    }
}
