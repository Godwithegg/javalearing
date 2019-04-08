package com.danhuang.io;

import java.io.File;
import java.io.IOException;

/**
 * 使用递归统计文件夹的大小
 * 
 * @author danhuang
 *
 */
public class FileDemo9 {
	private static long size;

	public static void main(String[] args) throws IOException {

		String path = "D:/github/javalearning/javalearing/IO";
		File src = new File(path);

		count(src);
		System.out.println(size);

	}

	// 打印子孙级目录和名称
	public static void count(File src) {
		// 获取大小
		if (src == null || !src.exists()) {// 递归头
			return;
		} else if (src.isDirectory()) {// 目录
			for (File s : src.listFiles()) {
				count(s);// 递归体
			}
		} else {
			size += src.length();
		}
	}

}
