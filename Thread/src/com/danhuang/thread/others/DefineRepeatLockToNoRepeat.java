package com.danhuang.thread.others;

/**
 * 不可重入锁： 锁不可以延续使用,因此会造成死循环
 * 
 * @author danhuang
 *
 */
public class DefineRepeatLockToNoRepeat {
	Lock lock = new Lock();
	public void a() throws InterruptedException {
		lock.lock();
		doSomething();
		lock.unlock();
	}
	//不可重入
	public void doSomething() throws InterruptedException {
		lock.lock();
		//...
		lock.unlock();
	}
	public static void main(String[] args) throws InterruptedException {
		DefineRepeatLockToNoRepeat define = new DefineRepeatLockToNoRepeat();
		define.a();
		define.doSomething();
	}
}

class Lock{
	//是否占用
	private boolean isLocked = false;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {
			wait();
		}
		isLocked = true;
	}
	//释放锁
	public synchronized void unlock() {
		isLocked = false;
		notifyAll();
	}
}