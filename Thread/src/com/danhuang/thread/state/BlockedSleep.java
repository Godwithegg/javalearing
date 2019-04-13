package com.danhuang.thread.state;

import com.danhuang.thread.shareresource.Web12306;

/**
 * sleep模拟网络延时，放大了发生问题的可能性 
 * @author danhuang
 *
 */
public class BlockedSleep implements Runnable{
	// 票数
	private int ticketNums = 99;

	@Override
	public void run() {
		while (true) {
			if (ticketNums < 0) {
				break;
			}
			//模拟延时
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
		}
	}

	public static void main(String[] args) {
		// 一份资源
		Web12306 web = new Web12306();
		// 多个代理
		new Thread(web, "马畜").start();
		new Thread(web, "码农").start();
		new Thread(web, "马币").start();

	}
}
