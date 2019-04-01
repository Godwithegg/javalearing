package com.danhuang.thread.others;

/**
 * 可重入锁： 锁可以延续使用+计数器
 * 
 * @author danhuang
 *
 */
public class DefineNoRepeatToRepeatLock {
	ReLock lock = new ReLock();
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
		DefineNoRepeatToRepeatLock define = new DefineNoRepeatToRepeatLock();
		define.a();

		Thread.sleep(1000);
		System.out.println(define.lock.getHoldCount());
	}
}

class ReLock{
	//是否占用
	private boolean isLocked = false;
	private Thread lockedBy = null;//存储线程
	private int holdCount = 0;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		Thread t = Thread.currentThread();
		while(isLocked && lockedBy != t) {
			wait();
		}
		isLocked = true;
		lockedBy = t;
		holdCount ++;
	}
	public int getHoldCount() {
		return holdCount;
	}
	public void setHoldCount(int holdCount) {
		this.holdCount = holdCount;
	}
	//释放锁
	public synchronized void unlock() {
		if(Thread.currentThread() == lockedBy) {
			holdCount --;
			if(holdCount == 0) {
				isLocked = false;
				notifyAll();
				lockedBy = null;
			}
		}
		
	}
}