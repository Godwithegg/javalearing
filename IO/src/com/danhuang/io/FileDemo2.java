package com.danhuang.io;

import java.io.File;

/**
 * 构建File对象
 * 
 * @author danhuang
 *
 */
public class FileDemo2 {
	public static void main(String[] args) {
		
		String path = "D:/github/javalearning/javalearing/IO/cat.png";
		//1.构建file对象
		File src = new File(path);
		System.out.println(src.length());
		//2.构建file对象
		src = new File("D:/github/javalearning/javalearing","IO/cat.png");
		System.out.println(src.length());
		//3.构建file对象
		src = new File(new File("D:/github/javalearning/javalearing"),"IO/cat.png");
		System.out.println(src.length());
	}
}
