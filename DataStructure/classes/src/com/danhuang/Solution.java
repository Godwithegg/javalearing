package com.danhuang;
import com.danhuang.sort.QuickSort;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr=new int[10000];
        for(int i=0;i<10000;i++){
            arr[i]= (int) (Math.random()*10000);
        }
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int key = arr[left];
        while(l<r){
            while(arr[l] < key)l++;
            while(arr[r] > key)r--;
            if(l>=r)break;
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if(arr[l]==key)r--;
            if(arr[r]==key)l++;
        }
        if(left<r)sort(arr, left, r-1);
        if(l<right)sort(arr, l+1, right);
    }
}