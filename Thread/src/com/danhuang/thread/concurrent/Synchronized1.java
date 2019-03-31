package com.danhuang.thread.concurrent;

/**
 * 线程安全，并发时保证数据的准确性，效率尽可能高 synchronized 1，同步方法 2，同步块
 * 
 * @author danhuang
 *
 */
public class Synchronized1 {
	public static void main(String[] args) {
		SafeWeb12306 web = new SafeWeb12306();
		new Thread(web, "马畜").start();
		new Thread(web, "码农").start();
		new Thread(web, "马币").start();
	}
}

class SafeWeb12306 implements Runnable {
	// 票数
	private int ticketNums = 99;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test();
		}
	}

	//线程安全 同步
	public synchronized void test() {
		if (ticketNums < 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
	}

}
