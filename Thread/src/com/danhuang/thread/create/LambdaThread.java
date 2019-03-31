package com.danhuang.thread.create;

/**
 * Lambada表达式简化线程（用一次）的使用
 * 
 * @author danhuang
 *
 */
public class LambdaThread {
	public static void main(String[] args) {
		new Thread(()-> {
			System.out.println("一边听歌");
		}).start();
		
	}
}
