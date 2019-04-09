package com.danhuang.highio;

import java.io.BufferedReader;
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
 * 文件字符输入流 操作的步骤 1、创建源 2、选择流 3、操作 4、释放资源 加入了缓冲流
 * 
 * @author danhuang
 *
 */
public class BufferedReaderDemo {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("label2.txt");
		// 2.选择流
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(src));
			// 3.操作（读取）
			String line = null;
			while ((line = reader.readLine()) != null) {
				// 字符串组-->字符串
				System.out.println(line);
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
