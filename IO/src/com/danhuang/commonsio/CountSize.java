package com.danhuang.commonsio;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * 统计文件文件夹大小
 * 
 * @author danhuang
 *
 */
public class CountSize {
	public static void main(String[] args) {
		// 文件大小
		long len = FileUtils.sizeOf(new File("label.txt"));
		System.out.println(len);
		// 目录大小
		len = FileUtils.sizeOf(new File("src"));
		System.out.println(len);
	}
}
