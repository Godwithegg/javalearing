package com.danhuang.thread.state;

import java.lang.Thread.State;

/**
 * 观察线程的状态
 * 
 * @author danhuang
 *
 */
public class AllState {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("...");
			}
		});
		// 观察状态
		State state = t.getState();
		System.out.println(state);// new状态

		t.start();
		state = t.getState();
		System.out.println(state);// runnable

		while (state != Thread.State.TERMINATED) {
			//活动的天数
			//int num = Thread.activeCount();
			//if(num == 1)break;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			state = t.getState(); // TIMED_WAITING
			System.out.println(state);
		}
		state = t.getState(); // terminated
		System.out.println(state);
	}
}
