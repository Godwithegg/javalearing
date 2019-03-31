package com.danhuang.thread.state;

/**
 * join:合并线程，插队线程
 * @author danhuang
 *
 */
public class BlockedJoin {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda..."+i);
			}
		});
		t.start();
		
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				t.join();	//插队，显然现在main被阻塞了
			}
			System.out.println("main end..."+i);
		}
	}
}
