package com.danhuang;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int temp[]=new int[arr.length];
        sort(arr,0 , arr.length-1, temp);
        for(int i:arr) System.out.printf("%d ",i);
    }

    public static void sort(int[] arr,int left,int right,int[] temp){
        int mid=(left+right)/2;
        if(left<right){
            sort(arr,left ,mid ,temp);
            sort(arr,mid+1 ,right,temp );
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            }else{
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        while(i<=mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while(j<=right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        t=0;
        while(left<=right){
            arr[left]=temp[t];
            left++;
            t++;
        }
    }
}