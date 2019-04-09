package com.danhuang.io;

import java.io.UnsupportedEncodingException;

/**
 * 解码：字节-->字符串
 * 
 * @author danhuang
 *
 */
public class ContentDecode {
	public static void main(String[] args) throws UnsupportedEncodingException {

		String msg = "性命生命使命a";
		// 编码:字节数组
		byte[] datas = msg.getBytes();// 默认使用工程的字符集

		// 解码：字符串
		msg = new String(datas, 0, datas.length,"utf8");
		System.out.println(msg);
		
		/**
		 * 乱码：
		 * 1）字节数不够
		 */
		msg = new String(datas, 0, datas.length-2,"utf8");
		System.out.println(msg);
		
		/**
		 * 乱码：
		 * 2）字符集不统一
		 */
		msg = new String(datas, 0, datas.length,"GBK");
		System.out.println(msg);
		
	}
}
