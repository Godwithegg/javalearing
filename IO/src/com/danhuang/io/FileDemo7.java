package com.danhuang.io;

import java.io.File;
import java.io.IOException;

/**
 * 创建和删除文件夹
 * mkdir():确保上级目录存在，不存在则创建失败
 * mkdirs():上级目录可以不存在，不存在则一同创建
 * @author danhuang
 *
 */
public class FileDemo7 {
	public static void main(String[] args) throws IOException {

		String path = "D:/github/javalearning/javalearing/IO";
		File dir = new File(path);
		
		//列出下级名称 list
		String[] subNames = dir.list();
		for (String string : subNames) {
			System.out.println(string);
		}
		
		//列出下级File对象
		File[] subFiles = dir.listFiles();
		for (File file : subFiles) {
			System.out.println(file.getAbsolutePath());
		}
		
		//所有盘符
		File[] roots = dir.listRoots();
		for (File file : roots) {
			System.out.println(file.getAbsolutePath());
		}
		
	}
}
