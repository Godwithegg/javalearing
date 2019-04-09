package com.danhuang.highio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件字节输入流 加入缓冲流
 * @author danhuang
 *
 */
public class BufferedInputStreamDemo {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("label2.txt");
		InputStream bis = null;
		// 2.选择流
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			// 3.操作（读取）
			byte[] car = new byte[1024];
			int temp = -1;
			while ((temp = bis.read(car)) != -1) {
				//字节数组 -->字符串（解码）
				String str = new String(car,0,temp);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.释放资源,buffered内部会自动释放inputstream
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
