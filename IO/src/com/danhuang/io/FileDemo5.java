package com.danhuang.io;

import java.io.File;

/**
 * 判断文件是否存在
 * 
 * @author danhuang
 *
 */
public class FileDemo5 {
	public static void main(String[] args) {

		String path = "D:/github/javalearning/javalearing/IO/cat.png";
		File src = new File(path);

		// 文件状态
		if (src == null || !src.exists()) {
			System.out.println("文件不存在");
		} else {
			if (src.isFile()) {
				System.out.println("文件操作");
			} else {
				System.out.println("文件夹操作");
			}
		}

	}
}
