package BeanGrinder.Week4;

import java.util.*;    // Unused import o_o
/**
 * Created by HanWei on 9/10/2016.
 */
public class Grind4_3 {
//public class CatchingExceptionsv4 {

    public static void main(String[] args) throws Throwable {
        try {
            method1();
            System.out.println("Statement1");
        }
        catch (NullPointerException ex) {
            System.out.println(ex);
        }
        System.out.println("Statement2");
    }
    public static void method1() throws Exception {
        try {
            method2();
            System.out.println("Statement3");
        }
        catch (IllegalArgumentException woof) {
            System.out.println(woof);
        }
        System.out.println("Statement4");
    }
    public static void method2() throws Exception {
        try {
            method3();
            System.out.println("Statement5");
        }
        catch (IllegalArgumentException meow) {
            throw meow;
        }
        System.out.println("Statement6");
    }
    public static void method3() throws Exception {
        throw new IllegalArgumentException("Info from method2");
    }

}
