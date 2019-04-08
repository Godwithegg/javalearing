package com.danhuang.io;

import java.io.File;

/**
 * File文件表示
 * 
 * @author danhuang
 *
 */
public class FileDemo1 {
	public static void main(String[] args) {
		String path = "D:\\github\\javalearning\\javalearing\\IO\\cat.png";

		// 建议 将\改为/
		path = "D:/github/javalearning/javalearing/IO/cat.png";
		// 常量拼接
		path = "D:" + File.separator + "github" + File.separator + "javalearning" + File.separator + "javalearning"
				+ File.separator + "IO" + File.separator + "cat.png";
		System.out.println(path);
	}
}
