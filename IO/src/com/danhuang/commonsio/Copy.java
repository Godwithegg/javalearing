package com.danhuang.commonsio;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Copy {
	public static void main(String[] args) throws IOException {
//		//复制文件
//		FileUtils.copyFile(new File("cat.png"), new File("copycat.png"));
//		//复制文件到目录
//		FileUtils.copyFileToDirectory(new File("cat.png"), new File("src/com/danhuang/commonsio"));
		//复制目录到目录
//		FileUtils.copyDirectoryToDirectory(new File("src/com/danhuang/commonsio"), new File("src"));
		//复制目录成为子目录
//		FileUtils.copyDirectory(new File("src/com/danhuang/commonsio"), new File("src"));
		//拷贝URL内容
//		FileUtils.copyURLToFile(new URL("http://www.baidu.com"), new File("label2.txt"));
		String string = IOUtils.toString(new URL("http://www.baidu.com"),"UTF-8");
		System.out.println(string);
	}
}
