package com.danhuang;

import java.util.*;

public class Solution {

    int[] array=new int[99];
    List<String> list = null;
    String s8 = null;
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n;
        Solution result = new Solution();
        result.list = new ArrayList<>();
        result.check(1);
        while(in.hasNext()){
            n = in.nextInt();
            System.out.println(result.list.get(n-1));

        }

    }

    public void check(int n){
        if(n==9){
            s8 = "";
            for (int i = 1; i <= 8 ; i++) {
                s8=s8+array[i];
            }
            list.add(s8);
            return;
        }
        for(int i=1;i<=8;i++){

            array[n]=i;

            if(judge(n)){
                check(n+1);
            }
        }

    }

    public  boolean judge(int n){
        for(int i=1;i<n;i++){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

}