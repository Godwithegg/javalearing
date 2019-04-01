package com.danhuang.thread.concurrent;

import java.util.ArrayList;
import java.util.List;

public class Synchronized4 {
	public static void main(String[] args) {
		List<Integer> cinemaList = new ArrayList<>();
		cinemaList.add(1);
		cinemaList.add(2);
		cinemaList.add(3);
		cinemaList.add(4);
		cinemaList.add(5);
		Cinema cinema = new Cinema("迪斯尼", cinemaList);

		List<Integer> t1List = new ArrayList<>();
		t1List.add(2);
		t1List.add(3);
		Thread t1 = new Thread(new Customer(cinema,t1List), "蛋黄");
		
		List<Integer> t2List = new ArrayList<>();
		t2List.add(4);
		Thread t2 = new Thread(new Customer(cinema,t2List), "蛋白");
		t1.start();
		t2.start();
	}
}

class Cinema {
	private List<Integer> ticket;
	private String name;

	public Cinema(String name, List<Integer> ticket) {
		this.name = name;
		this.ticket = ticket;
	}

	public List<Integer> getTicket() {
		return this.ticket;
	}

	public boolean bookTikcet(List<Integer> seats) {
		List<Integer> copy = new ArrayList<>();
		copy.addAll(this.ticket);
		copy.removeAll(seats);
		if (copy.size() + seats.size() == this.ticket.size()) {
			this.ticket = copy;
			System.out.println(Thread.currentThread().getName()+"出票成功");
			return true;
		} else {
			System.out.println(Thread.currentThread().getName()+"出票失败");
			return false;
		}

	}
}

class Customer implements Runnable {
	private List<Integer> seats;
	private Cinema cinema;

	public Customer(Cinema cinema, List<Integer> seats) {
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		synchronized (cinema) {
			boolean flag = cinema.bookTikcet(seats);
			if (flag) {
				System.out
						.println(Thread.currentThread().getName() + "已经订购到了几个位置" + seats + "剩余票数" + cinema.getTicket());
				return;
			} else {
				System.out.println(Thread.currentThread().getName() + "订购失败");
			}
		}
	}
}
