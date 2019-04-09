package com.danhuang.iostream;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件拷贝 
 * 
 * @author danhuang
 *
 */
public class FileUtils {
	public static void main(String[] args) {
		copy("label2.txt", "dest.txt");
	}

	public static void copy(String srcPath, String destPath) {
		// 1.创建源
		File src = new File(srcPath);// 源头
		File dest = new File(destPath);// 目的地
		// 2.选择流
		try (FileInputStream inputStream = new FileInputStream(src);
				FileOutputStream outputStream = new FileOutputStream(dest);) {

			// 3.操作（读取）
			byte[] flush = new byte[1024];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = inputStream.read(flush)) != -1) {
				outputStream.write(flush, 0, len);
			}
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
