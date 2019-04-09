package com.danhuang.commonsio;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class ReadFile {
	public static void main(String[] args) throws IOException {
		// 读取文件
		String msg = FileUtils.readFileToString(new File("label.txt"), "utf-8");
		System.out.println(msg);
		byte[] datas = FileUtils.readFileToByteArray(new File("label.txt"));
		System.out.println(datas.length);

		// 逐行读取
		List<String> msgs = FileUtils.readLines(new File("label.txt"), "utf-8");
		for (String string : msgs) {
			System.out.println(string);
		}
		LineIterator it = FileUtils.lineIterator(new File("label.txt"), "utf-8");
		while (it.hasNext()) {
			System.out.println(it.nextLine());
		}
	}
}
