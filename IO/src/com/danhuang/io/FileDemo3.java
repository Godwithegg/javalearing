package com.danhuang.io;

import java.io.File;

/**
 * 绝对路径与相对路径
 * 
 * @author danhuang
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		
		String path = "D:/github/javalearning/javalearing/IO/cat.png";
		
		//绝对路径
		File src = new File(path);
		System.out.println(src.getAbsolutePath());
		
		//相对路径
		//用户的目录
		System.out.println(System.getProperty("user.dir"));
		src = new File("cat.png");
		System.out.println(src.getAbsolutePath());
		
		//构建一个不存在的文件
		src = new File("aaa/cat.png");
		System.out.println(src.getAbsolutePath());
		
	}
}
