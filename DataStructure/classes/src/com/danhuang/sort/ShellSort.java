package com.danhuang.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
        //int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

        // 创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //shellSort(arr); //交换式     //排序前的时间是=2019-08-12 16:00:12
                                      //排序前的时间是=2019-08-12 16:00:20
        shellSort2(arr);//移位方式

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        //System.out.println(Arrays.toString(arr));
    }

    // 使用逐步推导的方式来编写希尔排序
    // 希尔排序时， 对有序序列在插入时采用交换法,
    // 思路(算法) ===> 代码
    public static void shellSort(int[] arr) {

        int temp = 0;
        int count = 0;
        //根据前面的逐步分析，使用循环处理
        for(int gap = arr.length/2;gap > 0;gap /= 2){
            for(int i = gap; i < arr.length; i ++){
                for(int j=i-gap;j>=0;j-=gap){
                    if(arr[j]>arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序第"+(++count)+"轮="+Arrays.toString(arr));
        }

        /*
        //希尔排序的第一轮排序
        //因为第一轮排序，是将10个数据分成了5组
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有的元素（共有5组，每组有2个元素），步长5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 5]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序1轮后=" + Arrays.toString(arr));//

        //希尔排序的第2轮排序
        //因为第2轮排序，是将10个数据分成了5/2=2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有的元素（共有5组，每组有2个元素），步长2
            for (int j = i - 2; j >= 0; j -= 2) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 2]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序2轮后=" + Arrays.toString(arr));//

        //希尔排序的第3轮排序
        //因为第3轮排序，是将10个数据分成了5/2/2=1组
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有的元素（共有5组，每组有2个元素），步长1
            for (int j = i - 1; j >= 0; j -= 1) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序3轮后=" + Arrays.toString(arr));//
        */
    }

    //对交换式希尔排序进行优化 ->移位法
    public static void shellSort2(int[] arr){

        for(int gap = arr.length/2;gap > 0;gap /= 2){
            //从第gap个元素，逐个对其锁在的组进行直接插入排序
            for(int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if(arr[j] < arr[j-gap]){
                    while(j - gap>=0 && temp < arr[j-gap]){
                        //开始移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出while循环后就给temp找到了插入的位置
                    arr[j] = temp;
                }
            }
        }
    }
}
