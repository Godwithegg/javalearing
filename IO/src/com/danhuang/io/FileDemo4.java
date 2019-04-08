package com.danhuang.io;

import java.io.File;

/**
 * api使用
 * 
 * @author danhuang
 *
 */
public class FileDemo4 {
	public static void main(String[] args) {
		
		String path = "D:/github/javalearning/javalearing/IO/cat.png";
		File src = new File(path);
		
		//基本操作
		System.out.println("名称:" + src.getName());
		System.out.println("路径:" + src.getPath());
		System.out.println("绝对路径:" + src.getAbsolutePath());
		System.out.println("父路径:" + src.getParent());
		System.out.println("父对象:" + src.getParentFile().getName());
		
	}
}
