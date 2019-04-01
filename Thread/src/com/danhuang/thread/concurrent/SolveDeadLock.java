package com.danhuang.thread.concurrent;

/**
 * 解决死锁： 问题:过多的同步可能造成互相不释放资源 从而相互等待，一般发生于同步中持有多个对象的锁 
 * 避免：不要在同一个代码块中，同时持有多个对象的锁
 * 
 * @author danhuang
 *
 */
public class SolveDeadLock {
	public static void main(String[] args) {
		Makeup1 makeup1 = new Makeup1("小白", 0);
		Makeup1 makeup2 = new Makeup1("小黑", 1);
		makeup1.start();
		makeup2.start();
	}
}

class Makeup1 extends Thread {
	// 名字
	private String name;
	// 选择
	private int choice;
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();

	public Makeup1(String name, int choice) {
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

			}
			synchronized (mirror) {
				System.out.println(this.name + "开始照镜子");
			}
		} else {
			synchronized (mirror) {
				System.out.println(this.name + "开始涂口红");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			synchronized (lipstick) {
				System.out.println(this.name + "开始照镜子");
			}
		}
	}
}
