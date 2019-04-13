package com.danhuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.danhuang.reflection.bean.User;

/**
 * 通过反射api动态的操作：构造器，方法，属性
 * 
 * @author danhuang
 *
 */
public class Demo3 {

	public static void main(String[] args) {
		String path = "com.danhuang.reflection.bean.User";

		try {
			Class<User> clz = (Class<User>) Class.forName(path);
			// 通过动态调用构造方法，构造对象
			User u = clz.newInstance();
			System.out.println(u);
			
			Constructor<User> c = clz.getDeclaredConstructor(int.class,int.class,String.class);
			User u2 = c.newInstance(1001,18,"蛋黄");
			System.out.println(u2.getUname());
			
			//通过反射api调用普通方法
			User u3 = clz.newInstance();
			Method method = clz.getDeclaredMethod("setUname", String.class);
			method.invoke(u3, "蛋黄派");
			System.out.println(u3.getUname());
			
			//通过反射api操作属性
			User u4 = clz.newInstance();
			Field f = clz.getDeclaredField("uname");
			f.setAccessible(true);//这个属性不需要安全检查了 ，可以直接访问
			f.set(u4, "蛋黄仔");//通过反射直接写属性
			System.out.println(u4.getUname());//通过反射直接读属性的值
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
