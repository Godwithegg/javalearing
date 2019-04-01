package com.danhuang.thread.concurrent;

/**
 * 死锁
 * @author danhuang
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		Makeup makeup1 = new Makeup("小白", 0);
		Makeup makeup2 = new Makeup("小黑", 1);
		makeup1.start();
		makeup2.start();
	}
}

class Mirror {

}

class Lipstick {

}

class Makeup extends Thread {
	// 名字
	private String name;
	// 选择
	private int choice;
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();

	public Makeup(String name, int choice) {
		this.name = name;
		this.choice = choice;
	}

	@Override
	public void run() {
		// 化妆
		makeup();
	}

	// 相互持有对方的锁
	public void makeup() {
		if (choice == 0) {
			synchronized (lipstick) {
				System.out.println(this.name + "开始涂口红");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (mirror) {
					System.out.println(this.name + "开始照镜子");
				}
			}
		} else {
			synchronized (mirror) {
				System.out.println(this.name + "开始涂口红");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lipstick) {
					System.out.println(this.name + "开始照镜子");
				}
			}
		}
	}
}
