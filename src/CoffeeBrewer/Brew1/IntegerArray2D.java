package CoffeeBrewer.Brew1;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * Created by HanWei on 29/9/2016.
 */
public class IntegerArray2D {
    int[][] array;
    IntegerArray2D(int[][] x){
        this.array = x;
    }

    @Override
    public String toString(){
        String val= "";
        for (int i = 0; i < array.length; i++) {
            val += "row " + array[i] + ":";
            for (int j = 0; j < array[i].length; j++) {
                val += array[i][j]+",";
            }
            val+="\n";
        }
        return val;
    }

    public double[] avgRow(){
        int total;
        double count;
        double[] avgrow = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            total = 0;
            count = 0;
            for (int j = 0; j < array[i].length; j++) {
                total+=array[i][j];
                count+=1.0;
            }
            avgrow[i]=total/count;
        }
        return avgrow;
    }

    public double[] avgCol(){
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array[i].length; j++) {
                count += 1;
            }
            if (count>max){
                max = count;
            }
        }

        double[][] avg = new double[max][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                avg[j][i] = array[i][j];
            }
        }
        int total;
        double count;
        double[] avgcol = new double[max];
        for (int i = 0; i < avg.length; i++) {
            total = 0;
            count = 0;
            for (int j = 0; j < avg[i].length; j++) {
                total += avg[i][j];
                count += 1.0;
            }
            avgcol[i] = total/count;
        }
        return avgcol;
    }
}
