package com.danhuang.thread.concurrent;

/**
 * 线程安全，同步快，目标更明确
 * 
 * @author danhuang
 *
 */
public class Synchronized3 {
	public static void main(String[] args) {
		// 账户
		Account2 account = new Account2(200, "结婚礼金");
		Drawing2 you = new Drawing2(account, 80, "可悲的你");
		Drawing2 wife = new Drawing2(account, 90, "开心的她");
		you.start();
		wife.start();
	}
}

class Account2 {
	int money;// 金额
	String name;// 名称

	public Account2(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}

}

// 模拟取款
class Drawing2 extends Thread {

	Account2 account2;// 取钱的账户
	int drawingMoney;// 取钱数
	int packetTotal;// 取钱总数

	public Drawing2(Account2 account2, int drawingMoney, String name) {
		super(name);
		this.account2 = account2;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}

	public void test() {
		//这里做这个处理可以免去没有金额时还要询问对象
		if(account2.money <= 0) {
			return ;
		}
		//同步块
		synchronized (account2) {
			if (account2.money - drawingMoney < 0) {
				return;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account2.money -= drawingMoney;
			packetTotal += drawingMoney;
			System.out.println(this.getName() + "-->账户余额为" + account2.money);
			System.out.println(this.getName() + "-->口袋剩余" + packetTotal);
		}
	}
}