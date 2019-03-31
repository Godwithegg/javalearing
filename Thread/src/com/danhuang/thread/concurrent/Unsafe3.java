package com.danhuang.thread.concurrent;

/**
 * 线程不安全：取钱
 * 
 * @author danhuang
 *
 */
public class Unsafe3 {
	public static void main(String[] args) {
		// 账户
		Account account = new Account(100, "结婚礼金");
		Drawing you = new Drawing(account, 80, "可悲的你");
		Drawing wife = new Drawing(account, 90, "开心的她");
		you.start();
		wife.start();
	}
}

class Account {
	int money;// 金额
	String name;// 名称

	public Account(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}

}

// 模拟取款
class Drawing extends Thread {

	Account account;// 取钱的账户
	int drawingMoney;// 取钱数
	int packetTotal;// 取钱总数

	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		if (account.money - drawingMoney < 0) {
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.money -= drawingMoney;
		packetTotal += drawingMoney;
		System.out.println(this.getName() + "-->账户余额为" + account.money);
		System.out.println(this.getName() + "-->口袋剩余" + packetTotal);
	}
}