package com.danhuang.thread.create;

/**
 * 创建线程，方式二：
 * 实现runnable接口
 * 重写run
 * 推荐
 * 	避免单继承的局限性
 * 	方便共享资源
 * @author danhuang
 *
 */
public class StartThread2 implements Runnable{
	/**
	 * 线程入口点
	 */
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("一边听歌");
		}
	}
	public static void main(String[] args) {
		
	/*
  		//创建子类对象
		StartThread2 st = new StartThread2();
		//创建代理类对象
		Thread t = new Thread(st);
		//启动
		t.start();	//不保证立即运行，由cpu调用
		//st.run();//普通方法调用
 	*/
		//以上代码因为只用到了一次，因此建议使用匿名内部类
		new Thread(new StartThread2()).start();
		for(int i=0;i<20;i++) {
			System.out.println("一边coding");
		}
	}
}
