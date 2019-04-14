package com.danhuang.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密工具类
 * 
 * @author danhuang
 *
 */
public class EncrpUtil {
	public static void main(String[] args) {
		encrpt("D:/github/javalearning/javalearing/JVM/TestClass.class", "D:/github/javalearning/javalearing/JVM/temp/TestClass.class");
	}
	public static void encrpt(String src, String dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			int temp = -1;
			while ((temp = fis.read()) != -1) {
				fos.write(temp ^ 0xff);// 取反操作
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
