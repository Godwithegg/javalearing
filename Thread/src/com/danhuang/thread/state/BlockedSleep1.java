package com.danhuang.thread.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep模拟倒计时
 * 
 * @author danhuang
 *
 */
public class BlockedSleep1 {
	public static void main(String[] args) throws InterruptedException {
		//倒计时
		Date endTime = new Date(System.currentTimeMillis()+1000*10);
		long end = endTime.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			Thread.sleep(1000);
			endTime = new Date(endTime.getTime()-1000);
			if(end - 10000 > endTime.getTime()) {
				break;
			}
		}
		
	}

	public static void test(String[] args) throws InterruptedException {
		// 倒数10个数，1秒一个
		int num = 10;
		while (true) {
			Thread.sleep(1000);
			System.out.println(num--);
		}
	}
}
