package com.danhuang.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 分段读取
 * 操作的步骤 1、创建源 2、选择流 3、操作 4、释放资源
 * 
 * @author danhuang
 *
 */
public class IOStream3 {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("label2.txt");
		InputStream inputStream = null;
		// 2.选择流
		try {
			inputStream = new FileInputStream(src);
			// 3.操作（读取）
			byte[] car = new byte[3];
			int temp = -1;
			while ((temp = inputStream.read(car)) != -1) {
				//字节数组 -->字符串（解码）
				String str = new String(car,0,temp);
				System.out.println(str);
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
