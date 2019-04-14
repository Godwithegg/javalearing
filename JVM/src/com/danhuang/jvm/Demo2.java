package com.danhuang.jvm;

/**
 * 类加载机制（并不全都是，如tomcat是先加载自身，找不到才代理给父类代理器）
 * 双亲委托机制：
 * 	某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父类加载器，依次回溯，直到最高的爷爷辈，如果父类加载器可以完成类加载任务，就成功返回。
 * 	只有父类加载器无法完成此加载任务时，才自己去加载。
 * 目的：保证java核心库的类型安全。
 * @author danhuang
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());//引导类加载器，原生代码实现
		
		System.out.println(System.getProperty("java.class.path"));
		
		System.out.println("-------------------");
		String a = "dan";//这个和jdk的包名类名冲突了，但是由于双亲委托机制因此这种类不会被加载
		System.out.println(a.getClass().getClassLoader());
		System.out.println(a);
		
		
	}
}
