package com.danhuang.highio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

/**
 * 文件字符输出流 操作的步骤 1、创建源 2、选择流 3、操作 4、释放资源 加入了缓冲流
 * 
 * @author danhuang
 *
 */
public class BufferedWriterDemo {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("label2.txt");
		// 2.选择流
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(src));
			// 3.操作（读取）
			String msg = "IO is so easy.";

			// 写法一
			// char[] datas = msg.toCharArray();
			// writer.write(datas, 0, datas.length);
			// writer.flush();

			// 写法二
			// writer.write(msg);
			// writer.flush();

			// 写法三
			writer.append(msg);
			writer.newLine();
			writer.append("I am handsome");
			writer.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.释放资源
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
