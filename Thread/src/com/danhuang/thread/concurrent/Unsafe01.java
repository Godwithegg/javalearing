package com.danhuang.thread.concurrent;

/**
 * 线程不安全
 * 数据有负数
 * 数据有重复
 * @author danhuang
 *
 */
public class Unsafe01 implements Runnable {
	// 票数
	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (true) {
			test();
		}
	}

	public void test() {
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

	public static void main(String[] args) {
		// 一份资源
		Unsafe01 web = new Unsafe01();
		// 多个代理
		new Thread(web, "马畜").start();
		new Thread(web, "码农").start();
		new Thread(web, "马币").start();

	}
}
