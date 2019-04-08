package com.danhuang.io;

import java.io.File;
import java.io.IOException;

/**
 * 创建和删除文件
 * createNewFile():不存在才创建成功，存在则创建失败
 * delete():删除文件
 * @author danhuang
 *
 */
public class FileDemo6 {
	public static void main(String[] args) throws IOException {

		String path = "D:/github/javalearning/javalearing/IO/cat.png";
		File src = new File(path);
		
		boolean flag = src.createNewFile();
		//文件已经存在因此为false
		System.out.println(flag);
		
		//此时表示的不是文件夹，而是一个名为IO1的文件
		src = new File("D:/github/javalearning/javalearing/IO1");
		flag = src.createNewFile();
		//不存在IO1文件，因此创建了该文件，为true
		System.out.println(flag);

		flag = src.delete();
		System.out.println(flag);
		
		//补充
		//像con com3等操作系统的设备名，不能够正确创建
		src = new File("D:/github/javalearning/javalearing/IO/con");
		flag = src.createNewFile();
		System.out.println(flag);
	}
}
