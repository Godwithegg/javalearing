package com.danhuang.thread.others;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁： 锁可以延续使用+计数器
 * 
 * @author danhuang
 *
 */
public class JdkNoRepeatToRepeatLock {
	ReentrantLock lock = new ReentrantLock();	//可以直接使用，不需要自己写锁了，jdk自带的
	public void a() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		doSomething();
		lock.unlock();
	}
	//不可重入
	public void doSomething() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}
	public static void main(String[] args) throws InterruptedException {
		JdkNoRepeatToRepeatLock define = new JdkNoRepeatToRepeatLock();
		define.a();

		Thread.sleep(1000);
		System.out.println(define.lock.getHoldCount());
	}
}