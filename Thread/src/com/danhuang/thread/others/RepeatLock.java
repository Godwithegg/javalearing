package com.danhuang.thread.others;

/**
 * 可重入锁： 锁可以延续使用
 * 
 * @author danhuang
 *
 */
public class RepeatLock {
	public void test() {
		// 第一次获得锁
		synchronized (this) {
			while (true) {
				// 第二次获得同样的锁
				synchronized (this) {
					System.out.println("ReentrantLock!");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new RepeatLock().test();
	}
}
