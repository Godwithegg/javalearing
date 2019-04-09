package com.danhuang.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * 文件字符输入流 操作的步骤 1、创建源 2、选择流 3、操作 4、释放资源
 * 
 * @author danhuang
 *
 */
public class IOStream6 {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("label2.txt");
		// 2.选择流
		Reader reader = null;
		try {
			reader = new FileReader(src);
			// 3.操作（读取）
			char[] flush = new char[1024];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = reader.read(flush)) != -1) {
				// 字符串组-->字符串
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.释放资源
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
