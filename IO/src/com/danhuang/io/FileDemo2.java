package com.danhuang.io;

import java.io.File;

/**
 * ����File����
 * 
 * @author danhuang
 *
 */
public class FileDemo2 {
	public static void main(String[] args) {
		
		String path = "D:/github/javalearning/javalearing/IO/cat.png";
		//1.����file����
		File src = new File(path);
		System.out.println(src.length());
		//2.����file����
		src = new File("D:/github/javalearning/javalearing","IO/cat.png");
		System.out.println(src.length());
		//3.����file����
		src = new File(new File("D:/github/javalearning/javalearing"),"IO/cat.png");
		System.out.println(src.length());
	}
}
