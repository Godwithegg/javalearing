package com.danhuang.commonsio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 写出内容
 * @author danhuang
 *
 */
public class WriterFile {
	public static void main(String[] args) throws IOException {
		//写出文件 最后一个参数表示是否追加文件
		FileUtils.write(new File("label2.txt"), "good good study 嗯\r\n","utf-8",true);
		FileUtils.writeByteArrayToFile(new File("label2.txt"), "good good study 嗯".getBytes("utf-8"),true);
		
		//写出列表
		List<String> datas = new ArrayList<>();
		datas.add("马云");
		datas.add("马化腾");
		
		FileUtils.writeLines(new File("label2.txt"), datas,"...",true);//...每个元素的连接符
	}
}
