package com.danhuang.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
//        int arr[] = { 53, 3, 542, 748, 14, 214};

        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

//        System.out.println("基数排序后 " + Arrays.toString(arr));
    }

    //基数排序方法
    public static void radixSort(int[] arr){

        //根据前面的推导，得到最终基数排序代码
        //1.得到数组中最大数的位数
        int max = arr[0];//假设第一个数就是最大数
        for(int i=1;i<arr.length;i++)
            max=Math.max(max,arr[i] );
        //得到最大位数是几位数
        int maxLength = (max+"").length();

        //定义一个二维数组表示10个桶，每个桶就是一个一位数组
        //说明
        //1.二维数组包含10个一维数组
        //2.为了防止在放入数的时候，数据溢出，则每个一位数组（桶），大小定位arr.length
        //3.明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少数据，我们定义一个一维数组，来记录各个桶每次放入的 数据个数
        //可以这样理解
        //比如bucketElementCounts[0],记录的就是bucket[0]桶的放入数据的个数
        int[] bucketElementCounts = new int[10];

        for(int i=0,n=1;i<maxLength;i++,n*=10){
            //针对每个元素对应位进行排序处理，个位、十位、百位。。。
            for(int j=0;j<arr.length;j++){
                //取出每个元素的个位的值
                int digitOfElement = arr[j]/n%10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照桶的顺序放回原来的数组
            int index=0;
            //遍历每一个桶，并将桶中的数据放入到原数组
            for(int k=0;k<bucketElementCounts.length;k++){
                //如果桶中有数据，我们才放入到原数组
                if(bucketElementCounts[k]!=0){
                    //循环该桶
                    for(int l=0;l<bucketElementCounts[k];l++){
                        //取出元素放入到arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第一轮处理后需要把每个bucketElementCounts[k]=0
                bucketElementCounts[k] = 0;
            }
        }


        /*
        //第一轮（针对每个元素的个位进行排序）
        for(int j=0;j<arr.length;j++){
            //取出每个元素的个位的值
            int digitOfElement = arr[j]%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照桶的顺序放回原来的数组
        int index=0;
        //遍历每一个桶，并将桶中的数据放入到原数组
        for(int k=0;k<bucketElementCounts.length;k++){
            //如果桶中有数据，我们才放入到原数组
            if(bucketElementCounts[k]!=0){
                //循环该桶
                for(int l=0;l<bucketElementCounts[k];l++){
                    //取出元素放入到arr
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //第一轮处理后需要把每个bucketElementCounts[k]=0
            bucketElementCounts[k] = 0;
        }

        System.out.println("第一轮，对个位的排序处理，arr="+ Arrays.toString(arr));


        //第2轮（针对每个元素的十位进行排序）
        for(int j=0;j<arr.length;j++){
            //取出每个元素的十位的值
            int digitOfElement = arr[j]/10%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照桶的顺序放回原来的数组
        index=0;
        //遍历每一个桶，并将桶中的数据放入到原数组
        for(int k=0;k<bucketElementCounts.length;k++){
            //如果桶中有数据，我们才放入到原数组
            if(bucketElementCounts[k]!=0){
                //循环该桶
                for(int l=0;l<bucketElementCounts[k];l++){
                    //取出元素放入到arr
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //第2轮处理后需要把每个bucketElementCounts[k]=0
            bucketElementCounts[k] = 0;
        }

        System.out.println("第2轮，对个位的排序处理，arr="+ Arrays.toString(arr));

        //第3轮（针对每个元素的百位进行排序）
        for(int j=0;j<arr.length;j++){
            //取出每个元素的百位的值
            int digitOfElement = arr[j]/100%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照桶的顺序放回原来的数组
        index=0;
        //遍历每一个桶，并将桶中的数据放入到原数组
        for(int k=0;k<bucketElementCounts.length;k++){
            //如果桶中有数据，我们才放入到原数组
            if(bucketElementCounts[k]!=0){
                //循环该桶
                for(int l=0;l<bucketElementCounts[k];l++){
                    //取出元素放入到arr
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
        }

        System.out.println("第3轮，对个位的排序处理，arr="+ Arrays.toString(arr));
        */
    }
}
