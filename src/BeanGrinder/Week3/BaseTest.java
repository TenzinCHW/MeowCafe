package BeanGrinder.Week3;

import java.util.Arrays;

/**
 * Created by HanWei on 2/10/2016.
 */
public class BaseTest {
    public static void main(String[] args) {
//        String meow = "IOSJDAKLijsdfIWhello";
        String[] woof = {"hello", "world", "meow", "da"};
        String[] raar = {"abcdefghijklmnopqrstuvwxyz"};
//        System.out.println(WordFinder.getSubstrings(meow, woof));
//        int[] woof = {1,2,3,4,5};
//        System.out.println(Arrays.toString(BaseTranslator.convertBase(woof, 6, 8, 5)));
        System.out.println(Arrays.toString(AlphabetGenerator.generateFrequencyAlphabet(26, raar)));
    }
}
