package com.danhuang.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 第一个ioStream程序：理解操作的步骤 
 * 1、创建源 
 * 2、选择流 
 * 3、操作 
 * 4、释放资源
 * 
 * @author danhuang
 *
 */
public class IOStream1 {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("label.txt");
		// 2.选择流
		try {
			InputStream inputStream = new FileInputStream(src);
			// 3.操作（读取）
			int data1 = inputStream.read();// 第一个数据 h
			int data2 = inputStream.read();// 第二个数据e
			int data3 = inputStream.read();// 第三个数据l
			int data4 = inputStream.read();//没有第四个数据
			System.out.println((char)data1);
			System.out.println((char)data2);
			System.out.println((char)data3);
			System.out.println(data4);//负一表示没有数据，文件的末尾返回-1
			
			//4.释放资源
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
