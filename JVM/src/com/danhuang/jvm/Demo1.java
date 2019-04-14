package com.danhuang.jvm;

/**
 * 类加载过程:父类的初始化块->当前类的初始化块->类的方法
 * 方法区：
 * 	1、静态变量
 * 	2、静态方法
 * 	3、常量池
 * 		Demo1，...
 * 	4、类的代码
 * 堆：
 * 	1、java.lang.Class对象
 * 	2、代表Demo1类
 * 	
 * @author danhuang
 *
 */
public class Demo1 {
	static {
		System.out.println("静态初始化Demo1");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Demo1的main方法");
		
		/**
		 * 主动引用，发生初始化
		 * 1、new 一个类对象时
		 * 2、调用类的静态成员（除了final常量）和静态方法
		 * 3、使用反射对类进行反射调用
		 * 4、当虚拟机启动，java Demo1，则一定会初始化Demo1类，说白了就是启动main方法所在的类
		 * 5、当初始化一个类，如果其父亲没有被初始化，则会先初始化他的父类
		 */
//		A a = new A();
//		System.out.println(a.width);
//		A a2 = new A();//静态初始化块只加载了一次
//		Class.forName("com.danhuang.jvm.A");
		
		/**
		 * 类的被动引用，不会发生类的初始化
		 * 1、当访问一个静态域时，只有真正声明这个域的类才会被初始化
		 * 		通过子类引用父类的静态变量，不会导致子类初始化
		 * 2、通过数组定义类引用，不会触发此类的初始化
		 * 3、引用常量不会触发此类的初始化（常量在编译阶段就存入类的常量池中了）
		 */
//		System.out.println(A.MAX);
//		A[] as = new A[10];
		System.out.println(B.width);
	}
}

class A extends A_Father{
	public static int width = 100;	//静态变量，静态域 field
	public static final int MAX = 100;
	static {
		System.out.println("静态初始化类A");
		width = 300;
	}

	public A() {
		System.out.println("创建A的对象");
	}
}

class A_Father{
	static {
		System.out.println("静态初始化A_Father");
	}
}

class B extends A{
	static {
		System.out.println("静态初始化B");
	}
}