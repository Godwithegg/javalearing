package com.danhuang.io;

import java.io.File;
import java.io.IOException;

/**
 * 递归：方法自己调用自己 递归头：何时结束递归 递归体：重复调用 打印子孙级目录和文件的名称
 * 
 * @author danhuang
 *
 */
public class FileDemo8 {
	public static void main(String[] args) throws IOException {

		String path = "D:/github/javalearning/javalearing/IO";
		File src = new File(path);

		printName(src, 0);

	}

	// 打印子孙级目录和名称
	public static void printName(File src, int deep) {
		// 控制层次感
		for (int i = 0; i < deep; i++)
			System.out.print("-");
		// 打印名称
		System.out.println(src.getName());
		if (src == null || !src.exists()) {// 递归头
			return;
		} else if (src.isDirectory()) {// 目录
			for (File s : src.listFiles()) {
				printName(s, deep + 1);// 递归体
			}
		}
	}

}
