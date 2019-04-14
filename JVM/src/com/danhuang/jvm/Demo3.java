package com.danhuang.jvm;

/**
 * 测试自定义的FileSystemClassLoader
 * 被两个类加载器加载的同一个类，JVM不认为是相同的类
 * @author danhuang
 *
 */
public class Demo3 {
	public static void main(String[] args) throws Exception {
		FileSystemClassLoader loader = new FileSystemClassLoader("D:/github/javalearning/javalearing/JVM/");
		FileSystemClassLoader loader2 = new FileSystemClassLoader("D:/github/javalearning/javalearing/JVM/");

		Class<?> c1 = loader.loadClass("TestClass");
		Class<?> c2 = loader.loadClass("TestClass");
		Class<?> c3 = loader2.loadClass("TestClass");
		Class<?> c4 = loader2.loadClass("java.lang.String");
		Class<?> c5 = loader.loadClass("com.danhuang.jvm.Demo2");
		Class<?> c6 = loader2.loadClass("com.danhuang.jvm.Demo2");
		
		System.out.println(c1);
		
		System.out.println(c1.hashCode() == c2.hashCode());
		System.out.println(c1.hashCode() == c3.hashCode());//被两个类加载器加载的同一个类，JVM不认为是相同的类。如果这个类.class在classpath下，那么是同一个类
		System.out.println(c5.hashCode() == c6.hashCode());//由于与类加载器在同一个classpath下，所以是同一个类
		
		System.out.println(c3.getClassLoader());//自定义类加载器
		System.out.println(c4.getClassLoader());//引导类加载器
	}
}
