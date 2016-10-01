package CoffeeBrewer.Cup1;

import java.util.Arrays;

/**
 * Created by HanWei on 27/9/2016.
 */
public class Cup1_3 {
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int indA = m - 1;
        int indB = n - 1;
        for (int i = m + n - 1; i > -1; i--) {
            if (indA < 0) {
                for (int j = indB - 1; j > 0; j++) {
                    A[i] = B[indB];
                }
            } else if (indB < 0) {
                break;
            }
            if (A[indA] > B[indB]) {
                A[i] = A[indA];
                indA -= 1;
            } else {
                A[i] = B[indB];
                indB -= 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[8];
        int[] B = {3, 6, 9};
        A[0] = 1;
        A[1] = 5;
        A[2] = 7;
        A[3] = 10;
        A[4] = 13;
        mergeSortedArray(A, 5, B, 3);
        System.out.println(Arrays.toString(A));
    }
}
