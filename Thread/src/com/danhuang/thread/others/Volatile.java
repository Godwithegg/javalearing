package com.danhuang.thread.others;

/**
 * Volatile用于保证数据的同步，也就是可见性
 * 
 * @author danhuang
 *
 */
public class Volatile {
	private volatile static int num = 0;

	public static void main(String[] args) {
		new Thread(() -> {
			while (num == 0) {// 此处不编写代码,不加volatile会死循环
			}
		}).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		num = 1;

	}
}
