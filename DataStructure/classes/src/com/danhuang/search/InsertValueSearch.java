package com.danhuang.search;

import java.util.Arrays;

public class InsertValueSearch {

    //int mid = left + (right-left)*(findValue - arr[left])/(arr[right]-arr[left]);差值查找算法核心
    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i=0;i<100;i++){
            arr[i] = i+1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 34);
//        System.out.println(Arrays.toString(arr));
        System.out.println(index);
    }

    //编写插值查找算法
    //说明：插值查找算法，也要求数组是有序的
    /**
     *
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findValue 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     *
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findValue){
        if(left > right || findValue < arr[0] || findValue > arr[arr.length-1]){
            return -1;
        }

        //求出mid
        int mid = left + (right-left)*(findValue - arr[left])/(arr[right]-arr[left]);
        if(findValue > arr[mid]){
            return insertValueSearch(arr, mid+1, right, findValue);
        }else if(findValue < arr[mid]){
            return insertValueSearch(arr, left, mid-1, findValue);
        }else{
            return mid;
        }

    }
}
