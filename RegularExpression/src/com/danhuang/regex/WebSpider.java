package com.danhuang.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫取出数据
 * 获得页面所有的超链接
 * 市面上有较好的爬虫软件：wget...
 * 
 * @author danhuang
 *
 */
public class WebSpider {
	/**
	 * 获得urlString对应的网页源码内容
	 * @param args
	 */
	public static String getURLContent(String urlStr,String charset) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(charset)));
			String temp = "";
			while((temp = reader.readLine()) != null) {
				sb.append(temp);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();

	}
	
	public static List<String> getMatherSubStrs(String destStr,String regexStr){
		
		Pattern p = Pattern.compile(regexStr);
		Matcher m = p.matcher(destStr);
		List<String> result = new ArrayList<>();
		while(m.find()) {
			result.add(m.group(1));
		}
		return result;
	}
	public static void main(String[] args) {
		String destStr = getURLContent("http://www.163.com","gbk");
		//System.out.println(destStr); //打印页面的源码
		
//		Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");//取到的超链接的整个内容
		
		List<String> result = getMatherSubStrs(destStr, "href=\"([\\w\\s./:]+?)\"");
		for (String string : result) {
			System.out.println(string);
		}
	}
}
