package com.danhuang.reflection;

/**
 * Class对象的获取方式
 * @author danhuang
 *
 */
@SuppressWarnings("all")
public class Demo1 {
	
	public static void main(String[] args) {
		String path = "com.danhuang.reflection.bean.User";
		
		try {
			Class clz = Class.forName(path);
			//对象是表示或封装数据一些数据，一个类被加载后，JVM会创建一个对应类的Class对象，类的整个结构信息会被放到对应的Class对象中
			//这个Class对象就像是一面镜子一样，通过这面镜子我们可以看到对应类的全部信息
			System.out.println(clz);
			
			Class clz2 = Class.forName(path);//一个类只对应一个Class对象（反射对象）
			System.out.println(clz.hashCode() == clz2.hashCode());
			
			Class strClz = String.class;
			Class strClz2 = path.getClass();
			System.out.println(strClz.hashCode() == strClz2.hashCode());
			
			int[] arr01 = new int[10];
			int[] arr02 = new int[30];
			System.out.println(arr01.getClass().hashCode() == arr02.getClass().hashCode());//比较的是维度和类型,只跟几维，类型有关系
			
			int[][] arr03 = new int[10][10];
			System.out.println(arr01.getClass().hashCode() == arr03.getClass().hashCode());
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
}
