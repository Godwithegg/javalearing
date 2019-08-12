package com.danhuang.recursion;

public class RecursionTest {

    public static void main(String[] args) {
//        test(4);
        System.out.println("res=" + factorial(2));
    }

    //打印问题
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }//else{
        System.out.println("n=" + n);
        //}
    }

    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1);//factorial(1)*2
        }
    }
}
