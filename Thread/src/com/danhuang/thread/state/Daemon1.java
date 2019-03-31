package com.danhuang.thread.state;

/**
 * 守护线程：是为用户线程服务的；jvm停止不用等待守护线程执行完毕 默认：用户线程 jvm需要等待所有的用户线程执行完毕才会停止
 * 
 * @author danhuang
 *
 */
public class Daemon1 {
	public static void main(String[] args) {
		God god = new God();
		You you = new You();
		Thread t1 = new Thread(god);
		t1.setDaemon(true);// 将用户线程调整为守护线程
		t1.start();
		Thread t2 = new Thread(you);
		t2.start();
	}
}

class You implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 365 * 100; i++) {
			System.out.println("happe life...");
		}
		System.out.println("ooooo...");
	}
}

class God implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println("bless you...");
		}
	}
}