package com.danhuang.thread.others;

/**
 * 每个线程自身的存储本地、局部区域
 * 每个线程自身的数据，更改不会影响其他线程
 * get/set/initialValue
 * @author danhuang
 *
 */
public class ThreadLocals {
	//private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	//更改初始值
//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
//		protected Integer initialValue() {
//			return 200;
//		};
//	};
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1 );
	public static void main(String[] args) {
		//获取值
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		//设置值
		threadLocal.set(99);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		
		new Thread(new MyRun()).start();
	}
	public static class MyRun implements Runnable{
		@Override
		public void run() {
			threadLocal.set((int)(Math.random()*99));
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}
	}
}
