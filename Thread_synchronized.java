package cn.itcast.mytest;

import java.util.HashSet;
import java.util.Set;

public class sercert
{
	final static Thread1 threadTest = new Thread1();
	public static void main(String[] args)
	{
		Thread thread1 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				threadTest.print();
			}
		});
		 	
		Thread thread2 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				threadTest.printt();
			}
		});
		thread1.start();
		thread2.start();
	}
	
	
}
class Thread1
{
	static int total = 0;
	public synchronized void printt()
	{
		for(int i = 0; i <= 10; i ++)
		{
			System.out.print((total++)+" ");
		}
	}
	public synchronized void print()
	{
		for(int i = 0; i <= 10; i ++)
		{
			System.out.print((total++)+" ");
		}
	}
}
