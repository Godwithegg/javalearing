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
public class Copy {
	public static void main(String[] args) {
		copy("label2.txt","dest.txt");
	}

	public static void copy(String srcPath, String destPath) {
		// 1.创建源
		File src = new File(srcPath);// 源头
		File dest = new File(destPath);// 目的地
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
			closeStream(outputStream,inputStream);
		}

	}

	public static void closeStream(Closeable... o) {
		for (Closeable closeable : o) {
			try {
				if (closeable != null) {
					closeable.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
