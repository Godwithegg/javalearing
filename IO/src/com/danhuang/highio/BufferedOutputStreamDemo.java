package com.danhuang.highio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件字节输出流 操作的步骤 1、创建源 2、选择流 3、操作 4、释放资源 加入缓冲流
 * 
 * @author danhuang
 *
 */
public class BufferedOutputStreamDemo {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("label2.txt");
		// 2.选择流
		OutputStream outputStream = null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream(src));
			// 3.操作（读取）
			String msg = "IO is so easy.";
			byte[] datas = msg.getBytes();
			outputStream.write(datas, 0, datas.length);
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
		}

	}
}
