package com.danhuang.thread.others;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度： Timer和TimerTask类
 * 
 * @author danhuang
 *
 */
public class MyTimer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//执行安排
		
		timer.schedule(new MyTask(), 1000);	//执行一次
		timer.schedule(new MyTask(), 1000,200);	//每个200毫秒执行一次
		Calendar calendar = new GregorianCalendar(2099,12,21,23,23,23);
		timer.schedule(new MyTask(),calendar.getTime(),200);//指定时间后开始，每隔200毫秒执行一次
	}
}

class MyTask extends TimerTask {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("休息一下");
		}
		System.out.println("end");
	}
}