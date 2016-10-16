package BeanGrinder.Week5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by HanWei on 16/10/2016.
 */
public class Grind5_3 {
    public static String chkData (String inp) {
        Pattern data = Pattern.compile(".* (SpO2|HR|Resp)$");
        Matcher matchdata = data.matcher(inp);
        if (matchdata.find()){
            return "No Error";
        }else{
            return "Error";
        }
    }
}
