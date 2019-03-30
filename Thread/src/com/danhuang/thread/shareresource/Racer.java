package com.danhuang.thread.shareresource;

/**
 * 模拟龟兔赛跑
 * 
 * @author danhuang
 *
 */
public class Racer implements Runnable {
	
	private String winner;//胜利者
	@Override
	public void run() {
		for (int steps = 1; steps <= 100; steps++) {
			//模拟休息
			if(Thread.currentThread().getName().equals("rabbit")&&steps%10 == 0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"-->"+steps);
			//比赛是否结束
			boolean flag = gameOver(steps);
			if(flag) {
				break;
			}
		}
	}
	private boolean gameOver(int steps) {
		if(winner != null) {//存在胜利者了
			return true;
		}else {
			if(steps == 100) {
				winner = Thread.currentThread().getName();
				System.out.println("winner is "+winner);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Racer racer = new Racer();
		new Thread(racer,"tortoise").start();
		new Thread(racer,"rabbit").start();
	}
	
}
