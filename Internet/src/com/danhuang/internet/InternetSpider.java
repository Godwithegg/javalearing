package com.danhuang.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络爬虫原理
 * 可能爬不了，但是只要能用浏览器访问，我们可以采用策略2来解决
 * 
 * @author danhuang
 *
 */
public class InternetSpider {
	
	public static void main(String[] args) throws IOException {
		spider();
		parrtern();
	}
	
	//普通爬虫
	public static void spider() throws IOException {
		// 获取URL
		URL url = new URL("https://www.jd.com");
		// 下载资源
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		String msg = null;
		while ((msg = br.readLine()) != null) {
			System.out.println(msg);
		}
		br.close();
		// 分析（略
		//处理（略
	}

	// 模拟浏览器来强行爬虫
	public static void parrtern() throws IOException {
		// 获取URL
		URL url = new URL("https://www.dianping.com");
		// 下载资源
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		String msg = null;
		while ((msg = br.readLine()) != null) {
			System.out.println(msg);
		}
		br.close();
		// 分析（略
		// 处理（略
	}
}
