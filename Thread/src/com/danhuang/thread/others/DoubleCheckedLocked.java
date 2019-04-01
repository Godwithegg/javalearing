package com.danhuang.thread.others;

/**
 * 单例模式：懒汉式套路基础上加入并发控制，在并发环境下，对外存在一个对象
 * 1、构造器私有化-->避免外部new构造器
 * 2、提供私有的静态属性-->存储对象的地址
 * 3、提供公共的静态方法-->获取属性
 * @author danhuang
 *
 */
public class DoubleCheckedLocked { 
	//2.提供私有的静态属性
	private static volatile DoubleCheckedLocked instance;
	//没有volatile其他线程可能访问一个没有初始化的对象
	private DoubleCheckedLocked() {		
		
	}
	public static DoubleCheckedLocked getInstance() {
		//再次检测
		if(instance != null) {//避免不必要的同步，已经存在对象
			return instance;
		}
		synchronized(DoubleCheckedLocked.class) {
			if(instance == null) {
				instance = new DoubleCheckedLocked();
				//1.开辟空间
				//2.初始化对象信息
				//3.返回对象地址给引用
			}	
		}
		
		return instance;
	}
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			System.out.println(DoubleCheckedLocked.getInstance());
		});
		t.start();
	}
}
