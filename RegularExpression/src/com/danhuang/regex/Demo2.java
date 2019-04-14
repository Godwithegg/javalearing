package com.danhuang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 测试正则表达式中的分组处理
 * @author danhuang
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
		Matcher m = p.matcher("woshi123**shi*shi123");
		
		//替换
		String newStr = m.replaceAll("#");
		System.out.println(newStr);
		 
	}
}
