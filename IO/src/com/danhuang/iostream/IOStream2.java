package com.danhuang.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 逐个读取
 * 理解操作的步骤 1、创建源 2、选择流 3、操作 4、释放资源
 * 
 * @author danhuang
 *
 */
public class IOStream2 {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("label.txt");
		InputStream inputStream = null;
		// 2.选择流
		try {
			inputStream = new FileInputStream(src);
			// 3.操作（读取）
			int temp;
			while ((temp = inputStream.read()) != -1) {
				System.out.println((char) temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.释放资源
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
