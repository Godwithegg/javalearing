package com.danhuang.highio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 转换流：InputStreamReader OutputStreamWriter 1、以字符流的形式操作字节流（纯文本的） 2、指定字符集
 * 
 * @author danhuang
 *
 */
public class ConvertDemo2 {

	public static void main(String[] args) {
		// 操作网络流 下载百度的源代码
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new URL("http://www.baidu.com").openStream(), "utf-8"));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("baidu.html"),"utf-8"));) {
			String data = "";
			while((data = reader.readLine()) != null) {
				writer.write(data);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("操作异常");
		} finally {

		}
	}

	// 解决了中文乱码,但是转化速度慢
	public static void test2() {
		// 操作网络流 下载百度的源代码
		try (InputStreamReader is = new InputStreamReader(new URL("http://www.baidu.com").openStream(), "utf-8");) {
			// 读取
			int temp;
			while ((temp = is.read()) != -1) {
				System.out.print((char) temp);
			}
		} catch (IOException e) {
			System.out.println("操作异常");
		} finally {

		}
	}

	// 中文会乱码
	public static void test1() {
		// 操作网络流 下载百度的源代码
		try (InputStream is = new URL("http://www.baidu.com").openStream();) {
			// 读取
			int temp;
			while ((temp = is.read()) != -1) {
				System.out.print((char) temp);
			}
		} catch (IOException e) {
			System.out.println("操作异常");
		} finally {

		}
	}
}
