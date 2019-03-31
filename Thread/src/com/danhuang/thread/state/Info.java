package com.danhuang.thread.state;

/**
 * 其他方法
 * isAlive：是否或者
 * Thread.currentThread()当前线程
 * setName,getName:代理名称
 * 
 * @author danhuang
 *
 */
public class Info {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().isAlive());

		// 设置名字：真实角色+代理角色
		MyInfo info = new MyInfo("战斗机");
		Thread t = new Thread(info);
		t.setName("公鸡");
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.isAlive());
	}
}

class MyInfo implements Runnable {
	private String name;

	public MyInfo(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+name);
	}
}