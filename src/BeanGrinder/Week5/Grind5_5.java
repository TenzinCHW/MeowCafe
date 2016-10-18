package BeanGrinder.Week5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by HanWei on 17/10/2016.
 */
public class Grind5_5 {
    public static void main(String[] args) {
        System.out.println(returnWords("left", "this stressful time on the twelfth felt strangely uneventful"));
    }

    public static ArrayList<String> returnWords(String word, String sentence){
        String[] wordsInSent = sentence.split("\\s");
        ArrayList<String> wordsFound = new ArrayList<String>();

        findWords(word, wordsInSent, wordsFound);
        return wordsFound;
    }

    public static void findWords(String word, String[] allWords, ArrayList<String> found){
        if (allWords.length == 1 && wordMatch(word, allWords[0])){
                found.add(allWords[0]);
                return;
        }else{
            if (wordMatch(word, allWords[0])) {
                found.add(allWords[0]);
            }
            findWords(word, Arrays.copyOfRange(allWords, 1, allWords.length), found);
        }
    }

    public static boolean wordMatch(String in1, String in2) {
        int grr = 0;
        for (int i = 0; i < in1.length(); i++) {
            if (in2.contains(in1.substring(i, i+1))){
                grr += 1;
            }
        }
        return grr == in1.length();
    }
}
