package com.danhuang.thread.create;

/**
 * 简化多线程
 * 
 * @author danhuang
 *
 */
public class Lambda_class3 {
	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("一边学习lambda");
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("一边听音乐");
			}
		}).start();

	}
}
