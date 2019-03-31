package com.danhuang.thread.priority;

/**
 * 线程优先级 1.NORM_PRIORITY 5 默认 2.MIN_PRIORITY 1 3.MAX_PRIORITY 10
 * 	概率，不代表先后执行顺序
 * @author danhuang
 *
 */
public class Priority1 {
	public static void main(String[] args) {
		// System.out.println(Thread.currentThread().getPriority()); // 查看默认优先级
		MyPriority m = new MyPriority();
		Thread t1 = new Thread(m,"adidas");
		Thread t2 = new Thread(m,"NIKE");
		Thread t3 = new Thread(m,"回力");
		Thread t4 = new Thread(m,"李宁");
		Thread t5 = new Thread(m,"双星");
		Thread t6 = new Thread(m,"puma");

		// 设置优先级在启动前
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class MyPriority implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority()); // 查看自定义线程的优先级
		Thread.yield();
	}
}