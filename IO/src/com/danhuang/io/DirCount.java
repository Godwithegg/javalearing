package com.danhuang.io;

import java.io.File;
import java.io.IOException;

/**
 * 使用面对对象：统计文件夹的大小
 * 
 * @author danhuang
 *
 */
public class DirCount {
	// 大小
	private static long size;
	// 文件夹路径
	private String path;
	// 源
	private File src;

	public DirCount(String path) {
		this.path = path;
		this.src = new File(path);
		count(this.src);
	}

	public static void main(String[] args) throws IOException {

		String path = "D:/github/javalearning/javalearing/IO";

		DirCount dirCount = new DirCount(path);
		System.out.println(dirCount.getSize());
	}

	public static long getSize() {
		return size;
	}

	public static void setSize(long size) {
		DirCount.size = size;
	}

	// 统计大小
	private void count(File src) {
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
