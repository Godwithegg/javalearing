package com.danhuang.thread.cooperation;

/**
 * 协作模型：
 * 	生产者消费者实现方式一：管程法
 * 	借助缓冲区
 * @author danhuang
 *
 */
public class Tube {
	public static void main(String[] args) {
		SynContainer synContainer = new SynContainer();
		Customer customer = new Customer(synContainer);
		Productor productor = new Productor(synContainer);
		customer.start();
		productor.start();
	}
}

// 生产者
class Productor extends Thread {
	private SynContainer synContainer;

	public Productor(SynContainer synContainer) {
		this.synContainer = synContainer;
	}

	@Override
	public void run() {
		// 生产
		for (int i = 1; i <= 30; i++) {
			System.out.println("生产第-->" + i + "个馒头");
			synContainer.push(new Steamedbun(i));
		}
	}
}

// 消费者
class Customer extends Thread {
	private SynContainer synContainer;

	public Customer(SynContainer synContainer) {
		this.synContainer = synContainer;
	}

	@Override
	public void run() {
		// 消费
		for (int i = 1; i <= 30; i++) {
			System.out.println("吃掉-->" + synContainer.pop().id + "个馒头");

		}
	}
}

// 缓冲区
class SynContainer {
	Steamedbun[] buns = new Steamedbun[10];// 存储数据的容器
	int count = 0;// 计数器
	// 存储 生产

	public synchronized void push(Steamedbun bun) {
		// 何时能生产：容器存在空间
		// 不能生产
		if (count == buns.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 存在空间，可以生产
		buns[count] = bun;
		count++;
		// 存在数据 可以通知消费了
		this.notifyAll();
	}

	// 获取
	public synchronized Steamedbun pop() {
		// 何时消费 容器中是否存在数据
		// 如果没有数据 只有等待
		if (count == 0) {
			try {
				this.wait(); // 线程阻塞 消费者通知生产 解除
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 存在数据 可以消费
		count--;
		Steamedbun bun = buns[count];
		this.notifyAll();// 存在空间，可以唤醒对方生产
		return bun;
	}
}

// 馒头
class Steamedbun {
	int id;

	public Steamedbun(int id) {
		super();
		this.id = id;
	}

}
