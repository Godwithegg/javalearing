package com.danhuang.jvm;

/**
 * 测试简单加密解密（取反）操作
 * @author danhuang
 *
 */
public class Demo4 {
	public static void main(String[] args) throws Exception {
		//测试取反操作
//		int a = 3;//00000011
//		System.out.println(Integer.toBinaryString(a^0xff));

		//解密加密后的class文件，正常的类加载器无法加载，报classformaterror
//		FileSystemClassLoader loader = new FileSystemClassLoader("D:/github/javalearning/javalearing/JVM/temp");
//
//		Class<?> c = loader.loadClass("TestClass");
//		System.out.println(c);
		
		DecrptClassLoader loader = new DecrptClassLoader("D:/github/javalearning/javalearing/JVM/temp");
		Class<?> c = loader.loadClass("TestClass");
		System.out.println(c);
	}
}
