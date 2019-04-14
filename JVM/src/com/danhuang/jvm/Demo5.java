package com.danhuang.jvm;

/**
 * 上下文类加载器的测试
 * 
 * @author danhuang
 *
 */
public class Demo5 {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = Demo5.class.getClassLoader();
		System.out.println(loader);

		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);

		Thread.currentThread()
				.setContextClassLoader(new FileSystemClassLoader("D:/github/javalearning/javalearing/JVM/"));
		System.out.println(Thread.currentThread().getContextClassLoader());

		Class<Demo1> c = (Class<Demo1>) Thread.currentThread().getContextClassLoader()
				.loadClass("com.danhuang.jvm.Demo1");
		System.out.println(c);
		System.out.println(c.getClassLoader());
	}
}
