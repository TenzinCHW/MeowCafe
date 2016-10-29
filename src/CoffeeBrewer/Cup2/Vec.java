package CoffeeBrewer.Cup2;


// Disclaimer: I got one test case wrong.
/**
 * Created by HanWei on 20/10/2016.
 */
public class Vec implements Comparable<Vec>{
    private double x;
    private double y;
    private double L1;

    public Vec(){
        this(0,0);
    }

    public Vec(double ex, double why){
        x = ex;
        y = why;
        L1 = Math.abs(x) + Math.abs(y);
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }

    @Override
    public int compareTo(Vec rawr){
        if (this.L1 == rawr.L1){
            return 0;
        }else if(this.L1 < rawr.L1){
            return -1;
        }else {
            return 1;
        }
    }

}
