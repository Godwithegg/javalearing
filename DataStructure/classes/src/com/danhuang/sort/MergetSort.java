package com.danhuang.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergetSort {
    public static void main(String[] args) {
        //int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 }; //

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        //System.out.println("归并排序后=" + Arrays.toString(arr));
    }

    //分+合的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间的索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //到合并
            merge(arr, left, mid, right, temp);

        }
    }

    //合并的方法

    /**
     * @param arr   需要排序的数组
     * @param left  左边有序的序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引

        //(1)
        //先把左右两边的数据按照规则填充到temp数据
        //直到左右两边的有序序列，有一边处理完毕
        while (i <= mid && j <= right) {//继续
            if (arr[i] <= arr[j]) {
                //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
                //即将左边的当前元素，拷贝到temp数组
                temp[t] = arr[i];
                t++;
                i++;
            } else {//反之将右边有序的当前元素，填充到temp数组
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //(2)
        //如果哪边有剩余，把剩余的数据依次填充到temp
        while (i <= mid) {//说明左边的序列还有剩余的元素，全部填充到temp
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {//说明右边的序列还有剩余的元素，全部填充到temp
            temp[t] = arr[j];
            t++;
            j++;
        }

        //(3)
        //将temp数组的元素拷贝到arr
        t = 0;
        int tempLeft = left;//
        while (tempLeft <= right) {//第一次合并tempLeft= 0,right=1
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

}
