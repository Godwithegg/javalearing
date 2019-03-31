package com.danhuang.thread.concurrent;

/**
 * 线程安全：取钱
 * 
 * @author danhuang
 *
 */
public class Synchronized3 {
	public static void main(String[] args) {
		// 账户
		Account1 account = new Account1(100, "结婚礼金");
		Drawing1 you = new Drawing1(account, 80, "可悲的你");
		Drawing1 wife = new Drawing1(account, 90, "开心的她");
		you.start();
		wife.start();
	}
}

class Account1 {
	int money;// 金额
	String name;// 名称

	public Account1(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}

}

// 模拟取款
class Drawing1 extends Thread {

	Account1 account1;// 取钱的账户
	int drawingMoney;// 取钱数
	int packetTotal;// 取钱总数

	public Drawing1(Account1 account1, int drawingMoney, String name) {
		super(name);
		this.account1 = account1;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}

	public synchronized void test() {
		if (account1.money - drawingMoney < 0) {
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account1.money -= drawingMoney;
		packetTotal += drawingMoney;
		System.out.println(this.getName() + "-->账户余额为" + account1.money);
		System.out.println(this.getName() + "-->口袋剩余" + packetTotal);
	}
}