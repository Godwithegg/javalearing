package com.danhuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的api获取类的信息（类的名字，属性，方法，构造器）
 * 
 * @author danhuang
 *
 */
public class Demo2 {
	private static Field[] fields;

	public static void main(String[] args) {
		String path = "com.danhuang.reflection.bean.User";

		try {
			Class clz = Class.forName(path);
			
			//获取类的名字
			System.out.println(clz.getName());//获得包名.类名
			System.out.println(clz.getSimpleName());//获得类名
			
			//获得属性信息
			fields = clz.getFields();//只能获得public的field
			Field[] declaredFields = clz.getDeclaredFields();//返回所有的属性
			Field declaredField = clz.getDeclaredField("uname");
			System.out.println(fields.length);
			System.out.println(declaredFields.length);
			for (Field field : declaredFields) {
				System.out.println("属性"+field);
			}
			//获得方法信息 同上
			Method[] methods = clz.getMethods();
			Method[] declaredMethods = clz.getDeclaredMethods();
			Method declaredMethod = clz.getDeclaredMethod("getUname", null);
			Method declaredMethod2 = clz.getDeclaredMethod("setUname", String.class);//如果方法有参必须传递参数类型对应Class对象
			for (Method method : declaredMethods) {
				System.out.println("方法"+method);
			}
			
			//获得构造信息
			Constructor[] declaredConstructors = clz.getDeclaredConstructors();//获得所有的构造器
			Constructor declaredConstructor = clz.getDeclaredConstructor(null);
			System.out.println("获得无参构造器"+declaredConstructor);
			Constructor declaredConstructor2 = clz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println("获得带参构造器"+declaredConstructor2);
			for (Constructor constructor : declaredConstructors) {
				System.out.println("构造器"+constructor);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
