package com.danhuang.juc;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class TestForkJoinPool {
    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L,100000000L);
        Long sum = pool.invoke(task);
        Instant end = Instant.now();
        System.out.println("耗费时间为:"+ Duration.between(start,end).toMillis());
        System.out.println(sum);

//        test1();
    }


    public static void test1(){
        Instant start = Instant.now();
        long sum = 0L;
        for(long i = 0L;i<=100000000L;i++){
            sum += i;
        }
        Instant end = Instant.now();
        System.out.println("耗费时间为:"+ Duration.between(start,end).toMillis());
        System.out.println(sum);
    }

    //java8 新特性
    public void test2(){
        Instant start = Instant.now();

        Long sum = LongStream.rangeClosed(0L, 50000000000L)
                .parallel()
                .reduce(0L, Long::sum);

        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());//1536-8118
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = -259195479995561737L;

    private long start;
    private long end;

    private static final long THURSHOLD = 0L;//临界值
    public ForkJoinSumCalculate(long start ,long end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= THURSHOLD){
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += start;
            }
            return sum;
        }else{
            long middle = (start + end) /2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start,middle);
            left.fork();//进行拆分同时压入线程队列

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle+1,end);
            right.fork();

            return left.join()+right.join();
        }
    }
}
