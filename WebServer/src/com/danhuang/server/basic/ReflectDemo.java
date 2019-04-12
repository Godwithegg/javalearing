package com.danhuang.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射 1、获取Class对象 三种方式：Class.forName("完整路径") 
 * 2、可以动态创建对象
 * clz.getConstructor.newInstance()
 * @author danhuang
 *
 */
public class ReflectDemo {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// 三种方式
		// 1、对象.getClass()
		Class clz = new Iphone().getClass();
		// 2、类.class()
		clz = Iphone.class;
		// 3、Class.forName("包名.类名")
		clz = Class.forName("com.danhuang.server.basic.Iphone");

		// 创建对象
		Iphone iphone = (Iphone) clz.newInstance();// 不推荐
		System.out.println(iphone);

		Iphone iphone2 = (Iphone) clz.getConstructor().newInstance();// 推荐
		System.out.println(iphone2);
	}
}

class Iphone {
	public Iphone() {

	}
}
