package com.danhuang.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jdk.internal.org.xml.sax.InputSource;

/**
 * 文件字节输入、输出流 操作的步骤 1、创建源 2、选择流 3、操作 4、释放资源
 * 
 * @author danhuang
 *
 */
public class IOStream5 {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("label2.txt");// 源头
		File dest = new File("dest.txt");// 目的地
		// 2.选择流
		OutputStream outputStream = null;
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(src);
			outputStream = new FileOutputStream(dest);
			// 3.操作（读取）
			byte[] flush = new byte[1024];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = inputStream.read(flush)) != -1) {
				outputStream.write(flush, 0, len);
			}
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.释放资源
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
