package com.danhuang.thread.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全：操作容器
 * 
 * @author danhuang
 *
 */
public class Synchronized2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		try {
			Thread.sleep(100);// 加延时是为了让线程执行完
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
	}
}