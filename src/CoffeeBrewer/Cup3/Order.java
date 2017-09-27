package CoffeeBrewer.Cup3;

/**
 * Created by HanWei on 24/11/2016.
 */
public class Order {
    public static void main(String[] args) {
        System.out.println(reverse("fish ate man"));
        String meow = "boo";
//        System.out.println(meow.substring(3));
    }

    public static String reverse(String str) {  // failed some test cases. Index out of bounds. HAHAHA
        String[] woof = str.split(" ");
        int size = woof.length;
        String[] reversed = new String[size];
        String[] temp = reverse1(woof, reversed, 0);
        String result = "";
        for (int i = 0; i < temp.length; i++){
            if (i == temp.length - 1){
                result += temp[i];
            }else {
                result += temp[i] + " ";
            }
        }
        return result;
    }

    public static String[] reverse1(String[] str, String[] reversed, int pos) {
        if (str.length == 1){
            reversed[pos] = str[0];
            return reversed;
        }else {
            reversed[pos] = str[str.length-1];
            String[] temp = new String[str.length-1];
            for (int i = 0; i < str.length - 1; i++) {
                temp[i] = str[i];
            }
            return reverse1(temp, reversed, pos+1);
        }
    }
}
