package com.danhuang.juc;

/**
 * 生产者和消费者案例
 */
//public class TestProductorAndConsumer {
//
//    public static void main(String[] args) {
//        Clerk clerk = new Clerk();
//        Productor pro = new Productor(clerk);
//        Customer cus = new Customer(clerk);
//        new Thread(pro,"生产者A").start();
//        new Thread(cus,"消费者B").start();
//
//        new Thread(pro,"生产者C").start();
//        new Thread(cus,"消费者D").start();
//    }
//}
//
////店员
//class Clerk{
//    private int product = 0;
//
//    //进货
//    public synchronized void get(){//循环次数：2
//        while(product >= 1){//为了避免虚假唤醒问题，应该总是使用在循环中
//            System.out.println("产品已满！");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//            }
//        }
//        System.out.println(Thread.currentThread().getName()+":"+ ++product);
//        this.notifyAll();
//
//    }
//
//    //售货
//    public synchronized void sale(){//product = 0循环次数：1
//        while(product <= 0){
//            System.out.println("缺货！");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + ":" + --product);
//        this.notifyAll();
//
//    }
//}
//
////生产者
//class Productor implements Runnable{
//    private Clerk clerk;
//
//    public Productor(Clerk clerk){
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 20; i++) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//            }
//            clerk.get();
//        }
//    }
//}
//
////消费者
//class Customer implements Runnable{
//    private Clerk clerk;
//    public Customer(Clerk clerk){
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 20; i++) {
//            clerk.sale();
//        }
//    }
//}